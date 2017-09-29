/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.hardware;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "DeviceDescription",
    "RedundancyStatus",
    "PartNumber",
    "InstanceID",
    "TotalOutputPower",
    "DetailedState",
    "FQDD",
    "PrimaryStatus",
    "FirmwareVersion",
    "RedMinNumberNeeded",
    "Range1MaxInputPower",
    "RedTypeOfSet",
    "Type",
    "InputVoltage",
    "SerialNumber",
    "LastUpdateTime",
    "LastSystemInventoryTime",
    "Manufacturer",
    "Model",
    "PMBusMonitoring"
})
public class DCIMPowersupplyview {

    @JsonProperty("DeviceDescription")
    private String deviceDescription;
    @JsonProperty("RedundancyStatus")
    private String redundancyStatus;
    @JsonProperty("PartNumber")
    private String partNumber;
    @JsonProperty("InstanceID")
    private String instanceID;
    @JsonProperty("TotalOutputPower")
    private String totalOutputPower;
    @JsonProperty("DetailedState")
    private String detailedState;
    @JsonProperty("FQDD")
    private String fQDD;
    @JsonProperty("PrimaryStatus")
    private String primaryStatus;
    @JsonProperty("FirmwareVersion")
    private String firmwareVersion;
    @JsonProperty("RedMinNumberNeeded")
    private String redMinNumberNeeded;
    @JsonProperty("Range1MaxInputPower")
    private String range1MaxInputPower;
    @JsonProperty("RedTypeOfSet")
    private String redTypeOfSet;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("InputVoltage")
    private String inputVoltage;
    @JsonProperty("SerialNumber")
    private String serialNumber;
    @JsonProperty("LastUpdateTime")
    private String lastUpdateTime;
    @JsonProperty("LastSystemInventoryTime")
    private String lastSystemInventoryTime;
    @JsonProperty("Manufacturer")
    private String manufacturer;
    @JsonProperty("Model")
    private String model;
    @JsonProperty("PMBusMonitoring")
    private String pMBusMonitoring;

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

    @JsonProperty("PartNumber")
    public String getPartNumber() {
        return partNumber;
    }

    @JsonProperty("PartNumber")
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    @JsonProperty("InstanceID")
    public String getInstanceID() {
        return instanceID;
    }

    @JsonProperty("InstanceID")
    public void setInstanceID(String instanceID) {
        this.instanceID = instanceID;
    }

    @JsonProperty("TotalOutputPower")
    public String getTotalOutputPower() {
        return totalOutputPower;
    }

    @JsonProperty("TotalOutputPower")
    public void setTotalOutputPower(String totalOutputPower) {
        this.totalOutputPower = totalOutputPower;
    }

    @JsonProperty("DetailedState")
    public String getDetailedState() {
        return detailedState;
    }

    @JsonProperty("DetailedState")
    public void setDetailedState(String detailedState) {
        this.detailedState = detailedState;
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

    @JsonProperty("FirmwareVersion")
    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    @JsonProperty("FirmwareVersion")
    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    @JsonProperty("RedMinNumberNeeded")
    public String getRedMinNumberNeeded() {
        return redMinNumberNeeded;
    }

    @JsonProperty("RedMinNumberNeeded")
    public void setRedMinNumberNeeded(String redMinNumberNeeded) {
        this.redMinNumberNeeded = redMinNumberNeeded;
    }

    @JsonProperty("Range1MaxInputPower")
    public String getRange1MaxInputPower() {
        return range1MaxInputPower;
    }

    @JsonProperty("Range1MaxInputPower")
    public void setRange1MaxInputPower(String range1MaxInputPower) {
        this.range1MaxInputPower = range1MaxInputPower;
    }

    @JsonProperty("RedTypeOfSet")
    public String getRedTypeOfSet() {
        return redTypeOfSet;
    }

    @JsonProperty("RedTypeOfSet")
    public void setRedTypeOfSet(String redTypeOfSet) {
        this.redTypeOfSet = redTypeOfSet;
    }

    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("InputVoltage")
    public String getInputVoltage() {
        return inputVoltage;
    }

    @JsonProperty("InputVoltage")
    public void setInputVoltage(String inputVoltage) {
        this.inputVoltage = inputVoltage;
    }

    @JsonProperty("SerialNumber")
    public String getSerialNumber() {
        return serialNumber;
    }

    @JsonProperty("SerialNumber")
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @JsonProperty("LastUpdateTime")
    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    @JsonProperty("LastUpdateTime")
    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @JsonProperty("LastSystemInventoryTime")
    public String getLastSystemInventoryTime() {
        return lastSystemInventoryTime;
    }

    @JsonProperty("LastSystemInventoryTime")
    public void setLastSystemInventoryTime(String lastSystemInventoryTime) {
        this.lastSystemInventoryTime = lastSystemInventoryTime;
    }

    @JsonProperty("Manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    @JsonProperty("Manufacturer")
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @JsonProperty("Model")
    public String getModel() {
        return model;
    }

    @JsonProperty("Model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("PMBusMonitoring")
    public String getPMBusMonitoring() {
        return pMBusMonitoring;
    }

    @JsonProperty("PMBusMonitoring")
    public void setPMBusMonitoring(String pMBusMonitoring) {
        this.pMBusMonitoring = pMBusMonitoring;
    }

}
