/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.utilities;

import com.dell.isg.smi.commons.elm.exception.InvalidArgumentsException;
import com.dell.isg.smi.commons.model.common.Credential;
import com.dell.isg.smi.commons.model.common.InventoryCallbackRequest;
import com.dell.isg.smi.commons.model.validation.ValidationResult;
import com.dell.isg.smi.service.server.exception.BadRequestException;
import com.dell.isg.smi.service.server.exception.EnumErrorCode;

/**
 * The Class ValidationUtilities.
 */
public class ValidationUtilities {

    /**
     * Validate request payload.
     *
     * @param payload the payload
     */
    public static void validateRequestPayload(Credential payload){
        if (payload == null) {
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(EnumErrorCode.IOIDENTITY_INVALID_INPUT);
            throw badRequestException;
        }
        
        ValidationResult validationResult = payload.validate();
        if( ! validationResult.isValid() ) {
            String innerMessage = validationResult.getMessage();
            InvalidArgumentsException invalidArgumentsException = new InvalidArgumentsException("payload <"+ innerMessage + ">" );
            throw invalidArgumentsException;
        }
    }
    
    /**
     * Validate request payload.
     *
     * @param payload the payload
     */
    public static void validateRequestPayload(InventoryCallbackRequest payload){
        if (payload == null) {
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.setErrorCode(EnumErrorCode.IOIDENTITY_INVALID_INPUT);
            throw badRequestException;
        }
        
        ValidationResult validationResult = payload.validate();
        if( ! validationResult.isValid() ) {
            String innerMessage = validationResult.getMessage();
            InvalidArgumentsException invalidArgumentsException = new InvalidArgumentsException("payload <"+ innerMessage + ">" );
            throw invalidArgumentsException;
        }
    }
    
}
