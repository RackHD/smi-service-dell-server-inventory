/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
/**
 *
 */
package com.dell.isg.smi.service.server.inventory.utilities;

import java.net.SocketTimeoutException;

import javax.xml.ws.http.HTTPException;

import com.dell.isg.smi.commons.elm.exception.InvalidArgumentsException;
import com.dell.isg.smi.commons.elm.exception.RuntimeCoreException;

/**
 * Exception Handling util methods
 * 
 * @author Rahman_Muhammad
 *
 */
public class ExceptionUtilities {

    /**
     * Handles Invalid Argument Exception - adding ONE or multiple values as ONE attribute
     *
     *
     * @param Multiple valueNames
     */
    public static void handleInvalidArgs(String... valueNames) throws InvalidArgumentsException {
        StringBuilder invalidArgs = new StringBuilder();
        InvalidArgumentsException exception = new InvalidArgumentsException();
        for (String vName : valueNames) {
            invalidArgs.append(vName);
            invalidArgs.append(" ");
        }
        exception.addAttribute(invalidArgs.toString());
        throw exception;
    }


    /**
     * Handles RuntimeException - added multiple values as ONE Attribute. No Linked Exception
     *
     * @param errorID
     * @param paramName
     * @throws RuntimeCoreException
     */
    public static void handleRuntimeCore(int errorID, String... valueNames) throws RuntimeCoreException {
        RuntimeCoreException exception = new RuntimeCoreException();
        StringBuilder valArgs = new StringBuilder();
        for (String vName : valueNames) {
            valArgs.append(" ");
            valArgs.append(vName);
        }
        exception.addAttribute(valArgs.toString());
        throw exception;
    }


    public static void handleRuntimeSpectre(int errorID, String LCErrorCode, String LCErrorStr, String valueNames) throws RuntimeCoreException {
        RuntimeCoreException exception = new RuntimeCoreException();
        throw exception;
    }


    /**
     * Handles RuntimeException - added multiple values as ONE Attribute. Attach Linked Exception
     *
     * @param errorID
     * @param ex
     * @param valueNames
     * @throws RuntimeCoreException
     */
    public static void handleRuntimeCore(int errorID, Throwable ex, String... valueNames) throws RuntimeCoreException {
        RuntimeCoreException exception = new RuntimeCoreException(ex);
        StringBuilder valArgs = new StringBuilder();
        exception.setErrorID(errorID);
        for (String vName : valueNames) {
            valArgs.append(" ");
            valArgs.append(vName);
        }
        exception.addAttribute(valArgs.toString());
        throw exception;
    }


    /**
     * Create exception and return. Do not throw. One attribute - attach linked Exception
     *
     * @param errorID
     * @param ex
     * @param paramName
     * @return Spectre runtime exception.
     */
    public static RuntimeCoreException getSpectreRuntimeException(int errorID, Throwable ex, String paramName) {

        RuntimeCoreException exception = new RuntimeCoreException(ex);
        exception.setErrorID(errorID);
        exception.addAttribute(paramName);

        return exception;

    }


    public static RuntimeCoreException getSpectreRuntimeException(int errorID, Throwable ex, String paramName, String LCErrorCode, String LCErrorStr) {

        RuntimeCoreException exception = new RuntimeCoreException(ex);
        exception.setErrorID(errorID);
        exception.addAttribute(paramName);
        // exception.setLCErrorCode(LCErrorCode);
        // exception.setLCErrorStr(LCErrorStr);
        return exception;

    }


    /**
     * Create exception and return No Throwable- Linked Exception
     *
     * @param errorID
     * @param paramName
     * @return Spectre Runtime Exception
     */
    public static RuntimeCoreException getCoreRuntimeException(int errorID, String paramName) {

        RuntimeCoreException exception = new RuntimeCoreException();
        exception.setErrorID(errorID);
        exception.addAttribute(paramName);

        return exception;

    }


    public static RuntimeCoreException getCoreRuntimeException(int errorID, String paramName, String LCErrorCode, String LCErrorStr) {

        RuntimeCoreException exception = new RuntimeCoreException();
        exception.setErrorID(errorID);
        exception.addAttribute(paramName);
        // exception.setLCErrorCode(LCErrorCode);
        // exception.setLCErrorStr(LCErrorStr);

        return exception;

    }


