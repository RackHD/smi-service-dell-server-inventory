/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.manager;

import java.util.List;
import java.util.Set;

import com.dell.isg.smi.adapter.server.model.WsmanCredentials;
import com.dell.isg.smi.commons.model.common.InventoryCallbackRequest;
import com.dell.isg.smi.commons.model.common.InventoryInformation;

public interface IInventoryManager2_0 {

	List<InventoryInformation> inventory(Set<String> ips) throws Exception;

	void processInventoryCallback(InventoryCallbackRequest inventoryCallbackRequest);

	Object collectHardwareInventory(WsmanCredentials wsmanCredentials) throws Exception;

	Object collectSummary(WsmanCredentials wsmanCredentials) throws Exception;

	Object collectSoftware(WsmanCredentials wsmanCredentials) throws Exception;

	Object collectNics(WsmanCredentials wsmanCredentials) throws Exception;

	Object collectBios(WsmanCredentials wsmanCredentials) throws Exception;

	Object collectBoot(WsmanCredentials wsmanCredentials) throws Exception;

	Object collectIdracString(WsmanCredentials wsmanCredentials) throws Exception;

	Object collectIdracCardEnum(WsmanCredentials wsmanCredentials) throws Exception;

	Object collectIdracDetails(WsmanCredentials wsmanCredentials) throws Exception;

    Object collect(WsmanCredentials wsmanCredentials, String dcim) throws Exception;

}
