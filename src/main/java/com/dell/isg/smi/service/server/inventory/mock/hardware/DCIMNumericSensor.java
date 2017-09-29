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
    "LowerThresholdNonCritical",
    "RateUnits",
    "LowerThresholdCritical",
    "SystemCreationClassName",
    "EnabledDefault",
    "RequestedState",
    "ValueFormulation",
    "ElementName",
    "CurrentState",
    "UnitModifier",
    "CurrentReading",
    "SystemName",
    "EnabledState",
    "BaseUnits",
    "TransitioningToState",
    "SensorType",
    "OtherSensorTypeDescription",
    "DeviceID",
    "UpperThresholdCritical",
    "OperationalStatus",
    "PrimaryStatus",
    "PossibleStates",
    "SettableThresholds",
    "CreationClassName",
    "SupportedThresholds",
    "HealthState",
    "UpperThresholdNonCritical"
})
public class DCIMNumericSensor {

    @JsonProperty("LowerThresholdNonCritical")
    private String lowerThresholdNonCritical;
    @JsonProperty("RateUnits")
    private String rateUnits;
    @JsonProperty("LowerThresholdCritical")
    private String lowerThresholdCritical;
    @JsonProperty("SystemCreationClassName")
    private String systemCreationClassName;
    @JsonProperty("EnabledDefault")
    private String enabledDefault;
    @JsonProperty("RequestedState")
    private String requestedState;
    @JsonProperty("ValueFormulation")
    private String valueFormulation;
    @JsonProperty("ElementName")
    private String elementName;
    @JsonProperty("CurrentState")
    private String currentState;
    @JsonProperty("UnitModifier")
    private String unitModifier;
    @JsonProperty("CurrentReading")
    private String currentReading;
    @JsonProperty("SystemName")
    private String systemName;
    @JsonProperty("EnabledState")
    private String enabledState;
    @JsonProperty("BaseUnits")
    private String baseUnits;
    @JsonProperty("TransitioningToState")
    private String transitioningToState;
    @JsonProperty("SensorType")
    private String sensorType;
    @JsonProperty("OtherSensorTypeDescription")
    private String otherSensorTypeDescription;
    @JsonProperty("DeviceID")
    private String deviceID;
    @JsonProperty("UpperThresholdCritical")
    private String upperThresholdCritical;
    @JsonProperty("OperationalStatus")
    private String operationalStatus;
    @JsonProperty("PrimaryStatus")
    private String primaryStatus;
    @JsonProperty("PossibleStates")
    private List<String> possibleStates = null;
    @JsonProperty("SettableThresholds")
    private List<String> settableThresholds = null;
    @JsonProperty("CreationClassName")
    private String creationClassName;
    @JsonProperty("SupportedThresholds")
    private List<String> supportedThresholds = null;
    @JsonProperty("HealthState")
    private String healthState;
    @JsonProperty("UpperThresholdNonCritical")
    private String upperThresholdNonCritical;

    @JsonProperty("LowerThresholdNonCritical")
    public String getLowerThresholdNonCritical() {
        return lowerThresholdNonCritical;
    }

    @JsonProperty("LowerThresholdNonCritical")
    public void setLowerThresholdNonCritical(String lowerThresholdNonCritical) {
        this.lowerThresholdNonCritical = lowerThresholdNonCritical;
    }

    @JsonProperty("RateUnits")
    public String getRateUnits() {
        return rateUnits;
    }

    @JsonProperty("RateUnits")
    public void setRateUnits(String rateUnits) {
        this.rateUnits = rateUnits;
    }

    @JsonProperty("LowerThresholdCritical")
    public String getLowerThresholdCritical() {
        return lowerThresholdCritical;
    }

    @JsonProperty("LowerThresholdCritical")
    public void setLowerThresholdCritical(String lowerThresholdCritical) {
        this.lowerThresholdCritical = lowerThresholdCritical;
    }

    @JsonProperty("SystemCreationClassName")
    public String getSystemCreationClassName() {
        return systemCreationClassName;
    }

    @JsonProperty("SystemCreationClassName")
    public void setSystemCreationClassName(String systemCreationClassName) {
        this.systemCreationClassName = systemCreationClassName;
    }

