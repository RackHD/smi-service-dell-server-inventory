/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.dell.isg.smi.commons.utilities.CustomRecursiveToStringStyle;
import com.dell.isg.smi.service.server.exception.BadRequestException;
import com.dell.isg.smi.service.server.inventory.manager.ILogManager;
import com.dell.isg.smi.service.server.inventory.utilities.ValidationUtilities;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/1.0/server/inventory/logs")
public class ServerLogController {

    @Autowired
    ILogManager logManagerImpl;

    private static final Logger logger = LoggerFactory.getLogger(ServerLogController.class.getName());


    @RequestMapping(value = "/get/{type}", method = RequestMethod.POST, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "/get/{type}", nickname = "getLogs", notes = "This operation allow user to collect sel logs throu wsman.", response = Object.class, responseContainer = "List")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Object.class, responseContainer = "List"), @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
    public List<Object> collectSelLogs(@RequestBody Credential payload, @PathVariable("type") String type) {
        ValidationUtilities.validateRequestPayload(payload);
        List<Object> result = new ArrayList<Object>();
        try {
            WsmanCredentials wsmanCredentials = new WsmanCredentials(payload.getAddress(), payload.getUserName(), payload.getPassword());
            result = logManagerImpl.getServerLogs(wsmanCredentials, type);
        } catch (Exception e) {
            logger.error("Exception occured : ", e);
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(com.dell.isg.smi.commons.elm.model.EnumErrorCode.ENUM_GENERIC_MESSAGE);
            badRequestException.addAttribute(e.getMessage());
            throw badRequestException;
        }
        logger.trace("Result Response : ", ReflectionToStringBuilder.toString(result, new CustomRecursiveToStringStyle(99)));
        return result;
    }

}
