/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.manager;

import com.dell.isg.smi.adapter.server.model.WsmanCredentials;

public interface ILogManager2_0 {

    Object getServerLogs(WsmanCredentials wsmanCredentials, String type) throws Exception;

}
