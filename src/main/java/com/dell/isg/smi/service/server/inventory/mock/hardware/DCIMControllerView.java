/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.hardware;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "MaxAvailablePCILinkSpeed",
    "DeviceDescription",
    "ProductName",
    "SlicedVDCapability",
    "InstanceID",
    "RealtimeCapability",
    "KeyID",
    "SupportEnhancedAutoForeignImport",
    "RollupStatus",
    "Function",
    "LastUpdateTime",
    "SupportRAID10UnevenSpans",
    "SecurityStatus",
    "DeviceCardSlotLength",
    "PCISubDeviceID",
    "MaxPossiblePCILinkSpeed",
    "Bus",
    "DeviceCardDataBusWidth",
    "PCIVendorID",
    "SupportControllerBootMode",
    "PCISubVendorID",
    "DeviceCardManufacturer",
    "EncryptionCapability",
    "Device",
    "PCISlot",
    "FQDD",
    "PatrolReadState",
    "PCIDeviceID",
    "PrimaryStatus",
    "SASAddress",
    "CacheSizeInMB",
    "DriverVersion",
    "LastSystemInventoryTime",
    "DeviceCardSlotType",
    "ControllerFirmwareVersion",
    "CachecadeCapability",
    "T10PICapability",
    "EncryptionMode"
})
public class DCIMControllerView {

    @JsonProperty("MaxAvailablePCILinkSpeed")
    private String maxAvailablePCILinkSpeed;
    @JsonProperty("DeviceDescription")
    private String deviceDescription;
    @JsonProperty("ProductName")
    private String productName;
    @JsonProperty("SlicedVDCapability")
    private String slicedVDCapability;
    @JsonProperty("InstanceID")
    private String instanceID;
    @JsonProperty("RealtimeCapability")
    private String realtimeCapability;
    @JsonProperty("KeyID")
    private String keyID;
    @JsonProperty("SupportEnhancedAutoForeignImport")
    private String supportEnhancedAutoForeignImport;
    @JsonProperty("RollupStatus")
    private String rollupStatus;
    @JsonProperty("Function")
    private String function;
    @JsonProperty("LastUpdateTime")
    private String lastUpdateTime;
    @JsonProperty("SupportRAID10UnevenSpans")
    private String supportRAID10UnevenSpans;
    @JsonProperty("SecurityStatus")
    private String securityStatus;
    @JsonProperty("DeviceCardSlotLength")
    private String deviceCardSlotLength;
    @JsonProperty("PCISubDeviceID")
    private String pCISubDeviceID;
    @JsonProperty("MaxPossiblePCILinkSpeed")
    private String maxPossiblePCILinkSpeed;
    @JsonProperty("Bus")
    private String bus;
    @JsonProperty("DeviceCardDataBusWidth")
    private String deviceCardDataBusWidth;
    @JsonProperty("PCIVendorID")
    private String pCIVendorID;
    @JsonProperty("SupportControllerBootMode")
    private String supportControllerBootMode;
    @JsonProperty("PCISubVendorID")
    private String pCISubVendorID;
    @JsonProperty("DeviceCardManufacturer")
    private String deviceCardManufacturer;
    @JsonProperty("EncryptionCapability")
    private String encryptionCapability;
    @JsonProperty("Device")
    private String device;
    @JsonProperty("PCISlot")
    private String pCISlot;
    @JsonProperty("FQDD")
    private String fQDD;
    @JsonProperty("PatrolReadState")
    private String patrolReadState;
    @JsonProperty("PCIDeviceID")
    private String pCIDeviceID;
    @JsonProperty("PrimaryStatus")
    private String primaryStatus;
    @JsonProperty("SASAddress")
    private String sASAddress;
    @JsonProperty("CacheSizeInMB")
    private String cacheSizeInMB;
    @JsonProperty("DriverVersion")
    private String driverVersion;
    @JsonProperty("LastSystemInventoryTime")
    private String lastSystemInventoryTime;
    @JsonProperty("DeviceCardSlotType")
    private String deviceCardSlotType;
    @JsonProperty("ControllerFirmwareVersion")
    private String controllerFirmwareVersion;
    @JsonProperty("CachecadeCapability")
    private String cachecadeCapability;
    @JsonProperty("T10PICapability")
    private String t10PICapability;
    @JsonProperty("EncryptionMode")
    private String encryptionMode;

    @JsonProperty("MaxAvailablePCILinkSpeed")
    public String getMaxAvailablePCILinkSpeed() {
        return maxAvailablePCILinkSpeed;
    }

    @JsonProperty("MaxAvailablePCILinkSpeed")
    public void setMaxAvailablePCILinkSpeed(String maxAvailablePCILinkSpeed) {
        this.maxAvailablePCILinkSpeed = maxAvailablePCILinkSpeed;
    }

    @JsonProperty("DeviceDescription")
    public String getDeviceDescription() {
        return deviceDescription;
    }

    @JsonProperty("DeviceDescription")
    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    @JsonProperty("ProductName")
    public String getProductName() {
        return productName;
    }

