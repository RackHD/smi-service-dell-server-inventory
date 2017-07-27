/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.manager.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dell.isg.smi.adapter.server.inventory.IInventoryAdapter;
import com.dell.isg.smi.adapter.server.model.WsmanCredentials;
import com.dell.isg.smi.commons.model.common.InventoryInformation;
import com.dell.isg.smi.commons.model.common.InventoryStatus;

public class ServerInventoryCollectionThread2_0 implements Runnable {
    private InventoryInformation serverInfo;

    private IInventoryAdapter inventoryAdapter;

    private static final Logger logger = LoggerFactory.getLogger(ServerInventoryCollectionThread.class.getName());


    public ServerInventoryCollectionThread2_0(InventoryInformation info, IInventoryAdapter inventoryAdapter) {
        this.serverInfo = info;
        this.inventoryAdapter = inventoryAdapter;
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
            Object result = inventoryAdapter.collectHardwareInventory(credential);
            serverInfo.setInventory(result);
            serverInfo.setStatus(InventoryStatus.COMPLETED.name());
            logger.trace("Completed inventory for IP : ", serverInfo.getIpAddress());
        } catch (Exception e) {
            serverInfo.setStatus(InventoryStatus.FAILED.name());
            logger.trace("Failed inventory for IP : ", serverInfo.getIpAddress(), e);
        }
    }

}
