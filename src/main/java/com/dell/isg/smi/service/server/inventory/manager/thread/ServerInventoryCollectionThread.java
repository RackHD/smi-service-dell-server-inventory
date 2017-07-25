/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.manager.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dell.isg.smi.adapter.server.IServerAdapter;
import com.dell.isg.smi.adapter.server.model.HardwareInventory;
import com.dell.isg.smi.adapter.server.model.WsmanCredentials;
import com.dell.isg.smi.commons.model.common.InventoryInformation;
import com.dell.isg.smi.commons.model.common.InventoryStatus;
import com.dell.isg.smi.commons.model.server.inventory.ServerHardwareInventory;
import com.dell.isg.smi.service.server.inventory.Transformer.TranformerUtil;

public class ServerInventoryCollectionThread implements Runnable {
    private InventoryInformation serverInfo;

    private IServerAdapter serverAdapterImpl;

    private static final Logger logger = LoggerFactory.getLogger(ServerInventoryCollectionThread.class.getName());


    public ServerInventoryCollectionThread(InventoryInformation info, IServerAdapter serverAdapterImpl) {
        this.serverInfo = info;
        this.serverAdapterImpl = serverAdapterImpl;
    }


    @Override
    public void run() {
        try {
            processCommand();
        } catch (Exception e) {
            logger.error(" Discovery Failed Reason for :" + e.getMessage());
        }
    }


    private void processCommand() throws Exception {
        serverInfo.setStatus(InventoryStatus.INPROGRESS.name());
        logger.trace("Started inventory for IP : ", serverInfo.getIpAddress());
        try {
            WsmanCredentials credential = new WsmanCredentials(serverInfo.getIpAddress(), serverInfo.getCredential().getUserName(), serverInfo.getCredential().getPassword());
            HardwareInventory result = serverAdapterImpl.collectHardwareInventory(credential);
            ServerHardwareInventory serverHardwareInventory = new ServerHardwareInventory(credential.getAddress());
            TranformerUtil.transformHardwareInventory(result, serverHardwareInventory);
            serverInfo.setInventory(serverHardwareInventory);
            serverInfo.setStatus(InventoryStatus.COMPLETED.name());
            logger.trace("Completed inventory for IP : ", serverInfo.getIpAddress());
        } catch (Exception e) {
            serverInfo.setStatus(InventoryStatus.FAILED.name());
            logger.trace("Failed inventory for IP : ", serverInfo.getIpAddress(), e);
        }
    }

}
