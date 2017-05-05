/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.manager;

import java.util.List;

import com.dell.isg.smi.adapter.server.model.WsmanCredentials;

public interface ILogManager {

    <T> List<T> getServerLogs(WsmanCredentials wsmanCredentials, String type) throws Exception;

}
