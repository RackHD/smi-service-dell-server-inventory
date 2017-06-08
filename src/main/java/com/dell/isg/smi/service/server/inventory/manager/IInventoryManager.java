/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.manager;

import java.util.List;
import java.util.Set;

import com.dell.isg.smi.adapter.server.model.HardwareInventory;
import com.dell.isg.smi.adapter.server.model.WsmanCredentials;
import com.dell.isg.smi.commons.model.common.InventoryCallbackRequest;
import com.dell.isg.smi.commons.model.common.InventoryCallbackResponse;
import com.dell.isg.smi.commons.model.common.InventoryInformation;
import com.dell.isg.smi.wsman.command.entity.BootOrderDetails;
import com.dell.isg.smi.wsman.command.entity.DCIMBIOSConfig;
import com.dell.isg.smi.wsman.command.entity.DCIMNICViewType;
import com.dell.isg.smi.wsman.command.entity.DCIMSoftwareIdentityType;
import com.dell.isg.smi.wsman.command.entity.DCIMSystemViewType;
import com.dell.isg.smi.wsman.command.entity.IDRACCardStringView;

public interface IInventoryManager {

    public List<InventoryInformation> inventory(Set<String> ips) throws Exception;


    public void processInventoryCallback(InventoryCallbackRequest inventoryCallbackRequest);


    public InventoryCallbackResponse dummy(InventoryCallbackRequest inventoryCallbackRequest);


    public HardwareInventory collectHardwareInventory(WsmanCredentials wsmanCredentials) throws Exception;


    public DCIMSystemViewType collectSystemInfo(WsmanCredentials wsmanCredentials) throws Exception;


    public List<DCIMSoftwareIdentityType> enumerateDcimSoftwareIdentity(WsmanCredentials wsmanCredentials) throws Exception;


    public List<DCIMNICViewType> collectNics(WsmanCredentials wsmanCredentials) throws Exception;


    public DCIMBIOSConfig collectBiosConfig(WsmanCredentials wsmanCredentials) throws Exception;


    public BootOrderDetails getBootOrderDetails(WsmanCredentials wsmanCredentials) throws Exception;


    public List<IDRACCardStringView> getIdracStringView(WsmanCredentials wsmanCredentials) throws Exception;

}
