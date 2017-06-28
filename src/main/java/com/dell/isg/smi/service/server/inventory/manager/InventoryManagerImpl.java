/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import com.dell.isg.smi.adapter.server.IServerAdapter;
import com.dell.isg.smi.adapter.server.IServerDeviceHardwareAdapter;
import com.dell.isg.smi.adapter.server.model.HardwareInventory;
import com.dell.isg.smi.adapter.server.model.IdracDetail;
import com.dell.isg.smi.adapter.server.model.WsmanCredentials;
import com.dell.isg.smi.commons.elm.exception.RuntimeCoreException;
import com.dell.isg.smi.commons.utilities.CustomRecursiveToStringStyle;
import com.dell.isg.smi.commons.model.common.Credential;
import com.dell.isg.smi.commons.model.common.Defaults;
import com.dell.isg.smi.commons.model.common.InventoryCallbackRequest;
import com.dell.isg.smi.commons.model.common.InventoryCallbackResponse;
import com.dell.isg.smi.commons.model.common.InventoryInformation;
import com.dell.isg.smi.commons.model.common.Options;
import com.dell.isg.smi.commons.model.server.inventory.ServerHardwareInventory;
import com.dell.isg.smi.service.server.exception.EnumErrorCode;
import com.dell.isg.smi.service.server.inventory.Transformer.TranformerUtil;
import com.dell.isg.smi.service.server.inventory.manager.thread.ServerInventoryCollectionThread;
import com.dell.isg.smi.wsman.command.entity.BootOrderDetails;
import com.dell.isg.smi.wsman.command.entity.DCIMBIOSConfig;
import com.dell.isg.smi.wsman.command.entity.DCIMNICViewType;
import com.dell.isg.smi.wsman.command.entity.DCIMSoftwareIdentityType;
import com.dell.isg.smi.wsman.command.entity.DCIMSystemViewType;
import com.dell.isg.smi.wsman.command.entity.IDRACCardStringView;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public class InventoryManagerImpl implements IInventoryManager {

    @Autowired
    IServerAdapter serverAdapterImpl;

    @Autowired
    IServerDeviceHardwareAdapter serverDeviceHardwareAdapterImpl;

    private static final int SERVER_INVENTORY_THREAD_POOL = 1000;

    private static final Logger logger = LoggerFactory.getLogger(InventoryManagerImpl.class.getName());


    @Override
    public List<InventoryInformation> inventory(Set<String> ips) throws Exception {
        List<InventoryInformation> serverInfos = new ArrayList<InventoryInformation>();
        for (String validIp : ips) {
            InventoryInformation serverInfo = new InventoryInformation();
            serverInfo.setIpAddress(validIp);
            serverInfo.setCredential(new Credential());
            serverInfos.add(serverInfo);
        }
        return getInventory(serverInfos);
    }


    private List<InventoryInformation> getInventory(List<InventoryInformation> serverInfos) {
        logger.trace("Started inventory threads");
        logger.trace(" IDRAC Server count for inventory = " + serverInfos.size());
        StopWatch watch = new StopWatch();
        watch.start();
        if (serverInfos.size() > 0) {
            ExecutorService executor = Executors.newFixedThreadPool(SERVER_INVENTORY_THREAD_POOL);
            for (InventoryInformation serverInfo : serverInfos) {
                Runnable serverDiscoverTask = new ServerInventoryCollectionThread(serverInfo, serverAdapterImpl);
                executor.execute(serverDiscoverTask);
            }
            executor.shutdown();
            try {
                executor.awaitTermination(60, TimeUnit.SECONDS);
                executor.shutdownNow();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        watch.stop();
        logger.trace("Finished server inventory threads.");
        logger.trace("Time taken for inventory in seconds: " + watch.getTotalTimeSeconds());
        return serverInfos;
    }


    @Override
    @Async
    public void processInventoryCallback(InventoryCallbackRequest inventoryCallbackRequest) {
        String type = inventoryCallbackRequest.getType();
        try {
            Object dataObject = getInventoryObject(type, inventoryCallbackRequest.getCredential());
            InventoryCallbackResponse inventoryCallbackResponse = createCallbackResponse(dataObject, type, inventoryCallbackRequest.getCallbackGraph());
            logger.trace("Inventory callback response : ", ReflectionToStringBuilder.toString(dataObject, new CustomRecursiveToStringStyle(99)));
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<InventoryCallbackResponse> entity = new HttpEntity<InventoryCallbackResponse>(inventoryCallbackResponse, headers);
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(inventoryCallbackRequest.getCallbackUri(), entity, String.class);
            logger.debug("Response recived after posting to URI : " + responseEntity.getBody());
        } catch (Exception e) {
            logger.error("Exception occured in discovery : ", e);
            RuntimeCoreException runtimeCoreException = new RuntimeCoreException(e);
            runtimeCoreException.setErrorCode(EnumErrorCode.ENUM_SERVER_ERROR);
            throw runtimeCoreException;
        }
    }


    private InventoryCallbackResponse createCallbackResponse(Object dataObject, String type, String graphName) throws JsonProcessingException {
        InventoryCallbackResponse inventoryCallbackResponse = new InventoryCallbackResponse();
        inventoryCallbackResponse.setName(graphName);
        Defaults defaults = new Defaults();
        defaults.setType(type);
        defaults.setData(dataObject);
        Options options = new Options();
        options.setDefaults(defaults);
        inventoryCallbackResponse.setOptions(options);
        return inventoryCallbackResponse;
    }


    private Object getInventoryObject(String type, Credential cred) throws Exception {
        WsmanCredentials credential = new WsmanCredentials(cred.getAddress(), cred.getUserName(), cred.getPassword());
        ServerInventoryCallbackTypeEnum typeEnum = ServerInventoryCallbackTypeEnum.getEnum(type);
        if (typeEnum == null) {
            RuntimeCoreException runtimeCoreException = new RuntimeCoreException("Not a Valid Enum type.");
            runtimeCoreException.setErrorCode(EnumErrorCode.ENUM_SERVER_ERROR);
            throw runtimeCoreException;
        }

        switch (typeEnum) {
        case HARDWARE:
            return TranformerUtil.transformHardwareInventory(serverAdapterImpl.collectHardwareInventory(credential), new ServerHardwareInventory(credential.getAddress()));
        case NICS:
            //return TranformerUtil.transformHwNic(serverAdapterImpl.collectNics(credential));
        	serverAdapterImpl.collectNics(credential);
        case SOFTWARE:
            return serverAdapterImpl.enumerateDcimSoftwareIdentity(credential);
        case SYSTEM:
            return TranformerUtil.transformHwSystem(serverAdapterImpl.collectSystemInfo(credential));
        case BIOS:
            return serverDeviceHardwareAdapterImpl.collectBiosConfig(credential);
        case BOOT:
            return serverDeviceHardwareAdapterImpl.getBootOrderDetails(credential);
        case SELLOG:
            return serverAdapterImpl.getServerSelLogEntries(credential);
        case LCLOG:
            return serverAdapterImpl.getServerLcLogEntries(credential);
        case MANAGER:
            //return TranformerUtil.transformIdracString(serverAdapterImpl.collectIdracString(credential));
        	return serverAdapterImpl.collectIdracDetails(credential);
        }
        return null;
    }


    @Override
    public InventoryCallbackResponse dummy(InventoryCallbackRequest inventoryCallbackRequest) {
        InventoryCallbackResponse inventoryCallbackResponse = null;
        try {
            Object dataObject = getInventoryObject(inventoryCallbackRequest.getType(), inventoryCallbackRequest.getCredential());
            inventoryCallbackResponse = createCallbackResponse(dataObject, inventoryCallbackRequest.getType(), inventoryCallbackRequest.getCallbackGraph());
        } catch (Exception e) {
            logger.error("Exception occured in discovery : ", e);
            RuntimeCoreException runtimeCoreException = new RuntimeCoreException(e);
            runtimeCoreException.setErrorCode(EnumErrorCode.ENUM_SERVER_ERROR);
            throw runtimeCoreException;
        }
        logger.trace("Hardware inventory Response : ", ReflectionToStringBuilder.toString(inventoryCallbackResponse, new CustomRecursiveToStringStyle(99)));
        return inventoryCallbackResponse;
    }


    @Override
    public HardwareInventory collectHardwareInventory(WsmanCredentials wsmanCredentials) throws Exception {
        return serverAdapterImpl.collectHardwareInventory(wsmanCredentials);
    }


    @Override
    public DCIMSystemViewType collectSystemInfo(WsmanCredentials wsmanCredentials) throws Exception {
        return serverAdapterImpl.collectSystemInfo(wsmanCredentials);
    }


    @Override
    public List<DCIMSoftwareIdentityType> enumerateDcimSoftwareIdentity(WsmanCredentials wsmanCredentials) throws Exception {
        return serverAdapterImpl.enumerateDcimSoftwareIdentity(wsmanCredentials);
    }


    @Override
    public Object collectNics(WsmanCredentials wsmanCredentials) throws Exception {
        return serverAdapterImpl.collectNics(wsmanCredentials);
    }


    @Override
    public DCIMBIOSConfig collectBiosConfig(WsmanCredentials wsmanCredentials) throws Exception {
        return serverDeviceHardwareAdapterImpl.collectBiosConfig(wsmanCredentials);
    }


    @Override
    public BootOrderDetails getBootOrderDetails(WsmanCredentials wsmanCredentials) throws Exception {
        return serverDeviceHardwareAdapterImpl.getBootOrderDetails(wsmanCredentials);
    }
    
    @Override
    public Object getIdracStringView(WsmanCredentials wsmanCredentials) throws Exception {
        return serverAdapterImpl.collectIdracString(wsmanCredentials);
    }

    @Override
    public Object getIdracCardEnum(WsmanCredentials wsmanCredentials) throws Exception {
        return serverAdapterImpl.collectIdracCardEnum(wsmanCredentials);
    }

    @Override
    public Object getIdracDetails(WsmanCredentials wsmanCredentials) throws Exception {
        return serverAdapterImpl.collectIdracDetails(wsmanCredentials);
    }

}
