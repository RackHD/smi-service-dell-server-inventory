/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.lclog;

import java.util.List;

public class LCLogResponse {

    private String rawEventData;
    private String comment;
    private String category;
    private String message;
    private String instanceID;
    private String creationTimeStamp;
    private String perceivedSeverity;
    private String configResultsAvailable;
    private String fQDD;
    private String logInstanceID;
    private String elementName;
    private List<String> messageArguments = null;
    private String owningEntity;
    private String sequenceNumber;
    private String agentID;
    private String recordID;
    private String logName;
    private String messageID;

    public String getRawEventData() {
        return rawEventData;
    }

    public void setRawEventData(String rawEventData) {
        this.rawEventData = rawEventData;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInstanceID() {
        return instanceID;
    }

    public void setInstanceID(String instanceID) {
        this.instanceID = instanceID;
    }

    public String getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public void setCreationTimeStamp(String creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    public String getPerceivedSeverity() {
        return perceivedSeverity;
    }

    public void setPerceivedSeverity(String perceivedSeverity) {
        this.perceivedSeverity = perceivedSeverity;
    }

    public String getConfigResultsAvailable() {
        return configResultsAvailable;
    }

    public void setConfigResultsAvailable(String configResultsAvailable) {
        this.configResultsAvailable = configResultsAvailable;
    }

    public String getFQDD() {
        return fQDD;
    }

    public void setFQDD(String fQDD) {
        this.fQDD = fQDD;
    }

    public String getLogInstanceID() {
        return logInstanceID;
    }

    public void setLogInstanceID(String logInstanceID) {
        this.logInstanceID = logInstanceID;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public List<String> getMessageArguments() {
        return messageArguments;
    }

    public void setMessageArguments(List<String> messageArguments) {
        this.messageArguments = messageArguments;
    }

    public String getOwningEntity() {
        return owningEntity;
    }

    public void setOwningEntity(String owningEntity) {
        this.owningEntity = owningEntity;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getAgentID() {
        return agentID;
    }

    public void setAgentID(String agentID) {
        this.agentID = agentID;
    }

    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

}
