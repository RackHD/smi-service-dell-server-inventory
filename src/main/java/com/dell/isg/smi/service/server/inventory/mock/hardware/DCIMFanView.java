/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.hardware;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "BaseUnits",
    "DeviceDescription",
    "RedundancyStatus",
    "RateUnits",
    "InstanceID",
    "ActiveCooling",
    "PWM",
    "VariableSpeed",
    "FQDD",
    "PrimaryStatus",
    "LastUpdateTime",
    "UnitModifier",
    "LastSystemInventoryTime",
    "CurrentReading"
})
public class DCIMFanView {

    @JsonProperty("BaseUnits")
    private String baseUnits;
    @JsonProperty("DeviceDescription")
    private String deviceDescription;
    @JsonProperty("RedundancyStatus")
    private String redundancyStatus;
    @JsonProperty("RateUnits")
    private String rateUnits;
    @JsonProperty("InstanceID")
    private String instanceID;
    @JsonProperty("ActiveCooling")
    private String activeCooling;
    @JsonProperty("PWM")
    private String pWM;
    @JsonProperty("VariableSpeed")
    private String variableSpeed;
    @JsonProperty("FQDD")
    private String fQDD;
    @JsonProperty("PrimaryStatus")
    private String primaryStatus;
    @JsonProperty("LastUpdateTime")
    private String lastUpdateTime;
    @JsonProperty("UnitModifier")
    private String unitModifier;
    @JsonProperty("LastSystemInventoryTime")
    private String lastSystemInventoryTime;
    @JsonProperty("CurrentReading")
    private String currentReading;

    @JsonProperty("BaseUnits")
    public String getBaseUnits() {
        return baseUnits;
    }

    @JsonProperty("BaseUnits")
    public void setBaseUnits(String baseUnits) {
        this.baseUnits = baseUnits;
    }

    @JsonProperty("DeviceDescription")
    public String getDeviceDescription() {
        return deviceDescription;
    }

    @JsonProperty("DeviceDescription")
    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    @JsonProperty("RedundancyStatus")
    public String getRedundancyStatus() {
        return redundancyStatus;
    }

    @JsonProperty("RedundancyStatus")
    public void setRedundancyStatus(String redundancyStatus) {
        this.redundancyStatus = redundancyStatus;
    }

    @JsonProperty("RateUnits")
    public String getRateUnits() {
        return rateUnits;
    }

    @JsonProperty("RateUnits")
    public void setRateUnits(String rateUnits) {
        this.rateUnits = rateUnits;
    }

    @JsonProperty("InstanceID")
    public String getInstanceID() {
        return instanceID;
    }

    @JsonProperty("InstanceID")
    public void setInstanceID(String instanceID) {
        this.instanceID = instanceID;
    }

    @JsonProperty("ActiveCooling")
    public String getActiveCooling() {
        return activeCooling;
    }

    @JsonProperty("ActiveCooling")
    public void setActiveCooling(String activeCooling) {
        this.activeCooling = activeCooling;
    }

    @JsonProperty("PWM")
    public String getPWM() {
        return pWM;
    }

    @JsonProperty("PWM")
    public void setPWM(String pWM) {
        this.pWM = pWM;
    }

    @JsonProperty("VariableSpeed")
    public String getVariableSpeed() {
        return variableSpeed;
    }

    @JsonProperty("VariableSpeed")
    public void setVariableSpeed(String variableSpeed) {
        this.variableSpeed = variableSpeed;
    }

    @JsonProperty("FQDD")
    public String getFQDD() {
        return fQDD;
    }

    @JsonProperty("FQDD")
    public void setFQDD(String fQDD) {
        this.fQDD = fQDD;
    }

    @JsonProperty("PrimaryStatus")
    public String getPrimaryStatus() {
        return primaryStatus;
    }

    @JsonProperty("PrimaryStatus")
    public void setPrimaryStatus(String primaryStatus) {
        this.primaryStatus = primaryStatus;
    }

    @JsonProperty("LastUpdateTime")
    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    @JsonProperty("LastUpdateTime")
    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @JsonProperty("UnitModifier")
    public String getUnitModifier() {
        return unitModifier;
    }

    @JsonProperty("UnitModifier")
    public void setUnitModifier(String unitModifier) {
        this.unitModifier = unitModifier;
    }

    @JsonProperty("LastSystemInventoryTime")
    public String getLastSystemInventoryTime() {
        return lastSystemInventoryTime;
    }

    @JsonProperty("LastSystemInventoryTime")
    public void setLastSystemInventoryTime(String lastSystemInventoryTime) {
        this.lastSystemInventoryTime = lastSystemInventoryTime;
    }

    @JsonProperty("CurrentReading")
    public String getCurrentReading() {
        return currentReading;
    }

    @JsonProperty("CurrentReading")
    public void setCurrentReading(String currentReading) {
        this.currentReading = currentReading;
    }

}
