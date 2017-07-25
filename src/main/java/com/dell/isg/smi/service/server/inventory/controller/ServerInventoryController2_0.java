/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
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
import com.dell.isg.smi.commons.elm.exception.RuntimeCoreException;
import com.dell.isg.smi.commons.model.common.Credential;
import com.dell.isg.smi.commons.model.common.DevicesIpsRequest;
import com.dell.isg.smi.commons.model.common.InventoryCallbackRequest;
import com.dell.isg.smi.commons.model.common.InventoryInformation;
import com.dell.isg.smi.commons.model.common.ResponseString;
import com.dell.isg.smi.commons.utilities.CustomRecursiveToStringStyle;
import com.dell.isg.smi.service.server.exception.BadRequestException;
import com.dell.isg.smi.service.server.exception.EnumErrorCode;
import com.dell.isg.smi.service.server.inventory.manager.IInventoryManager2_0;

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
    // @ApiImplicitParams({
    // @ApiImplicitParam(name = "credential", value = "Credential", required = true, dataType = "Credential.class", paramType = "Body", defaultValue = "no default") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Object.class), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public Object inventory(@RequestBody Credential credential) {
        logger.trace("Credential for hardware inventory : ", credential.getAddress(), credential.getUserName());
        Object result = null;
        if (credential == null || StringUtils.isEmpty(credential.getAddress())) {
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(EnumErrorCode.IOIDENTITY_INVALID_INPUT);
            throw badRequestException;
        }
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(credential.getAddress(), credential.getUserName(), credential.getPassword());
            result = inventoryManagerImpl.collectHardwareInventory(wsmanCredentials);
        } catch (Exception e) {
            logger.error("Exception occured in discovery : ", e);
            RuntimeCoreException runtimeCoreException = new RuntimeCoreException(e);
            runtimeCoreException.setErrorCode(EnumErrorCode.ENUM_SERVER_ERROR);
            throw runtimeCoreException;
        }
        logger.trace("Hardware inventory Response : ", ReflectionToStringBuilder.toString(result, new CustomRecursiveToStringStyle(99)));
        return result;
    }


    @RequestMapping(value = "/summary", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/summary", nickname = "system", notes = "This operation allow user to get partial server information throu wsman.", response = Object.class)
    // @ApiImplicitParams({
    // @ApiImplicitParam(name = "credential", value = "Credential", required = true, dataType = "Credential.class", paramType = "Body", defaultValue = "no default") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Object.class), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public Object summary(@RequestBody Credential credential) {
        logger.trace("Credential for system inventory : ", credential.getAddress(), credential.getUserName());
        Object result = null;
        if (credential == null || StringUtils.isEmpty(credential.getAddress())) {
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(EnumErrorCode.IOIDENTITY_INVALID_INPUT);
            throw badRequestException;
        }
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(credential.getAddress(), credential.getUserName(), credential.getPassword());
            result = inventoryManagerImpl.collectSummary(wsmanCredentials);

        } catch (Exception e) {
            logger.error("Exception occured in discovery : ", e);
            RuntimeCoreException runtimeCoreException = new RuntimeCoreException(e);
            runtimeCoreException.setErrorCode(EnumErrorCode.ENUM_SERVER_ERROR);
            throw runtimeCoreException;
        }
        logger.trace("System inventory Response : ", ReflectionToStringBuilder.toString(result, new CustomRecursiveToStringStyle(99)));
        return result;
    }


    @RequestMapping(value = "/software", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/software", nickname = "software", notes = "This operation allow user to get complete server software inventory throu wsman.", response = Object.class, responseContainer = "List")
    // @ApiImplicitParams({
    // @ApiImplicitParam(name = "credential", value = "Credential", required = true, dataType = "Credential.class", paramType = "Body", defaultValue = "no default") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Object.class, responseContainer = "List"), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public Object software(@RequestBody Credential credential) {
        logger.trace("Credential for software inventory : ", credential.getAddress(), credential.getUserName());
        Object result = null;
        if (credential == null || StringUtils.isEmpty(credential.getAddress())) {
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(EnumErrorCode.IOIDENTITY_INVALID_INPUT);
            throw badRequestException;
        }
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(credential.getAddress(), credential.getUserName(), credential.getPassword());
            result = inventoryManagerImpl.collectSoftware(wsmanCredentials);
        } catch (Exception e) {
            logger.error("Exception occured in discovery : ", e);
            RuntimeCoreException runtimeCoreException = new RuntimeCoreException(e);
            runtimeCoreException.setErrorCode(EnumErrorCode.ENUM_SERVER_ERROR);
            throw runtimeCoreException;
        }
        logger.trace("Software inventory Response : ", ReflectionToStringBuilder.toString(result, new CustomRecursiveToStringStyle(99)));
        return result;
    }


    @RequestMapping(value = "/nics", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/nics", nickname = "nics", notes = "This operation allow user to get complete server nics information throu wsman.", response = Object.class, responseContainer = "List")
    // @ApiImplicitParams({
    // @ApiImplicitParam(name = "Credential", value = "Credential", required = true, dataType = "Credential.class", paramType = "Body", defaultValue = "no default") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Object.class, responseContainer = "List"), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public Object nics(@RequestBody Credential credential) {
        logger.trace("Credential for NIC inventory : ", credential.getAddress(), credential.getUserName());
        Object result = null;
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(credential.getAddress(), credential.getUserName(), credential.getPassword());
            Object nics = inventoryManagerImpl.collectNics(wsmanCredentials);
//            result = TranformerUtil.transformHwNic(nics);
            result = nics;
        } catch (Exception e) {
            logger.error("Exception occured in discovery : ", e);
            RuntimeCoreException runtimeCoreException = new RuntimeCoreException(e);
            runtimeCoreException.setErrorCode(EnumErrorCode.ENUM_SERVER_ERROR);
            throw runtimeCoreException;
        }
        logger.trace("NIC inventory Response : ", ReflectionToStringBuilder.toString(result, new CustomRecursiveToStringStyle(99)));
        return result;
    }


    @RequestMapping(value = "/bios", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/bios", nickname = "bios", notes = "This operation allow user to collects the bios throu wsman.", response = Object.class)
    // @ApiImplicitParams({
    // @ApiImplicitParam(name = "Credential", value = "Credential", required = true, dataType = "Credential.class", paramType = "Body", defaultValue = "no default") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Object.class), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public Object collectConfig(@RequestBody Credential credential) {
        logger.trace("Credential for bios data : ", credential.getAddress(), credential.getUserName());
        Object result = null;
        if (credential == null || StringUtils.isEmpty(credential.getAddress())) {
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(EnumErrorCode.IOIDENTITY_INVALID_INPUT);
            throw badRequestException;
        }
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(credential.getAddress(), credential.getUserName(), credential.getPassword());
            result = inventoryManagerImpl.collectBios(wsmanCredentials);
        } catch (Exception e) {
            logger.error("Exception occured in discovery : ", e);
            RuntimeCoreException runtimeCoreException = new RuntimeCoreException(e);
            runtimeCoreException.setErrorCode(EnumErrorCode.ENUM_SERVER_ERROR);
            throw runtimeCoreException;
        }
        logger.trace("Bios Response : ", ReflectionToStringBuilder.toString(result, new CustomRecursiveToStringStyle(99)));
        return result;
    }


    @RequestMapping(value = "/boot", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/boot", nickname = "boot", notes = "This operation allow user to collect boot order details throu wsman.", response = Object.class)
    // @ApiImplicitParams({
    // @ApiImplicitParam(name = "Credential", value = "Credential", required = true, dataType = "Credential.class", paramType = "Body", defaultValue = "no default") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Object.class), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public Object collectBootOrderDetails(@RequestBody Credential credential) {
        logger.trace("Credential for boot order details : ", credential.getAddress(), credential.getUserName());
        Object result = null;
        if (credential == null || StringUtils.isEmpty(credential.getAddress())) {
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(EnumErrorCode.IOIDENTITY_INVALID_INPUT);
            throw badRequestException;
        }
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(credential.getAddress(), credential.getUserName(), credential.getPassword());
            result = inventoryManagerImpl.collectBoot(wsmanCredentials);
        } catch (Exception e) {
            logger.error("Exception occured in discovery : ", e);
            RuntimeCoreException runtimeCoreException = new RuntimeCoreException(e);
            runtimeCoreException.setErrorCode(EnumErrorCode.ENUM_SERVER_ERROR);
            throw runtimeCoreException;
        }
        logger.trace("Boot Order Response : ", ReflectionToStringBuilder.toString(result, new CustomRecursiveToStringStyle(99)));
        return result;
    }


    @RequestMapping(value = "/ips", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/ips", nickname = "ips", notes = "This operation allow user to collect server software identity throu wsman.", response = InventoryInformation.class, responseContainer = "List")
    // @ApiImplicitParams({
    // @ApiImplicitParam(name = "deviceIps", value = "DevicesIpsRequest", required = true, dataType = "DevicesIpsRequest.class", paramType = "Body", defaultValue = "no default") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = InventoryInformation.class), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
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
            logger.error("Exception occured in discovery : ", e);
            RuntimeCoreException runtimeCoreException = new RuntimeCoreException(e);
            runtimeCoreException.setErrorCode(EnumErrorCode.ENUM_SERVER_ERROR);
            throw runtimeCoreException;
        }
        logger.trace("Inventory Response : ", ReflectionToStringBuilder.toString(response, new CustomRecursiveToStringStyle(99)));
        return response;
    }


    @RequestMapping(value = "/callback", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/callback", nickname = "callback", notes = "This operation allow user to collect all the server inventory throu wsman. It uses callback uri to respond once the inventory is done. Type could be : hardware|nics|software|boot|bios|summary|sellog|lclog", response = ResponseString.class)
    // @ApiImplicitParams({
    // @ApiImplicitParam(name = "inventoryCallbackRequest", value = "InventoryCallbackRequest", required = true, dataType = "InventoryCallbackRequest.class", paramType = "Body",
    // defaultValue = "no default") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseString.class), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public ResponseString inventoryCallback(@RequestBody InventoryCallbackRequest inventoryCallbackRequest) {
        logger.trace("Inventory submitted for callback : {} : {}", inventoryCallbackRequest.getCredential().getAddress(), inventoryCallbackRequest.getCallbackUri());
        ResponseString response = new ResponseString();
        String result = "Failed to submit IP range for discovery..";
        if (inventoryCallbackRequest.getCredential() == null || StringUtils.isEmpty(inventoryCallbackRequest.getCredential().getAddress())) {
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(EnumErrorCode.IOIDENTITY_INVALID_INPUT);
            throw badRequestException;
        }
        response.setCallbackUri(inventoryCallbackRequest.getCallbackUri());
        result = "Request Submitted ... Result will  be posted to call uri : " + response.getCallbackUri();
        inventoryManagerImpl.processInventoryCallback(inventoryCallbackRequest);
        response.setResponse(result);
        return response;
    }


    @RequestMapping(value = "/manager", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/manager", nickname = "manager", notes = "This operation allow user to get complete server hardware inventory throu wsman.", response = Object.class)
    // @ApiImplicitParams({
    // @ApiImplicitParam(name = "credential", value = "Credential", required = true, dataType = "Credential.class", paramType = "Body", defaultValue = "no default") })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Object.class), @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 500, message = "Failure") })
    public Object getIdracDetails(@RequestBody Credential credential) {
        logger.trace("Credential for hardware inventory : ", credential.getAddress(), credential.getUserName());
        Object manager = null;
        if (credential == null || StringUtils.isEmpty(credential.getAddress())) {
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(EnumErrorCode.IOIDENTITY_INVALID_INPUT);
            throw badRequestException;
        }
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(credential.getAddress(), credential.getUserName(), credential.getPassword());
//            List<IDRACCardStringView> result = inventoryManagerImpl.getIdracStringView(wsmanCredentials);
            manager = inventoryManagerImpl.collectIdracDetails(wsmanCredentials);
            //manager = new Manager();
            //manager.setStringViewList(TranformerUtil.transformIdracString(result));
        } catch (Exception e) {
            logger.error("Exception occured in discovery : ", e);
            RuntimeCoreException runtimeCoreException = new RuntimeCoreException(e);
            runtimeCoreException.setErrorCode(EnumErrorCode.ENUM_SERVER_ERROR);
            throw runtimeCoreException;
        }
        logger.trace("Manager Response : ", ReflectionToStringBuilder.toString(manager, new CustomRecursiveToStringStyle(99)));
        return manager;
    }

    @RequestMapping(value = "/dcim/{type}", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/dcim/{type}", nickname = "getLogs", notes = "This operation allow user to collect sel logs throu wsman.", response = Object.class, responseContainer = "List")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Object.class, responseContainer = "List"), @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
    public Object collectSelLogs(@RequestBody Credential credential, @PathVariable("type") String type) {
        Object result = null;
        if (credential == null || StringUtils.isEmpty(credential.getAddress()) || StringUtils.isEmpty(type)) {
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(EnumErrorCode.IOIDENTITY_INVALID_INPUT);
            throw badRequestException;
        }
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(credential.getAddress(), credential.getUserName(), credential.getPassword());
            result = inventoryManagerImpl.collect(wsmanCredentials, type);
        } catch (Exception e) {
            logger.error("Exception occured : ", e);
            RuntimeCoreException runtimeCoreException = new RuntimeCoreException(e);
            runtimeCoreException.setErrorCode(EnumErrorCode.ENUM_SERVER_ERROR);
            throw runtimeCoreException;
        }
        logger.trace("Result Response : ", ReflectionToStringBuilder.toString(result, new CustomRecursiveToStringStyle(99)));
        return result;
    }


}
