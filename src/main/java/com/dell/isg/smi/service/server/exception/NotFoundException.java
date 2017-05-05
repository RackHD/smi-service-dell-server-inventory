/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dell.isg.smi.commons.elm.exception.RuntimeCoreException;
import com.dell.isg.smi.commons.elm.messaging.LocalizedMessage;
import com.dell.isg.smi.commons.elm.model.EnumErrorCode;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeCoreException {
    private static final long serialVersionUID = 1L;


    public NotFoundException() {
        super();
    }


    public NotFoundException(Throwable e) {
        super(e);
    }


    public NotFoundException(EnumErrorCode enumErrorCode) {
        super(enumErrorCode);
    }


    @Override
    public String getMessage() {
        LocalizedMessage localizedMessage = generateLocalizedMessage();
        return localizedMessage.toString();
    }
}