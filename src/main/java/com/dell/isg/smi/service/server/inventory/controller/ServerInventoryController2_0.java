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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dell.isg.smi.adapter.server.model.WsmanCredentials;
import com.dell.isg.smi.commons.model.common.Credential;
import com.dell.isg.smi.commons.model.common.DevicesIpsRequest;
import com.dell.isg.smi.commons.model.common.InventoryCallbackRequest;
import com.dell.isg.smi.commons.model.common.InventoryInformation;
import com.dell.isg.smi.commons.model.common.ResponseString;
import com.dell.isg.smi.commons.utilities.CustomRecursiveToStringStyle;
import com.dell.isg.smi.service.server.exception.BadRequestException;
import com.dell.isg.smi.service.server.exception.EnumErrorCode;
import com.dell.isg.smi.service.server.inventory.manager.IInventoryManager2_0;
import com.dell.isg.smi.service.server.inventory.mock.bios.BiosResponse;
import com.dell.isg.smi.service.server.inventory.mock.boot.BootResponse;
import com.dell.isg.smi.service.server.inventory.mock.hardware.HardwareResponse;
import com.dell.isg.smi.service.server.inventory.mock.manager.ManagerResponse;
import com.dell.isg.smi.service.server.inventory.mock.nics.NicsResponse;
import com.dell.isg.smi.service.server.inventory.mock.software.SoftwareResponse;
import com.dell.isg.smi.service.server.inventory.mock.summary.SummaryResponse;
import com.dell.isg.smi.service.server.inventory.utilities.ValidationUtilities;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/2.0/server/inventory")
public class ServerInventoryController2_0 {

    @Autowired
    IInventoryManager2_0 inventoryManagerImpl;

    private static final Logger logger = LoggerFactory.getLogger(ServerInventoryController.class.getName());


