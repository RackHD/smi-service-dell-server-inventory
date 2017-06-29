/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dell.isg.smi.adapter.server.inventory.IInventoryAdapter;
import com.dell.isg.smi.adapter.server.model.WsmanCredentials;
import com.dell.isg.smi.service.server.inventory.controller.ServerLogsEnum;

@Component
public class LogManagerImpl implements ILogManager {

    @Autowired
    IInventoryAdapter inventoryAdapterImpl;


    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> getServerLogs(WsmanCredentials wsmanCredentials, String type) throws Exception {
        List<T> returnList = new ArrayList<T>();
        if (StringUtils.equals(type, ServerLogsEnum.SEL.getValue())) {
            returnList = (List<T>) inventoryAdapterImpl.collectSelLogs(wsmanCredentials);
        } else if (StringUtils.equals(type, ServerLogsEnum.LC.getValue())) {
            returnList = (List<T>) inventoryAdapterImpl.collectLcLogs(wsmanCredentials);
        }
        return returnList;
    }

}
