/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dell.isg.smi.adapter.server.model.HardwareInventory;
import com.dell.isg.smi.adapter.server.model.WsmanCredentials;
import com.dell.isg.smi.commons.model.common.Credential;
import com.dell.isg.smi.commons.model.common.DevicesIpsRequest;
import com.dell.isg.smi.commons.model.common.InventoryCallbackRequest;
import com.dell.isg.smi.commons.model.common.InventoryCallbackResponse;
import com.dell.isg.smi.commons.model.common.InventoryInformation;
import com.dell.isg.smi.commons.model.common.ResponseString;
import com.dell.isg.smi.commons.model.manager.Manager;
import com.dell.isg.smi.commons.model.server.inventory.HwNic;
import com.dell.isg.smi.commons.model.server.inventory.HwSystem;
import com.dell.isg.smi.commons.model.server.inventory.ServerHardwareInventory;
import com.dell.isg.smi.commons.utilities.CustomRecursiveToStringStyle;
import com.dell.isg.smi.service.server.exception.BadRequestException;
import com.dell.isg.smi.service.server.exception.EnumErrorCode;
import com.dell.isg.smi.service.server.inventory.Transformer.TranformerUtil;
import com.dell.isg.smi.service.server.inventory.manager.IInventoryManager;
import com.dell.isg.smi.service.server.inventory.utilities.ValidationUtilities;
import com.dell.isg.smi.wsman.command.entity.BootOrderDetails;
import com.dell.isg.smi.wsman.command.entity.DCIMBIOSConfig;
import com.dell.isg.smi.wsman.command.entity.DCIMNICViewType;
import com.dell.isg.smi.wsman.command.entity.DCIMSoftwareIdentityType;
import com.dell.isg.smi.wsman.command.entity.DCIMSystemViewType;
import com.dell.isg.smi.wsman.command.entity.IDRACCardStringView;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/1.0/server/inventory")
public class ServerInventoryController {

    @Autowired
    IInventoryManager inventoryManagerImpl;

    private static final Logger logger = LoggerFactory.getLogger(ServerInventoryController.class.getName());


