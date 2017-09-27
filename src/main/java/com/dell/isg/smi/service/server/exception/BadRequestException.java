/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dell.isg.smi.commons.elm.exception.RuntimeCoreException;
import com.dell.isg.smi.commons.elm.model.EnumErrorCode;

/**
 * The Class BadRequestException.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeCoreException {
    private static final long serialVersionUID = 1L;
    
    // Default Constructor
    public BadRequestException() {
    }


    /**
     * Instantiates a new bad request exception.
     *
     * @param attributeName the attribute name
     * @param e the e
     */
    public BadRequestException(String attributeName, Throwable e) {
        super(e);
        this.setErrorCode(EnumErrorCode.ENUM_INVALID_DATA);
        this.addAttribute(attributeName);
    }


    /**
     * Instantiates a new bad request exception.
     *
     * @param attributeName the attribute name
     */
    public BadRequestException(String attributeName) {
        super();
        this.setErrorCode(EnumErrorCode.ENUM_INVALID_DATA);
        this.addAttribute(attributeName);
    }
}