    @JsonProperty("ProductName")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @JsonProperty("SlicedVDCapability")
    public String getSlicedVDCapability() {
        return slicedVDCapability;
    }

    @JsonProperty("SlicedVDCapability")
    public void setSlicedVDCapability(String slicedVDCapability) {
        this.slicedVDCapability = slicedVDCapability;
    }

    @JsonProperty("InstanceID")
    public String getInstanceID() {
        return instanceID;
    }

    @JsonProperty("InstanceID")
    public void setInstanceID(String instanceID) {
        this.instanceID = instanceID;
    }

    @JsonProperty("RealtimeCapability")
    public String getRealtimeCapability() {
        return realtimeCapability;
    }

    @JsonProperty("RealtimeCapability")
    public void setRealtimeCapability(String realtimeCapability) {
        this.realtimeCapability = realtimeCapability;
    }

    @JsonProperty("KeyID")
    public String getKeyID() {
        return keyID;
    }

    @JsonProperty("KeyID")
    public void setKeyID(String keyID) {
        this.keyID = keyID;
    }

    @JsonProperty("SupportEnhancedAutoForeignImport")
    public String getSupportEnhancedAutoForeignImport() {
        return supportEnhancedAutoForeignImport;
    }

    @JsonProperty("SupportEnhancedAutoForeignImport")
    public void setSupportEnhancedAutoForeignImport(String supportEnhancedAutoForeignImport) {
        this.supportEnhancedAutoForeignImport = supportEnhancedAutoForeignImport;
    }

    @JsonProperty("RollupStatus")
    public String getRollupStatus() {
        return rollupStatus;
    }

    @JsonProperty("RollupStatus")
    public void setRollupStatus(String rollupStatus) {
        this.rollupStatus = rollupStatus;
    }

    @JsonProperty("Function")
    public String getFunction() {
        return function;
    }

    @JsonProperty("Function")
    public void setFunction(String function) {
        this.function = function;
    }

    @JsonProperty("LastUpdateTime")
    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    @JsonProperty("LastUpdateTime")
    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @JsonProperty("SupportRAID10UnevenSpans")
    public String getSupportRAID10UnevenSpans() {
        return supportRAID10UnevenSpans;
    }

    @JsonProperty("SupportRAID10UnevenSpans")
    public void setSupportRAID10UnevenSpans(String supportRAID10UnevenSpans) {
        this.supportRAID10UnevenSpans = supportRAID10UnevenSpans;
    }

    @JsonProperty("SecurityStatus")
    public String getSecurityStatus() {
        return securityStatus;
    }

    @JsonProperty("SecurityStatus")
    public void setSecurityStatus(String securityStatus) {
        this.securityStatus = securityStatus;
    }

    @JsonProperty("DeviceCardSlotLength")
    public String getDeviceCardSlotLength() {
        return deviceCardSlotLength;
    }

    @JsonProperty("DeviceCardSlotLength")
    public void setDeviceCardSlotLength(String deviceCardSlotLength) {
        this.deviceCardSlotLength = deviceCardSlotLength;
    }

    @JsonProperty("PCISubDeviceID")
    public String getPCISubDeviceID() {
        return pCISubDeviceID;
    }

    @JsonProperty("PCISubDeviceID")
    public void setPCISubDeviceID(String pCISubDeviceID) {
        this.pCISubDeviceID = pCISubDeviceID;
    }

    @JsonProperty("MaxPossiblePCILinkSpeed")
    public String getMaxPossiblePCILinkSpeed() {
        return maxPossiblePCILinkSpeed;
    }

    @JsonProperty("MaxPossiblePCILinkSpeed")
    public void setMaxPossiblePCILinkSpeed(String maxPossiblePCILinkSpeed) {
        this.maxPossiblePCILinkSpeed = maxPossiblePCILinkSpeed;
    }

    @JsonProperty("Bus")
    public String getBus() {
        return bus;
    }

    @JsonProperty("Bus")
    public void setBus(String bus) {
        this.bus = bus;
    }

    @JsonProperty("DeviceCardDataBusWidth")
    public String getDeviceCardDataBusWidth() {
        return deviceCardDataBusWidth;
    }

    @JsonProperty("DeviceCardDataBusWidth")
    public void setDeviceCardDataBusWidth(String deviceCardDataBusWidth) {
        this.deviceCardDataBusWidth = deviceCardDataBusWidth;
    }

    @JsonProperty("PCIVendorID")
    public String getPCIVendorID() {
        return pCIVendorID;
    }

    @JsonProperty("PCIVendorID")
    public void setPCIVendorID(String pCIVendorID) {
        this.pCIVendorID = pCIVendorID;
    }

    @JsonProperty("SupportControllerBootMode")
    public String getSupportControllerBootMode() {
        return supportControllerBootMode;
    }

    @JsonProperty("SupportControllerBootMode")
    public void setSupportControllerBootMode(String supportControllerBootMode) {
        this.supportControllerBootMode = supportControllerBootMode;
    }

