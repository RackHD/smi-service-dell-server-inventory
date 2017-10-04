/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.hardware;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "LowerBound",
    "InstanceID",
    "UpperBound",
    "PendingValue",
    "CurrentValue",
    "AttributeName",
    "FQDD",
    "IsReadOnly"
})
public class DCIMRAIDInteger {

    @JsonProperty("LowerBound")
    private String lowerBound;
    @JsonProperty("InstanceID")
    private String instanceID;
    @JsonProperty("UpperBound")
    private String upperBound;
    @JsonProperty("PendingValue")
    private String pendingValue;
    @JsonProperty("CurrentValue")
    private String currentValue;
    @JsonProperty("AttributeName")
    private String attributeName;
    @JsonProperty("FQDD")
    private String fQDD;
    @JsonProperty("IsReadOnly")
    private String isReadOnly;

    @JsonProperty("LowerBound")
    public String getLowerBound() {
        return lowerBound;
    }

    @JsonProperty("LowerBound")
    public void setLowerBound(String lowerBound) {
        this.lowerBound = lowerBound;
    }

    @JsonProperty("InstanceID")
    public String getInstanceID() {
        return instanceID;
    }

    @JsonProperty("InstanceID")
    public void setInstanceID(String instanceID) {
        this.instanceID = instanceID;
    }

    @JsonProperty("UpperBound")
    public String getUpperBound() {
        return upperBound;
    }

    @JsonProperty("UpperBound")
    public void setUpperBound(String upperBound) {
        this.upperBound = upperBound;
    }

    @JsonProperty("PendingValue")
    public String getPendingValue() {
        return pendingValue;
    }

    @JsonProperty("PendingValue")
    public void setPendingValue(String pendingValue) {
        this.pendingValue = pendingValue;
    }

    @JsonProperty("CurrentValue")
    public String getCurrentValue() {
        return currentValue;
    }

    @JsonProperty("CurrentValue")
    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    @JsonProperty("AttributeName")
    public String getAttributeName() {
        return attributeName;
    }

    @JsonProperty("AttributeName")
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    @JsonProperty("FQDD")
    public String getFQDD() {
        return fQDD;
    }

    @JsonProperty("FQDD")
    public void setFQDD(String fQDD) {
        this.fQDD = fQDD;
    }

    @JsonProperty("IsReadOnly")
    public String getIsReadOnly() {
        return isReadOnly;
    }

    @JsonProperty("IsReadOnly")
    public void setIsReadOnly(String isReadOnly) {
        this.isReadOnly = isReadOnly;
    }

}
