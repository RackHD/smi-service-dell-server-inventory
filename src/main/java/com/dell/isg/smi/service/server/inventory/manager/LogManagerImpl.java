/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dell.isg.smi.adapter.server.IServerAdapter;
import com.dell.isg.smi.adapter.server.model.WsmanCredentials;
import com.dell.isg.smi.service.server.inventory.controller.ServerLogsEnum;

@Component
public class LogManagerImpl implements ILogManager {

    @Autowired
    IServerAdapter serverAdapterImpl;


    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> getServerLogs(WsmanCredentials wsmanCredentials, String type) throws Exception {
        List<T> returnList = new ArrayList<T>();
        if (StringUtils.equals(type, ServerLogsEnum.SEL.getValue())) {
            returnList = (List<T>) serverAdapterImpl.getServerSelLogEntries(wsmanCredentials);
        } else if (StringUtils.equals(type, ServerLogsEnum.LC.getValue())) {
            returnList = (List<T>) serverAdapterImpl.getServerLcLogEntries(wsmanCredentials);
        }
        return returnList;
    }

}