    @JsonProperty("PCISubVendorID")
    public String getPCISubVendorID() {
        return pCISubVendorID;
    }

    @JsonProperty("PCISubVendorID")
    public void setPCISubVendorID(String pCISubVendorID) {
        this.pCISubVendorID = pCISubVendorID;
    }

    @JsonProperty("DeviceCardManufacturer")
    public String getDeviceCardManufacturer() {
        return deviceCardManufacturer;
    }

    @JsonProperty("DeviceCardManufacturer")
    public void setDeviceCardManufacturer(String deviceCardManufacturer) {
        this.deviceCardManufacturer = deviceCardManufacturer;
    }

    @JsonProperty("EncryptionCapability")
    public String getEncryptionCapability() {
        return encryptionCapability;
    }

    @JsonProperty("EncryptionCapability")
    public void setEncryptionCapability(String encryptionCapability) {
        this.encryptionCapability = encryptionCapability;
    }

    @JsonProperty("Device")
    public String getDevice() {
        return device;
    }

    @JsonProperty("Device")
    public void setDevice(String device) {
        this.device = device;
    }

    @JsonProperty("PCISlot")
    public String getPCISlot() {
        return pCISlot;
    }

    @JsonProperty("PCISlot")
    public void setPCISlot(String pCISlot) {
        this.pCISlot = pCISlot;
    }

    @JsonProperty("FQDD")
    public String getFQDD() {
        return fQDD;
    }

    @JsonProperty("FQDD")
    public void setFQDD(String fQDD) {
        this.fQDD = fQDD;
    }

    @JsonProperty("PatrolReadState")
    public String getPatrolReadState() {
        return patrolReadState;
    }

    @JsonProperty("PatrolReadState")
    public void setPatrolReadState(String patrolReadState) {
        this.patrolReadState = patrolReadState;
    }

    @JsonProperty("PCIDeviceID")
    public String getPCIDeviceID() {
        return pCIDeviceID;
    }

    @JsonProperty("PCIDeviceID")
    public void setPCIDeviceID(String pCIDeviceID) {
        this.pCIDeviceID = pCIDeviceID;
    }

    @JsonProperty("PrimaryStatus")
    public String getPrimaryStatus() {
        return primaryStatus;
    }

    @JsonProperty("PrimaryStatus")
    public void setPrimaryStatus(String primaryStatus) {
        this.primaryStatus = primaryStatus;
    }

    @JsonProperty("SASAddress")
    public String getSASAddress() {
        return sASAddress;
    }

    @JsonProperty("SASAddress")
    public void setSASAddress(String sASAddress) {
        this.sASAddress = sASAddress;
    }

    @JsonProperty("CacheSizeInMB")
    public String getCacheSizeInMB() {
        return cacheSizeInMB;
    }

    @JsonProperty("CacheSizeInMB")
    public void setCacheSizeInMB(String cacheSizeInMB) {
        this.cacheSizeInMB = cacheSizeInMB;
    }

    @JsonProperty("DriverVersion")
    public String getDriverVersion() {
        return driverVersion;
    }

    @JsonProperty("DriverVersion")
    public void setDriverVersion(String driverVersion) {
        this.driverVersion = driverVersion;
    }

    @JsonProperty("LastSystemInventoryTime")
    public String getLastSystemInventoryTime() {
        return lastSystemInventoryTime;
    }

    @JsonProperty("LastSystemInventoryTime")
    public void setLastSystemInventoryTime(String lastSystemInventoryTime) {
        this.lastSystemInventoryTime = lastSystemInventoryTime;
    }

    @JsonProperty("DeviceCardSlotType")
    public String getDeviceCardSlotType() {
        return deviceCardSlotType;
    }

    @JsonProperty("DeviceCardSlotType")
    public void setDeviceCardSlotType(String deviceCardSlotType) {
        this.deviceCardSlotType = deviceCardSlotType;
    }

    @JsonProperty("ControllerFirmwareVersion")
    public String getControllerFirmwareVersion() {
        return controllerFirmwareVersion;
    }

    @JsonProperty("ControllerFirmwareVersion")
    public void setControllerFirmwareVersion(String controllerFirmwareVersion) {
        this.controllerFirmwareVersion = controllerFirmwareVersion;
    }

    @JsonProperty("CachecadeCapability")
    public String getCachecadeCapability() {
        return cachecadeCapability;
    }

    @JsonProperty("CachecadeCapability")
    public void setCachecadeCapability(String cachecadeCapability) {
        this.cachecadeCapability = cachecadeCapability;
    }

    @JsonProperty("T10PICapability")
    public String getT10PICapability() {
        return t10PICapability;
    }

    @JsonProperty("T10PICapability")
    public void setT10PICapability(String t10PICapability) {
        this.t10PICapability = t10PICapability;
    }

    @JsonProperty("EncryptionMode")
    public String getEncryptionMode() {
        return encryptionMode;
    }

    @JsonProperty("EncryptionMode")
    public void setEncryptionMode(String encryptionMode) {
        this.encryptionMode = encryptionMode;
    }

}