    /**
     * Create and return spectre exception with just Error ID.
     *
     * @param errorID
     * @return Spectre Runtime Exception
     */
    public static RuntimeCoreException getSpectreRuntimeException(int errorID) {

        RuntimeCoreException exception = new RuntimeCoreException();
        exception.setErrorID(errorID);
        return exception;

    }


    /**
     * Create and return spectre exception with just Error ID and Linked Exception
     *
     * @param errorID
     * @param ex
     * @return Spectre Runtime Exception
     */
    public static RuntimeCoreException getSpectreRuntimeException(int errorID, Throwable ex) {

        RuntimeCoreException exception = new RuntimeCoreException();
        exception.setErrorID(errorID);
        return exception;

    }


    /**
     * Create and throw exception with errorID and multiple attributes.
     *
     * @param errorID
     * @param attributeValues
     * @throws RuntimeCoreException
     */
    public static void handleSpectreRuntimeException(int errorID, String... attributeValues) throws RuntimeCoreException {
        RuntimeCoreException exception = new RuntimeCoreException();
        exception.setErrorID(errorID);
        for (String attribute : attributeValues) {
            exception.getAttributesList().add(attribute);
        }

        throw exception;
    }


    /**
     * Create and throw exception with errorID and multiple attributes. Plus linked exception
     *
     * @param errorID
     * @param ex
     * @param attributeValues
     * @throws RuntimeCoreException
     */
    public static void handleSpectreRuntimeException(int errorID, Throwable ex, String... attributeValues) throws RuntimeCoreException {
        RuntimeCoreException exception = new RuntimeCoreException(ex);
        exception.setErrorID(errorID);
        for (String attribute : attributeValues) {
            exception.getAttributesList().add(attribute);
        }

        throw exception;
    }


    /**
     * Create and throw exception with errorID
     *
     * @param errorID
     * @throws RuntimeCoreException
     */
    public static void handleSpectreRuntimeException(int errorID) throws RuntimeCoreException {
        RuntimeCoreException exception = new RuntimeCoreException();
        exception.setErrorID(errorID);
        throw exception;
    }


    /**
     * Create and throw exception with errorID Plus Linked Exception
     *
     * @param errorID
     * @param ex
     * @throws RuntimeCoreException
     */
    public static void handleSpectreRuntimeException(int errorID, Throwable ex) throws RuntimeCoreException {
        RuntimeCoreException exception = new RuntimeCoreException(ex);
        exception.setErrorID(errorID);
        throw exception;
    }


    public static void handleIdracConnectionException(Throwable e, String idracAddress, String hostNameOrAddress) {
        RuntimeCoreException RuntimeCoreException = new RuntimeCoreException(e);

        // socket timeout exception
        if (e instanceof SocketTimeoutException) {
            RuntimeCoreException.setErrorID(238034); // Connection with iDRAC: {0} failed for host: {1} detail: {2}
            RuntimeCoreException.addAttribute(idracAddress);
            RuntimeCoreException.addAttribute(hostNameOrAddress);
            // LocalizedMessage localizedMessage = new LocalizedMessage("IDRAC_SOCKET_TIMEOUT");
            // RuntimeCoreException.addAttribute( localizedMessage.toString() );
            throw RuntimeCoreException;
        }

        // http exception
        if (e instanceof HTTPException) {
            int statusCode = ((HTTPException) e).getStatusCode();
            if (statusCode > 0) {
                // LocalizedMessage localizedMessage = new LocalizedMessage("HTTP_STATUS_CODE_" + statusCode);
                RuntimeCoreException.setErrorID(238034); // Connection with iDRAC: {0} failed for host: {1} detail: {2}
                RuntimeCoreException.addAttribute(idracAddress);
                RuntimeCoreException.addAttribute(hostNameOrAddress);
                // RuntimeCoreException.addAttribute(localizedMessage.toString());
            } else {
                RuntimeCoreException.setErrorID(20249); // Connection with iDRAC: {0} failed for host: {1}
                RuntimeCoreException.addAttribute(idracAddress);
                RuntimeCoreException.addAttribute(hostNameOrAddress);
            }
            throw RuntimeCoreException;
        }
        throw RuntimeCoreException;
    }

}
