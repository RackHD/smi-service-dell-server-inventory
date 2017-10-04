/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.nics;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "InstanceID",
    "PendingValue",
    "CurrentValue",
    "MinLength",
    "FQDD",
    "GroupDisplayName",
    "Dependency",
    "MaxLength",
    "GroupID",
    "AttributeDisplayName",
    "ValueExpression",
    "AttributeName",
    "IsReadOnly"
})
public class DCIMNICString {

    @JsonProperty("InstanceID")
    private String instanceID;
    @JsonProperty("PendingValue")
    private String pendingValue;
    @JsonProperty("CurrentValue")
    private String currentValue;
    @JsonProperty("MinLength")
    private String minLength;
    @JsonProperty("FQDD")
    private String fQDD;
    @JsonProperty("GroupDisplayName")
    private String groupDisplayName;
    @JsonProperty("Dependency")
    private String dependency;
    @JsonProperty("MaxLength")
    private String maxLength;
    @JsonProperty("GroupID")
    private String groupID;
    @JsonProperty("AttributeDisplayName")
    private String attributeDisplayName;
    @JsonProperty("ValueExpression")
    private String valueExpression;
    @JsonProperty("AttributeName")
    private String attributeName;
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

    @JsonProperty("MinLength")
    public String getMinLength() {
        return minLength;
    }

    @JsonProperty("MinLength")
    public void setMinLength(String minLength) {
        this.minLength = minLength;
    }

    @JsonProperty("FQDD")
    public String getFQDD() {
        return fQDD;
    }

    @JsonProperty("FQDD")
    public void setFQDD(String fQDD) {
        this.fQDD = fQDD;
    }

    @JsonProperty("GroupDisplayName")
    public String getGroupDisplayName() {
        return groupDisplayName;
    }

    @JsonProperty("GroupDisplayName")
    public void setGroupDisplayName(String groupDisplayName) {
        this.groupDisplayName = groupDisplayName;
    }

    @JsonProperty("Dependency")
    public String getDependency() {
        return dependency;
    }

    @JsonProperty("Dependency")
    public void setDependency(String dependency) {
        this.dependency = dependency;
    }

    @JsonProperty("MaxLength")
    public String getMaxLength() {
        return maxLength;
    }

    @JsonProperty("MaxLength")
    public void setMaxLength(String maxLength) {
        this.maxLength = maxLength;
    }

    @JsonProperty("GroupID")
    public String getGroupID() {
        return groupID;
    }

    @JsonProperty("GroupID")
    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    @JsonProperty("AttributeDisplayName")
    public String getAttributeDisplayName() {
        return attributeDisplayName;
    }

    @JsonProperty("AttributeDisplayName")
    public void setAttributeDisplayName(String attributeDisplayName) {
        this.attributeDisplayName = attributeDisplayName;
    }

    @JsonProperty("ValueExpression")
    public String getValueExpression() {
        return valueExpression;
    }

    @JsonProperty("ValueExpression")
    public void setValueExpression(String valueExpression) {
        this.valueExpression = valueExpression;
    }

    @JsonProperty("AttributeName")
    public String getAttributeName() {
        return attributeName;
    }

    @JsonProperty("AttributeName")
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
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