    @RequestMapping(value = "/hardware", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/hardware", nickname = "hardware", notes = "This operation allow user to get complete server hardware inventory throu wsman.", response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = HardwareResponse.class), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public Object inventory(@RequestBody Credential payload) {
        ValidationUtilities.validateRequestPayload(payload);
        logger.trace("Credential for hardware inventory : ", payload.getAddress(), payload.getUserName());
        Object result = null;
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(payload.getAddress(), payload.getUserName(), payload.getPassword());
            result = inventoryManagerImpl.collectHardwareInventory(wsmanCredentials);
        } catch (Exception e) {
            logger.error("Exception occured in inventory2 : ", e);
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(com.dell.isg.smi.commons.elm.model.EnumErrorCode.ENUM_GENERIC_MESSAGE);
            badRequestException.addAttribute(e.getMessage());
            throw badRequestException;
        }
        logger.trace("Hardware inventory Response : ", ReflectionToStringBuilder.toString(result, new CustomRecursiveToStringStyle(99)));
        return result;
    }


    @RequestMapping(value = "/summary", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/summary", nickname = "summary", notes = "This operation allow user to get server system information (System View) throu wsman.", response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = SummaryResponse.class), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public Object summary(@RequestBody Credential payload) {
        ValidationUtilities.validateRequestPayload(payload);
        logger.trace("Credential for system inventory : ", payload.getAddress(), payload.getUserName());
        Object result = null;
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(payload.getAddress(), payload.getUserName(), payload.getPassword());
            result = inventoryManagerImpl.collectSummary(wsmanCredentials);

        } catch (Exception e) {
            logger.error("Exception occured in inventory2 : ", e);
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(com.dell.isg.smi.commons.elm.model.EnumErrorCode.ENUM_GENERIC_MESSAGE);
            badRequestException.addAttribute(e.getMessage());
            throw badRequestException;
        }
        logger.trace("System inventory Response : ", ReflectionToStringBuilder.toString(result, new CustomRecursiveToStringStyle(99)));
        return result;
    }


    @RequestMapping(value = "/software", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/software", nickname = "software", notes = "This operation allow user to get complete server software inventory throu wsman.", response = Object.class, responseContainer = "List")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = SoftwareResponse.class, responseContainer = "List"), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public Object software(@RequestBody Credential payload) {
        ValidationUtilities.validateRequestPayload(payload);
        logger.trace("Credential for software inventory : ", payload.getAddress(), payload.getUserName());
        Object result = null;
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(payload.getAddress(), payload.getUserName(), payload.getPassword());
            result = inventoryManagerImpl.collectSoftware(wsmanCredentials);
        } catch (Exception e) {
            logger.error("Exception occured in inventory2 : ", e);
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(com.dell.isg.smi.commons.elm.model.EnumErrorCode.ENUM_GENERIC_MESSAGE);
            badRequestException.addAttribute(e.getMessage());
            throw badRequestException;
        }
        logger.trace("Software inventory Response : ", ReflectionToStringBuilder.toString(result, new CustomRecursiveToStringStyle(99)));
        return result;
    }


    @RequestMapping(value = "/nics", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/nics", nickname = "nics", notes = "This operation allow user to get complete server nics information throu wsman.", response = Object.class, responseContainer = "List")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = NicsResponse.class, responseContainer = "List"), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public Object nics(@RequestBody Credential payload) {
        ValidationUtilities.validateRequestPayload(payload);
        logger.trace("Credential for NIC inventory : ", payload.getAddress(), payload.getUserName());
        Object result = null;
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(payload.getAddress(), payload.getUserName(), payload.getPassword());
            Object nics = inventoryManagerImpl.collectNics(wsmanCredentials);
            result = nics;
        } catch (Exception e) {
            logger.error("Exception occured in inventory2 : ", e);
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(com.dell.isg.smi.commons.elm.model.EnumErrorCode.ENUM_GENERIC_MESSAGE);
            badRequestException.addAttribute(e.getMessage());
            throw badRequestException;
        }
        logger.trace("NIC inventory Response : ", ReflectionToStringBuilder.toString(result, new CustomRecursiveToStringStyle(99)));
        return result;
    }


    @RequestMapping(value = "/bios", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/bios", nickname = "bios", notes = "This operation allow user to collects the bios details from server throu wsman.", response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = BiosResponse.class), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public Object collectConfig(@RequestBody Credential payload) {
        ValidationUtilities.validateRequestPayload(payload);
        logger.trace("Credential for bios data : ", payload.getAddress(), payload.getUserName());
        Object result = null;
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(payload.getAddress(), payload.getUserName(), payload.getPassword());
            result = inventoryManagerImpl.collectBios(wsmanCredentials);
        } catch (Exception e) {
            logger.error("Exception occured in inventory2 : ", e);
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(com.dell.isg.smi.commons.elm.model.EnumErrorCode.ENUM_GENERIC_MESSAGE);
            badRequestException.addAttribute(e.getMessage());
            throw badRequestException;
        }
        logger.trace("Bios Response : ", ReflectionToStringBuilder.toString(result, new CustomRecursiveToStringStyle(99)));
        return result;
    }


    @RequestMapping(value = "/boot", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/boot", nickname = "boot", notes = "This operation allow user to collect boot order details from the server throu wsman.", response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = BootResponse.class), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public Object collectBootOrderDetails(@RequestBody Credential payload) {
        ValidationUtilities.validateRequestPayload(payload);
        logger.trace("Credential for boot order details : ", payload.getAddress(), payload.getUserName());
        Object result = null;
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(payload.getAddress(), payload.getUserName(), payload.getPassword());
            result = inventoryManagerImpl.collectBoot(wsmanCredentials);
        } catch (Exception e) {
            logger.error("Exception occured in inventory2 : ", e);
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(com.dell.isg.smi.commons.elm.model.EnumErrorCode.ENUM_GENERIC_MESSAGE);
            badRequestException.addAttribute(e.getMessage());
            throw badRequestException;
        }
        logger.trace("Boot Order Response : ", ReflectionToStringBuilder.toString(result, new CustomRecursiveToStringStyle(99)));
        return result;
    }

   public List<InventoryInformation> inventory(@RequestBody DevicesIpsRequest deviceIps) {
        logger.trace("Ips submitted for inventory : ", ReflectionToStringBuilder.toString(deviceIps, new CustomRecursiveToStringStyle(99)));
        List<InventoryInformation> response = null;
        if (deviceIps == null) {
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(EnumErrorCode.IOIDENTITY_INVALID_INPUT);
            throw badRequestException;
        }
        try {
            response = inventoryManagerImpl.inventory(Arrays.stream(deviceIps.getIps()).collect(Collectors.toSet()));
        } catch (Exception e) {
            logger.error("Exception occured in inventory2 : ", e);
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(com.dell.isg.smi.commons.elm.model.EnumErrorCode.ENUM_GENERIC_MESSAGE);
            badRequestException.addAttribute(e.getMessage());
            throw badRequestException;
        }
        logger.trace("Inventory Response : ", ReflectionToStringBuilder.toString(response, new CustomRecursiveToStringStyle(99)));
        return response;
    }


    @RequestMapping(value = "/callback", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/callback", nickname = "callback", notes = "This operation allow user to collect all the server inventory throu wsman. It uses callback uri to respond once the inventory is collected. Type could be : hardware :nics :software : manager:boot :bios: summary: sellog: lclog", response = ResponseString.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseString.class), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public ResponseString inventoryCallback(@RequestBody InventoryCallbackRequest inventoryCallbackRequest) {
        ValidationUtilities.validateRequestPayload(inventoryCallbackRequest);
        logger.trace("Inventory submitted for callback : {} : {}", inventoryCallbackRequest.getCredential().getAddress(), inventoryCallbackRequest.getCallbackUri());
        ResponseString response = new ResponseString();
        String result = "Failed to submit IP range for discovery..";
        response.setCallbackUri(inventoryCallbackRequest.getCallbackUri());
        result = "Request Submitted ... Result will  be posted to call uri : " + response.getCallbackUri();
        inventoryManagerImpl.processInventoryCallback(inventoryCallbackRequest);
        response.setResponse(result);
        return response;
    }


    @RequestMapping(value = "/manager", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/manager", nickname = "manager", notes = "This operation allow user to get complete DCIM_IDRACCardView, DCIM_iDRACCardString and DCIM_iDRACCardEnumeration throu wsman.", response = Object.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ManagerResponse.class), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public Object getIdracDetails(@RequestBody Credential payload) {
        ValidationUtilities.validateRequestPayload(payload);
        logger.trace("Credential for hardware inventory : ", payload.getAddress(), payload.getUserName());
        Object manager = null;
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(payload.getAddress(), payload.getUserName(), payload.getPassword());
            manager = inventoryManagerImpl.collectIdracDetails(wsmanCredentials);
        } catch (Exception e) {
            logger.error("Exception occured in inventory2 : ", e);
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(com.dell.isg.smi.commons.elm.model.EnumErrorCode.ENUM_GENERIC_MESSAGE);
            badRequestException.addAttribute(e.getMessage());
            throw badRequestException;
        }
        logger.trace("Manager Response : ", ReflectionToStringBuilder.toString(manager, new CustomRecursiveToStringStyle(99)));
        return manager;
    }

    @RequestMapping(value = "/dcim/{type}", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/dcim/{type}", nickname = "dcim", notes = "This operation allow user to collect any dcim data based on the passed type. Type value - DCIM_SystemView:DCIM_ControllerView:DCIM_VirtualDiskView:DCIM_PhysicalDiskView ..etc", response = Object.class, responseContainer = "List")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success - Response schema would be based on type passed.", response = Object.class, responseContainer = "List"), @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
    public Object collectSelLogs(@RequestBody Credential payload, @PathVariable("type") String type) {
        ValidationUtilities.validateRequestPayload(payload);
        Object result = null;
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(payload.getAddress(), payload.getUserName(), payload.getPassword());
            result = inventoryManagerImpl.collect(wsmanCredentials, type);
        } catch (Exception e) {
            logger.error("Exception occured in inventory2 : ", e);
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(com.dell.isg.smi.commons.elm.model.EnumErrorCode.ENUM_GENERIC_MESSAGE);
            badRequestException.addAttribute(e.getMessage());
            throw badRequestException;
        }
        logger.trace("Result Response : ", ReflectionToStringBuilder.toString(result, new CustomRecursiveToStringStyle(99)));
        return result;
    }


}