    @RequestMapping(value = "/hardware", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/hardware", nickname = "hardware", notes = "This operation allow user to get complete server hardware inventory throu wsman.", response = ServerHardwareInventory.class)
    // @ApiImplicitParams({
    // @ApiImplicitParam(name = "credential", value = "Credential", required = true, dataType = "Credential.class", paramType = "Body", defaultValue = "no default") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ServerHardwareInventory.class), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public ServerHardwareInventory inventory(@RequestBody Credential payload) {
        ValidationUtilities.validateRequestPayload(payload);
        logger.trace("Payload for hardware inventory : {} {}", payload.getAddress(), payload.getUserName());
        ServerHardwareInventory serverHardwareInventory = null;
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(payload.getAddress(), payload.getUserName(), payload.getPassword());
            HardwareInventory result = inventoryManagerImpl.collectHardwareInventory(wsmanCredentials);
            serverHardwareInventory = new ServerHardwareInventory(payload.getAddress());
            TranformerUtil.transformHardwareInventory(result, serverHardwareInventory);
            serverHardwareInventory.getSystem().setId(payload.getAddress());
        } catch (Exception e) {
            logger.error("Exception occured in inventory : {}", e.getMessage());
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(com.dell.isg.smi.commons.elm.model.EnumErrorCode.ENUM_GENERIC_MESSAGE);
            badRequestException.addAttribute(e.getMessage());
            throw badRequestException;
        }
        logger.trace("Hardware inventory Response : {}", ReflectionToStringBuilder.toString(serverHardwareInventory, new CustomRecursiveToStringStyle(99)));
        return serverHardwareInventory;
    }


    @RequestMapping(value = "/summary", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/summary", nickname = "system", notes = "This operation allow user to get partial server information throu wsman.", response = HwSystem.class)
    // @ApiImplicitParams({
    // @ApiImplicitParam(name = "credential", value = "Credential", required = true, dataType = "Credential.class", paramType = "Body", defaultValue = "no default") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = HwSystem.class), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public HwSystem summary(@RequestBody Credential payload) {
        ValidationUtilities.validateRequestPayload(payload);
        logger.trace("Credential for summary inventory : {} {}", payload.getAddress(), payload.getUserName());
        HwSystem summary = null;
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(payload.getAddress(), payload.getUserName(), payload.getPassword());
            DCIMSystemViewType result = inventoryManagerImpl.collectSystemInfo(wsmanCredentials);
            summary = TranformerUtil.transformHwSystem(result);
            summary.setId(payload.getAddress());
        } catch (Exception e) {
            logger.error("Exception occured in inventory : {}", e.getMessage());
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(com.dell.isg.smi.commons.elm.model.EnumErrorCode.ENUM_GENERIC_MESSAGE);
            badRequestException.addAttribute(e.getMessage());
            throw badRequestException;
        }
        logger.trace("System summary inventory Response : {}", ReflectionToStringBuilder.toString(summary, new CustomRecursiveToStringStyle(99)));
        return summary;
    }


    @RequestMapping(value = "/software", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/software", nickname = "software", notes = "This operation allow user to get complete server software inventory throu wsman.", response = DCIMSoftwareIdentityType.class, responseContainer = "List")
    // @ApiImplicitParams({
    // @ApiImplicitParam(name = "credential", value = "Credential", required = true, dataType = "Credential.class", paramType = "Body", defaultValue = "no default") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = DCIMSoftwareIdentityType.class, responseContainer = "List"), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public List<DCIMSoftwareIdentityType> software(@RequestBody Credential payload) {
        ValidationUtilities.validateRequestPayload(payload);
        logger.trace("Credential for software inventory : {} {}", payload.getAddress(), payload.getUserName());
        List<DCIMSoftwareIdentityType> result = null;
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(payload.getAddress(), payload.getUserName(), payload.getPassword());
            result = inventoryManagerImpl.enumerateDcimSoftwareIdentity(wsmanCredentials);
        } catch (Exception e) {
            logger.error("Exception occured in inventory : {}", e.getMessage());
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(com.dell.isg.smi.commons.elm.model.EnumErrorCode.ENUM_GENERIC_MESSAGE);
            badRequestException.addAttribute(e.getMessage());
            throw badRequestException;
        }
        logger.trace("Software inventory Response : {}", ReflectionToStringBuilder.toString(result, new CustomRecursiveToStringStyle(99)));
        return result;
    }


    @RequestMapping(value = "/nics", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/nics", nickname = "nics", notes = "This operation allow user to get complete server nics information throu wsman.", response = HwNic.class, responseContainer = "List")
    // @ApiImplicitParams({
    // @ApiImplicitParam(name = "Credential", value = "Credential", required = true, dataType = "Credential.class", paramType = "Body", defaultValue = "no default") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = HwNic.class, responseContainer = "List"), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public List<HwNic> nics(@RequestBody Credential payload) {
        ValidationUtilities.validateRequestPayload(payload);
        logger.trace("Credential for NIC inventory : {} {}", payload.getAddress(), payload.getUserName());
        List<HwNic> result = null;
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(payload.getAddress(), payload.getUserName(), payload.getPassword());
            List<DCIMNICViewType> nics = inventoryManagerImpl.collectNics(wsmanCredentials);
            result = TranformerUtil.transformHwNic(nics);
        } catch (Exception e) {
            logger.error("Exception occured in inventory : {}", e.getMessage());
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(com.dell.isg.smi.commons.elm.model.EnumErrorCode.ENUM_GENERIC_MESSAGE);
            badRequestException.addAttribute(e.getMessage());
            throw badRequestException;
        }
        logger.trace("NIC inventory Response : {}", ReflectionToStringBuilder.toString(result, new CustomRecursiveToStringStyle(99)));
        return result;
    }


    @RequestMapping(value = "/bios", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/bios", nickname = "bios", notes = "This operation allow user to collects the bios throu wsman.", response = DCIMBIOSConfig.class)
    // @ApiImplicitParams({
    // @ApiImplicitParam(name = "Credential", value = "Credential", required = true, dataType = "Credential.class", paramType = "Body", defaultValue = "no default") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = DCIMBIOSConfig.class), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public DCIMBIOSConfig collectConfig(@RequestBody Credential payload) {
        ValidationUtilities.validateRequestPayload(payload);
        logger.trace("Credential for bios data : {} {}", payload.getAddress(), payload.getUserName());
        DCIMBIOSConfig result = null;
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(payload.getAddress(), payload.getUserName(), payload.getPassword());
            result = inventoryManagerImpl.collectBiosConfig(wsmanCredentials);
        } catch (Exception e) {
            logger.error("Exception occured in inventory : {}", e.getMessage());
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(com.dell.isg.smi.commons.elm.model.EnumErrorCode.ENUM_GENERIC_MESSAGE);
            badRequestException.addAttribute(e.getMessage());
            throw badRequestException;
        }
        logger.trace("Bios Response : {}", ReflectionToStringBuilder.toString(result, new CustomRecursiveToStringStyle(99)));
        return result;
    }


    @RequestMapping(value = "/boot", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/boot", nickname = "boot", notes = "This operation allow user to collect boot order details throu wsman.", response = BootOrderDetails.class)
    // @ApiImplicitParams({
    // @ApiImplicitParam(name = "Credential", value = "Credential", required = true, dataType = "Credential.class", paramType = "Body", defaultValue = "no default") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = BootOrderDetails.class), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public BootOrderDetails collectBootOrderDetails(@RequestBody Credential payload) {
        ValidationUtilities.validateRequestPayload(payload);
        logger.trace("Credential for boot order details : {} {}", payload.getAddress(), payload.getUserName());
        BootOrderDetails result = null;
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(payload.getAddress(), payload.getUserName(), payload.getPassword());
            result = inventoryManagerImpl.getBootOrderDetails(wsmanCredentials);
        } catch (Exception e) {
            logger.error("Exception occured in inventory : {}", e.getMessage());
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(com.dell.isg.smi.commons.elm.model.EnumErrorCode.ENUM_GENERIC_MESSAGE);
            badRequestException.addAttribute(e.getMessage());
            throw badRequestException;
        }
        logger.trace("Boot Order Response : {}", ReflectionToStringBuilder.toString(result, new CustomRecursiveToStringStyle(99)));
        return result;
    }


    @RequestMapping(value = "/ips", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/ips", nickname = "ips", notes = "This operation allow user to collect server software identity throu wsman.", response = InventoryInformation.class, responseContainer = "List")
    // @ApiImplicitParams({
    // @ApiImplicitParam(name = "deviceIps", value = "DevicesIpsRequest", required = true, dataType = "DevicesIpsRequest.class", paramType = "Body", defaultValue = "no default") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = InventoryInformation.class), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public List<InventoryInformation> inventory(@RequestBody DevicesIpsRequest deviceIps) {
        ValidationUtilities.validateRequestPayload(deviceIps);
        logger.trace("Ips submitted for inventory : ", ReflectionToStringBuilder.toString(deviceIps, new CustomRecursiveToStringStyle(99)));
        List<InventoryInformation> response = null;
        try {
            response = inventoryManagerImpl.inventory(Arrays.stream(deviceIps.getIps()).collect(Collectors.toSet()));
        } catch (Exception e) {
            logger.error("Exception occured in inventory : {}", e.getMessage());
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(com.dell.isg.smi.commons.elm.model.EnumErrorCode.ENUM_GENERIC_MESSAGE);
            badRequestException.addAttribute(e.getMessage());
            throw badRequestException;
        }
        logger.trace("Inventory Response : {}", ReflectionToStringBuilder.toString(response, new CustomRecursiveToStringStyle(99)));
        return response;
    }


    @RequestMapping(value = "/callback", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/callback", nickname = "callback", notes = "This operation allow user to collect all the server inventory throu wsman. It uses callback uri to respond once the inventory is done. Type could be : hardware|nics|software|boot|bios|summary|sellog|lclog", response = ResponseString.class)
    // @ApiImplicitParams({
    // @ApiImplicitParam(name = "inventoryCallbackRequest", value = "InventoryCallbackRequest", required = true, dataType = "InventoryCallbackRequest.class", paramType = "Body",
    // defaultValue = "no default") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseString.class), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public ResponseString inventoryCallback(@RequestBody InventoryCallbackRequest inventoryCallbackRequest) {
        ValidationUtilities.validateRequestPayload(inventoryCallbackRequest);
        logger.trace("Inventory submitted for callback : {} {}", inventoryCallbackRequest.getCredential().getAddress(), inventoryCallbackRequest.getCallbackUri());
        ResponseString response = new ResponseString();
        String result = "Failed to submit IP range for discovery..";
        response.setCallbackUri(inventoryCallbackRequest.getCallbackUri());
        result = "Request Submitted ... Result will  be posted to call uri : " + response.getCallbackUri();
        inventoryManagerImpl.processInventoryCallback(inventoryCallbackRequest);
        response.setResponse(result);
        return response;
    }


    @RequestMapping(value = "/dummyCallback", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    public String dummyCallback(@RequestBody InventoryCallbackResponse inventoryCallbackResponse) {
        if (inventoryCallbackResponse == null) {
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(EnumErrorCode.IOIDENTITY_INVALID_INPUT);
            throw badRequestException;
        }
        logger.debug("Inventory for callback : {} ", ReflectionToStringBuilder.toString(inventoryCallbackResponse, new CustomRecursiveToStringStyle(99)));
        return "Request Submitted";
    }

    // @RequestMapping(value = "/dummy", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    // public InventoryCallbackResponse dummy(@RequestBody InventoryCallbackRequest inventoryCallbackRequest) {
    // logger.trace("Inventory submitted for callback : {} : {}", inventoryCallbackRequest.getCredential().getAddress(),inventoryCallbackRequest.getCallbackUri());
    // if (inventoryCallbackRequest.getCredential() == null || StringUtils.isEmpty(inventoryCallbackRequest.getCredential().getAddress())) {
    // BadRequestException badRequestException = new BadRequestException();
    // badRequestException.setErrorCode(EnumErrorCode.IOIDENTITY_INVALID_INPUT);
    // throw badRequestException;
    // }
    // return inventoryManagerImpl.dummy(inventoryCallbackRequest);
    // }
    //

    @RequestMapping(value = "/manager", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/manager", nickname = "manager", notes = "This operation allow user to get complete server hardware inventory throu wsman.", response = Manager.class)
    // @ApiImplicitParams({
    // @ApiImplicitParam(name = "credential", value = "Credential", required = true, dataType = "Credential.class", paramType = "Body", defaultValue = "no default") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Manager.class), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public Manager getIdracDetails(@RequestBody Credential payload) {
        ValidationUtilities.validateRequestPayload(payload);
        logger.trace("Credential for manager inventory : {} {}", payload.getAddress(), payload.getUserName());
        Manager manager = null;
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(payload.getAddress(), payload.getUserName(), payload.getPassword());
            List<IDRACCardStringView> result = inventoryManagerImpl.getIdracStringView(wsmanCredentials);
            manager = new Manager();
            manager.setStringViewList(TranformerUtil.transformIdracString(result));
        } catch (Exception e) {
            logger.error("Exception occured in inventory : {}", e.getMessage());
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(com.dell.isg.smi.commons.elm.model.EnumErrorCode.ENUM_GENERIC_MESSAGE);
            badRequestException.addAttribute(e.getMessage());
            throw badRequestException;
        }
        logger.trace("Manager Response : {}", ReflectionToStringBuilder.toString(manager, new CustomRecursiveToStringStyle(99)));
        return manager;
    }

}
