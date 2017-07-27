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

import com.dell.isg.smi.adapter.server.inventory.IInventoryAdapter;
import com.dell.isg.smi.adapter.server.model.WsmanCredentials;
import com.dell.isg.smi.commons.elm.exception.RuntimeCoreException;
import com.dell.isg.smi.commons.model.common.Credential;
import com.dell.isg.smi.commons.model.common.Defaults;
import com.dell.isg.smi.commons.model.common.InventoryCallbackRequest;
import com.dell.isg.smi.commons.model.common.InventoryCallbackResponse;
import com.dell.isg.smi.commons.model.common.InventoryInformation;
import com.dell.isg.smi.commons.model.common.Options;
import com.dell.isg.smi.commons.utilities.CustomRecursiveToStringStyle;
import com.dell.isg.smi.service.server.exception.EnumErrorCode;
import com.dell.isg.smi.service.server.inventory.manager.thread.ServerInventoryCollectionThread2_0;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public class InventoryManagerImpl2_0 implements IInventoryManager2_0 {

    @Autowired
    IInventoryAdapter inventoryAdapterImpl;

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
                Runnable serverDiscoverTask = new ServerInventoryCollectionThread2_0(serverInfo, inventoryAdapterImpl);
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
            return inventoryAdapterImpl.collectHardwareInventory(credential);
        case NICS:
            return inventoryAdapterImpl.collectNics(credential);
        case SOFTWARE:
            return inventoryAdapterImpl.collectSoftware(credential);
        case SYSTEM:
            return inventoryAdapterImpl.collectSummary(credential);
        case BIOS:
            return inventoryAdapterImpl.collectBios(credential);
        case BOOT:
            return inventoryAdapterImpl.collectBoot(credential);
        case SELLOG:
            return inventoryAdapterImpl.collectSelLogs(credential);
        case LCLOG:
            return inventoryAdapterImpl.collectLcLogs(credential);
        case MANAGER:
            return inventoryAdapterImpl.collectIdracDetails(credential);
        }
        return null;
    }


    @Override
    public Object collectHardwareInventory(WsmanCredentials wsmanCredentials) throws Exception {
        return inventoryAdapterImpl.collectHardwareInventory(wsmanCredentials);
    }


    @Override
    public Object collectSummary(WsmanCredentials wsmanCredentials) throws Exception {
        return inventoryAdapterImpl.collectSummary(wsmanCredentials);
    }


    @Override
    public Object collectSoftware(WsmanCredentials wsmanCredentials) throws Exception {
        return inventoryAdapterImpl.collectSoftware(wsmanCredentials);
    }


    @Override
    public Object collectNics(WsmanCredentials wsmanCredentials) throws Exception {
        return inventoryAdapterImpl.collectNics(wsmanCredentials);
    }


    @Override
    public Object collectBios(WsmanCredentials wsmanCredentials) throws Exception {
        return inventoryAdapterImpl.collectBios(wsmanCredentials);
    }


    @Override
    public Object collectBoot(WsmanCredentials wsmanCredentials) throws Exception {
        return inventoryAdapterImpl.collectBoot(wsmanCredentials);
    }
    
    @Override
    public Object collectIdracString(WsmanCredentials wsmanCredentials) throws Exception {
        return inventoryAdapterImpl.collectIdracString(wsmanCredentials);
    }

    @Override
    public Object collectIdracCardEnum(WsmanCredentials wsmanCredentials) throws Exception {
        return inventoryAdapterImpl.collectIdracCardEnum(wsmanCredentials);
    }

    @Override
    public Object collectIdracDetails(WsmanCredentials wsmanCredentials) throws Exception {
        return inventoryAdapterImpl.collectIdracDetails(wsmanCredentials);
    }

    @Override
    public Object collect(WsmanCredentials wsmanCredentials, String dcim) throws Exception {
        return inventoryAdapterImpl.collect(wsmanCredentials, dcim);
    }

}
