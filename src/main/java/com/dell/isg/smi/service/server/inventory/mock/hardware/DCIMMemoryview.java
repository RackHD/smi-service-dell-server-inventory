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
    "Speed",
    "PartNumber",
    "InstanceID",
    "ManufactureDate",
    "Size",
    "FQDD",
    "Rank",
    "PrimaryStatus",
    "BankLabel",
    "CurrentOperatingSpeed",
    "SerialNumber",
    "LastUpdateTime",
    "LastSystemInventoryTime",
    "Manufacturer",
    "Model",
    "MemoryType"
})
public class DCIMMemoryview {

    @JsonProperty("DeviceDescription")
    private String deviceDescription;
    @JsonProperty("Speed")
    private String speed;
    @JsonProperty("PartNumber")
    private String partNumber;
    @JsonProperty("InstanceID")
    private String instanceID;
    @JsonProperty("ManufactureDate")
    private String manufactureDate;
    @JsonProperty("Size")
    private String size;
    @JsonProperty("FQDD")
    private String fQDD;
    @JsonProperty("Rank")
    private String rank;
    @JsonProperty("PrimaryStatus")
    private String primaryStatus;
    @JsonProperty("BankLabel")
    private String bankLabel;
    @JsonProperty("CurrentOperatingSpeed")
    private String currentOperatingSpeed;
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
    @JsonProperty("MemoryType")
    private String memoryType;

    @JsonProperty("DeviceDescription")
    public String getDeviceDescription() {
        return deviceDescription;
    }

    @JsonProperty("DeviceDescription")
    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    @JsonProperty("Speed")
    public String getSpeed() {
        return speed;
    }

    @JsonProperty("Speed")
    public void setSpeed(String speed) {
        this.speed = speed;
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

    @JsonProperty("ManufactureDate")
    public String getManufactureDate() {
        return manufactureDate;
    }

    @JsonProperty("ManufactureDate")
    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @JsonProperty("Size")
    public String getSize() {
        return size;
    }

    @JsonProperty("Size")
    public void setSize(String size) {
        this.size = size;
    }

    @JsonProperty("FQDD")
    public String getFQDD() {
        return fQDD;
    }

    @JsonProperty("FQDD")
    public void setFQDD(String fQDD) {
        this.fQDD = fQDD;
    }

    @JsonProperty("Rank")
    public String getRank() {
        return rank;
    }

    @JsonProperty("Rank")
    public void setRank(String rank) {
        this.rank = rank;
    }

    @JsonProperty("PrimaryStatus")
    public String getPrimaryStatus() {
        return primaryStatus;
    }

    @JsonProperty("PrimaryStatus")
    public void setPrimaryStatus(String primaryStatus) {
        this.primaryStatus = primaryStatus;
    }

    @JsonProperty("BankLabel")
    public String getBankLabel() {
        return bankLabel;
    }

    @JsonProperty("BankLabel")
    public void setBankLabel(String bankLabel) {
        this.bankLabel = bankLabel;
    }

    @JsonProperty("CurrentOperatingSpeed")
    public String getCurrentOperatingSpeed() {
        return currentOperatingSpeed;
    }

    @JsonProperty("CurrentOperatingSpeed")
    public void setCurrentOperatingSpeed(String currentOperatingSpeed) {
        this.currentOperatingSpeed = currentOperatingSpeed;
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

    @JsonProperty("MemoryType")
    public String getMemoryType() {
        return memoryType;
    }

    @JsonProperty("MemoryType")
    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

}
