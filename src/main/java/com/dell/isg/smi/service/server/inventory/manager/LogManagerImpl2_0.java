/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dell.isg.smi.adapter.server.inventory.IInventoryAdapter;
import com.dell.isg.smi.adapter.server.model.WsmanCredentials;
import com.dell.isg.smi.service.server.inventory.controller.ServerLogsEnum;

@Component
public class LogManagerImpl2_0 implements ILogManager2_0 {

    @Autowired
    IInventoryAdapter inventoryAdapterImpl;


    @Override
    public Object getServerLogs(WsmanCredentials wsmanCredentials, String type) throws Exception {
        Object result = null;
        if (StringUtils.equals(type, ServerLogsEnum.SEL.getValue())) {
            result = inventoryAdapterImpl.collectSelLogs(wsmanCredentials);
        } else if (StringUtils.equals(type, ServerLogsEnum.LC.getValue())) {
            result = inventoryAdapterImpl.collectLcLogs(wsmanCredentials);
        }
        // We always want to return a List for logs
        if(result == null) {
            return Collections.emptyList();
        }
        if(result instanceof List) {
            return result;
        }
        List<Object> list = new ArrayList<Object>();
        list.add(result);
        return list;
    }

}
