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
    "SensorType",
    "OtherSensorTypeDescription",
    "DeviceID",
    "SystemCreationClassName",
    "OperationalStatus",
    "PrimaryStatus",
    "RequestedState",
    "PossibleStates",
    "ElementName",
    "CreationClassName",
    "CurrentState",
    "SystemName",
    "EnabledState",
    "HealthState"
})
public class DCIMSensor {

    @JsonProperty("SensorType")
    private String sensorType;
    @JsonProperty("OtherSensorTypeDescription")
    private String otherSensorTypeDescription;
    @JsonProperty("DeviceID")
    private String deviceID;
    @JsonProperty("SystemCreationClassName")
    private String systemCreationClassName;
    @JsonProperty("OperationalStatus")
    private String operationalStatus;
    @JsonProperty("PrimaryStatus")
    private String primaryStatus;
    @JsonProperty("RequestedState")
    private String requestedState;
    @JsonProperty("PossibleStates")
    private List<String> possibleStates = null;
    @JsonProperty("ElementName")
    private String elementName;
    @JsonProperty("CreationClassName")
    private String creationClassName;
    @JsonProperty("CurrentState")
    private String currentState;
    @JsonProperty("SystemName")
    private String systemName;
    @JsonProperty("EnabledState")
    private String enabledState;
    @JsonProperty("HealthState")
    private String healthState;

    @JsonProperty("SensorType")
    public String getSensorType() {
        return sensorType;
    }

    @JsonProperty("SensorType")
    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    @JsonProperty("OtherSensorTypeDescription")
    public String getOtherSensorTypeDescription() {
        return otherSensorTypeDescription;
    }

    @JsonProperty("OtherSensorTypeDescription")
    public void setOtherSensorTypeDescription(String otherSensorTypeDescription) {
        this.otherSensorTypeDescription = otherSensorTypeDescription;
    }

    @JsonProperty("DeviceID")
    public String getDeviceID() {
        return deviceID;
    }

    @JsonProperty("DeviceID")
    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    @JsonProperty("SystemCreationClassName")
    public String getSystemCreationClassName() {
        return systemCreationClassName;
    }

    @JsonProperty("SystemCreationClassName")
    public void setSystemCreationClassName(String systemCreationClassName) {
        this.systemCreationClassName = systemCreationClassName;
    }

    @JsonProperty("OperationalStatus")
    public String getOperationalStatus() {
        return operationalStatus;
    }

    @JsonProperty("OperationalStatus")
    public void setOperationalStatus(String operationalStatus) {
        this.operationalStatus = operationalStatus;
    }

    @JsonProperty("PrimaryStatus")
    public String getPrimaryStatus() {
        return primaryStatus;
    }

    @JsonProperty("PrimaryStatus")
    public void setPrimaryStatus(String primaryStatus) {
        this.primaryStatus = primaryStatus;
    }

    @JsonProperty("RequestedState")
    public String getRequestedState() {
        return requestedState;
    }

    @JsonProperty("RequestedState")
    public void setRequestedState(String requestedState) {
        this.requestedState = requestedState;
    }

    @JsonProperty("PossibleStates")
    public List<String> getPossibleStates() {
        return possibleStates;
    }

    @JsonProperty("PossibleStates")
    public void setPossibleStates(List<String> possibleStates) {
        this.possibleStates = possibleStates;
    }

    @JsonProperty("ElementName")
    public String getElementName() {
        return elementName;
    }

    @JsonProperty("ElementName")
    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    @JsonProperty("CreationClassName")
    public String getCreationClassName() {
        return creationClassName;
    }

    @JsonProperty("CreationClassName")
    public void setCreationClassName(String creationClassName) {
        this.creationClassName = creationClassName;
    }

    @JsonProperty("CurrentState")
    public String getCurrentState() {
        return currentState;
    }

    @JsonProperty("CurrentState")
    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    @JsonProperty("SystemName")
    public String getSystemName() {
        return systemName;
    }

    @JsonProperty("SystemName")
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    @JsonProperty("EnabledState")
    public String getEnabledState() {
        return enabledState;
    }

    @JsonProperty("EnabledState")
    public void setEnabledState(String enabledState) {
        this.enabledState = enabledState;
    }

    @JsonProperty("HealthState")
    public String getHealthState() {
        return healthState;
    }

    @JsonProperty("HealthState")
    public void setHealthState(String healthState) {
        this.healthState = healthState;
    }

}