    @JsonProperty("EnabledDefault")
    public String getEnabledDefault() {
        return enabledDefault;
    }

    @JsonProperty("EnabledDefault")
    public void setEnabledDefault(String enabledDefault) {
        this.enabledDefault = enabledDefault;
    }

    @JsonProperty("RequestedState")
    public String getRequestedState() {
        return requestedState;
    }

    @JsonProperty("RequestedState")
    public void setRequestedState(String requestedState) {
        this.requestedState = requestedState;
    }

    @JsonProperty("ValueFormulation")
    public String getValueFormulation() {
        return valueFormulation;
    }

    @JsonProperty("ValueFormulation")
    public void setValueFormulation(String valueFormulation) {
        this.valueFormulation = valueFormulation;
    }

    @JsonProperty("ElementName")
    public String getElementName() {
        return elementName;
    }

    @JsonProperty("ElementName")
    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    @JsonProperty("CurrentState")
    public String getCurrentState() {
        return currentState;
    }

    @JsonProperty("CurrentState")
    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    @JsonProperty("UnitModifier")
    public String getUnitModifier() {
        return unitModifier;
    }

    @JsonProperty("UnitModifier")
    public void setUnitModifier(String unitModifier) {
        this.unitModifier = unitModifier;
    }

    @JsonProperty("CurrentReading")
    public String getCurrentReading() {
        return currentReading;
    }

    @JsonProperty("CurrentReading")
    public void setCurrentReading(String currentReading) {
        this.currentReading = currentReading;
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

    @JsonProperty("BaseUnits")
    public String getBaseUnits() {
        return baseUnits;
    }

    @JsonProperty("BaseUnits")
    public void setBaseUnits(String baseUnits) {
        this.baseUnits = baseUnits;
    }

    @JsonProperty("TransitioningToState")
    public String getTransitioningToState() {
        return transitioningToState;
    }

    @JsonProperty("TransitioningToState")
    public void setTransitioningToState(String transitioningToState) {
        this.transitioningToState = transitioningToState;
    }

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

    @JsonProperty("UpperThresholdCritical")
    public String getUpperThresholdCritical() {
        return upperThresholdCritical;
    }

    @JsonProperty("UpperThresholdCritical")
    public void setUpperThresholdCritical(String upperThresholdCritical) {
        this.upperThresholdCritical = upperThresholdCritical;
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

    @JsonProperty("PossibleStates")
    public List<String> getPossibleStates() {
        return possibleStates;
    }

    @JsonProperty("PossibleStates")
    public void setPossibleStates(List<String> possibleStates) {
        this.possibleStates = possibleStates;
    }

    @JsonProperty("SettableThresholds")
    public List<String> getSettableThresholds() {
        return settableThresholds;
    }

    @JsonProperty("SettableThresholds")
    public void setSettableThresholds(List<String> settableThresholds) {
        this.settableThresholds = settableThresholds;
    }

    @JsonProperty("CreationClassName")
    public String getCreationClassName() {
        return creationClassName;
    }

    @JsonProperty("CreationClassName")
    public void setCreationClassName(String creationClassName) {
        this.creationClassName = creationClassName;
    }

    @JsonProperty("SupportedThresholds")
    public List<String> getSupportedThresholds() {
        return supportedThresholds;
    }

    @JsonProperty("SupportedThresholds")
    public void setSupportedThresholds(List<String> supportedThresholds) {
        this.supportedThresholds = supportedThresholds;
    }

    @JsonProperty("HealthState")
    public String getHealthState() {
        return healthState;
    }

    @JsonProperty("HealthState")
    public void setHealthState(String healthState) {
        this.healthState = healthState;
    }

    @JsonProperty("UpperThresholdNonCritical")
    public String getUpperThresholdNonCritical() {
        return upperThresholdNonCritical;
    }

    @JsonProperty("UpperThresholdNonCritical")
    public void setUpperThresholdNonCritical(String upperThresholdNonCritical) {
        this.upperThresholdNonCritical = upperThresholdNonCritical;
    }

}
