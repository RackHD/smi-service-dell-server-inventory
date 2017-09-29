/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.nics;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "AttributeDisplayName",
    "InstanceID",
    "PendingValue",
    "PossibleValuesDescription",
    "CurrentValue",
    "AttributeName",
    "FQDD",
    "GroupDisplayName",
    "PossibleValues",
    "Dependency",
    "IsReadOnly",
    "GroupID"
})
public class DCIMNICEnumeration {

    @JsonProperty("AttributeDisplayName")
    private String attributeDisplayName;
    @JsonProperty("InstanceID")
    private String instanceID;
    @JsonProperty("PendingValue")
    private String pendingValue;
    @JsonProperty("PossibleValuesDescription")
    private List<String> possibleValuesDescription = null;
    @JsonProperty("CurrentValue")
    private String currentValue;
    @JsonProperty("AttributeName")
    private String attributeName;
    @JsonProperty("FQDD")
    private String fQDD;
    @JsonProperty("GroupDisplayName")
    private String groupDisplayName;
    @JsonProperty("PossibleValues")
    private List<String> possibleValues = null;
    @JsonProperty("Dependency")
    private String dependency;
    @JsonProperty("IsReadOnly")
    private String isReadOnly;
    @JsonProperty("GroupID")
    private String groupID;

    @JsonProperty("AttributeDisplayName")
    public String getAttributeDisplayName() {
        return attributeDisplayName;
    }

    @JsonProperty("AttributeDisplayName")
    public void setAttributeDisplayName(String attributeDisplayName) {
        this.attributeDisplayName = attributeDisplayName;
    }

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

    @JsonProperty("PossibleValuesDescription")
    public List<String> getPossibleValuesDescription() {
        return possibleValuesDescription;
    }

    @JsonProperty("PossibleValuesDescription")
    public void setPossibleValuesDescription(List<String> possibleValuesDescription) {
        this.possibleValuesDescription = possibleValuesDescription;
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

    @JsonProperty("GroupDisplayName")
    public String getGroupDisplayName() {
        return groupDisplayName;
    }

    @JsonProperty("GroupDisplayName")
    public void setGroupDisplayName(String groupDisplayName) {
        this.groupDisplayName = groupDisplayName;
    }

    @JsonProperty("PossibleValues")
    public List<String> getPossibleValues() {
        return possibleValues;
    }

    @JsonProperty("PossibleValues")
    public void setPossibleValues(List<String> possibleValues) {
        this.possibleValues = possibleValues;
    }

    @JsonProperty("Dependency")
    public String getDependency() {
        return dependency;
    }

    @JsonProperty("Dependency")
    public void setDependency(String dependency) {
        this.dependency = dependency;
    }

    @JsonProperty("IsReadOnly")
    public String getIsReadOnly() {
        return isReadOnly;
    }

    @JsonProperty("IsReadOnly")
    public void setIsReadOnly(String isReadOnly) {
        this.isReadOnly = isReadOnly;
    }

    @JsonProperty("GroupID")
    public String getGroupID() {
        return groupID;
    }

    @JsonProperty("GroupID")
    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

}
