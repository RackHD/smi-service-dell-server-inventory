/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.hardware;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "InstanceID",
    "PendingValue",
    "CurrentValue",
    "AttributeName",
    "FQDD",
    "PossibleValues",
    "IsReadOnly"
})
public class DCIMRAIDEnumeration {

    @JsonProperty("InstanceID")
    private String instanceID;
    @JsonProperty("PendingValue")
    private String pendingValue;
    @JsonProperty("CurrentValue")
    private String currentValue;
    @JsonProperty("AttributeName")
    private String attributeName;
    @JsonProperty("FQDD")
    private String fQDD;
    @JsonProperty("PossibleValues")
    private List<String> possibleValues = null;
    @JsonProperty("IsReadOnly")
    private String isReadOnly;

    @JsonProperty("InstanceID")
    public String getInstanceID() {
        return instanceID;
    }

    @JsonProperty("InstanceID")
    public void setInstanceID(String instanceID) {
        this.instanceID = instanceID;
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

    @JsonProperty("PossibleValues")
    public List<String> getPossibleValues() {
        return possibleValues;
    }

    @JsonProperty("PossibleValues")
    public void setPossibleValues(List<String> possibleValues) {
        this.possibleValues = possibleValues;
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
