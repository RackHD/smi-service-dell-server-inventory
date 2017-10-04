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
    "EstimatedExhaustTemperature",
    "InstanceID",
    "PSRollupStatus",
    "BoardPartNumber",
    "MemoryOperationMode",
    "SysMemLocation",
    "SystemID",
    "ChassisSystemHeight",
    "TempRollupStatus",
    "BIOSVersionString",
    "LastUpdateTime",
    "PlatformGUID",
    "SysMemTotalSize",
    "Manufacturer",
    "BIOSReleaseDate",
    "UUID",
    "HostName",
    "EstimatedSystemAirflow",
    "LifecycleControllerVersion",
    "PopulatedPCIeSlots",
    "PopulatedCPUSockets",
    "IntrusionRollupStatus",
    "StorageRollupStatus",
    "BoardSerialNumber",
    "FQDD",
    "LicensingRollupStatus",
    "PowerCap",
    "PrimaryStatus",
    "AssetTag",
    "SysMemPrimaryStatus",
    "PopulatedDIMMSlots",
    "CurrentRollupStatus",
    "BaseBoardChassisSlot",
    "MemoryRollupStatus",
    "ChassisServiceTag",
    "BatteryRollupStatus",
    "ExpressServiceCode",
    "ServiceTag",
    "SystemGeneration",
    "TempStatisticsRollupStatus",
    "RollupStatus",
    "IDSDMRollupStatus",
    "SysMemFailOverState",
    "CMCIP",
    "NodeID",
    "SysMemMaxCapacitySize",
    "MaxPCIeSlots",
    "MaxDIMMSlots",
    "PowerState",
    "SDCardRollupStatus",
    "ServerAllocation",
    "ChassisName",
    "FanRollupStatus",
    "CPURollupStatus",
    "smbiosGUID",
    "PowerCapEnabledState",
    "CPLDVersion",
    "LastSystemInventoryTime",
    "Model",
    "BladeGeometry",
    "SystemRevision",
    "SysMemErrorMethodology",
    "MaxCPUSockets",
    "ChassisModel",
    "VoltRollupStatus"
})
public class DCIMSystemView {

    @JsonProperty("DeviceDescription")
    private String deviceDescription;
    @JsonProperty("EstimatedExhaustTemperature")
    private String estimatedExhaustTemperature;
    @JsonProperty("InstanceID")
    private String instanceID;
    @JsonProperty("PSRollupStatus")
    private String pSRollupStatus;
    @JsonProperty("BoardPartNumber")
    private String boardPartNumber;
    @JsonProperty("MemoryOperationMode")
    private String memoryOperationMode;
    @JsonProperty("SysMemLocation")
    private String sysMemLocation;
    @JsonProperty("SystemID")
    private String systemID;
    @JsonProperty("ChassisSystemHeight")
    private String chassisSystemHeight;
    @JsonProperty("TempRollupStatus")
    private String tempRollupStatus;
    @JsonProperty("BIOSVersionString")
    private String bIOSVersionString;
    @JsonProperty("LastUpdateTime")
    private String lastUpdateTime;
    @JsonProperty("PlatformGUID")
    private String platformGUID;
    @JsonProperty("SysMemTotalSize")
    private String sysMemTotalSize;
    @JsonProperty("Manufacturer")
    private String manufacturer;
    @JsonProperty("BIOSReleaseDate")
    private String bIOSReleaseDate;
    @JsonProperty("UUID")
    private String uUID;
    @JsonProperty("HostName")
    private String hostName;
    @JsonProperty("EstimatedSystemAirflow")
    private String estimatedSystemAirflow;
    @JsonProperty("LifecycleControllerVersion")
    private String lifecycleControllerVersion;
    @JsonProperty("PopulatedPCIeSlots")
    private String populatedPCIeSlots;
    @JsonProperty("PopulatedCPUSockets")
    private String populatedCPUSockets;
    @JsonProperty("IntrusionRollupStatus")
    private String intrusionRollupStatus;
    @JsonProperty("StorageRollupStatus")
    private String storageRollupStatus;
    @JsonProperty("BoardSerialNumber")
    private String boardSerialNumber;
    @JsonProperty("FQDD")
    private String fQDD;
    @JsonProperty("LicensingRollupStatus")
    private String licensingRollupStatus;
    @JsonProperty("PowerCap")
    private String powerCap;
    @JsonProperty("PrimaryStatus")
    private String primaryStatus;
    @JsonProperty("AssetTag")
    private String assetTag;
    @JsonProperty("SysMemPrimaryStatus")
    private String sysMemPrimaryStatus;
    @JsonProperty("PopulatedDIMMSlots")
    private String populatedDIMMSlots;
    @JsonProperty("CurrentRollupStatus")
    private String currentRollupStatus;
    @JsonProperty("BaseBoardChassisSlot")
    private String baseBoardChassisSlot;
    @JsonProperty("MemoryRollupStatus")
    private String memoryRollupStatus;
    @JsonProperty("ChassisServiceTag")
    private String chassisServiceTag;
    @JsonProperty("BatteryRollupStatus")
    private String batteryRollupStatus;
    @JsonProperty("ExpressServiceCode")
    private String expressServiceCode;
    @JsonProperty("ServiceTag")
    private String serviceTag;
    @JsonProperty("SystemGeneration")
    private String systemGeneration;
    @JsonProperty("TempStatisticsRollupStatus")
    private String tempStatisticsRollupStatus;
    @JsonProperty("RollupStatus")
    private String rollupStatus;
    @JsonProperty("IDSDMRollupStatus")
    private String iDSDMRollupStatus;
    @JsonProperty("SysMemFailOverState")
    private String sysMemFailOverState;
    @JsonProperty("CMCIP")
    private String cMCIP;
    @JsonProperty("NodeID")
    private String nodeID;
    @JsonProperty("SysMemMaxCapacitySize")
    private String sysMemMaxCapacitySize;
    @JsonProperty("MaxPCIeSlots")
    private String maxPCIeSlots;
    @JsonProperty("MaxDIMMSlots")
    private String maxDIMMSlots;
    @JsonProperty("PowerState")
    private String powerState;
    @JsonProperty("SDCardRollupStatus")
    private String sDCardRollupStatus;
    @JsonProperty("ServerAllocation")
    private String serverAllocation;
    @JsonProperty("ChassisName")
    private String chassisName;
    @JsonProperty("FanRollupStatus")
    private String fanRollupStatus;
    @JsonProperty("CPURollupStatus")
    private String cPURollupStatus;
    @JsonProperty("smbiosGUID")
    private String smbiosGUID;
    @JsonProperty("PowerCapEnabledState")
    private String powerCapEnabledState;
    @JsonProperty("CPLDVersion")
    private String cPLDVersion;
    @JsonProperty("LastSystemInventoryTime")
    private String lastSystemInventoryTime;
    @JsonProperty("Model")
    private String model;
    @JsonProperty("BladeGeometry")
    private String bladeGeometry;
    @JsonProperty("SystemRevision")
    private String systemRevision;
    @JsonProperty("SysMemErrorMethodology")
    private String sysMemErrorMethodology;
    @JsonProperty("MaxCPUSockets")
    private String maxCPUSockets;
    @JsonProperty("ChassisModel")
    private String chassisModel;
    @JsonProperty("VoltRollupStatus")
    private String voltRollupStatus;

    @JsonProperty("DeviceDescription")
    public String getDeviceDescription() {
        return deviceDescription;
    }

    @JsonProperty("DeviceDescription")
    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    @JsonProperty("EstimatedExhaustTemperature")
    public String getEstimatedExhaustTemperature() {
        return estimatedExhaustTemperature;
    }

    @JsonProperty("EstimatedExhaustTemperature")
    public void setEstimatedExhaustTemperature(String estimatedExhaustTemperature) {
        this.estimatedExhaustTemperature = estimatedExhaustTemperature;
    }

    @JsonProperty("InstanceID")
    public String getInstanceID() {
        return instanceID;
    }

    @JsonProperty("InstanceID")
    public void setInstanceID(String instanceID) {
        this.instanceID = instanceID;
    }

    @JsonProperty("PSRollupStatus")
    public String getPSRollupStatus() {
        return pSRollupStatus;
    }

    @JsonProperty("PSRollupStatus")
    public void setPSRollupStatus(String pSRollupStatus) {
        this.pSRollupStatus = pSRollupStatus;
    }

    @JsonProperty("BoardPartNumber")
    public String getBoardPartNumber() {
        return boardPartNumber;
    }

    @JsonProperty("BoardPartNumber")
    public void setBoardPartNumber(String boardPartNumber) {
        this.boardPartNumber = boardPartNumber;
    }

    @JsonProperty("MemoryOperationMode")
    public String getMemoryOperationMode() {
        return memoryOperationMode;
    }

    @JsonProperty("MemoryOperationMode")
    public void setMemoryOperationMode(String memoryOperationMode) {
        this.memoryOperationMode = memoryOperationMode;
    }

    @JsonProperty("SysMemLocation")
    public String getSysMemLocation() {
        return sysMemLocation;
    }

    @JsonProperty("SysMemLocation")
    public void setSysMemLocation(String sysMemLocation) {
        this.sysMemLocation = sysMemLocation;
    }

    @JsonProperty("SystemID")
    public String getSystemID() {
        return systemID;
    }

    @JsonProperty("SystemID")
    public void setSystemID(String systemID) {
        this.systemID = systemID;
    }

    @JsonProperty("ChassisSystemHeight")
    public String getChassisSystemHeight() {
        return chassisSystemHeight;
    }

    @JsonProperty("ChassisSystemHeight")
    public void setChassisSystemHeight(String chassisSystemHeight) {
        this.chassisSystemHeight = chassisSystemHeight;
    }

    @JsonProperty("TempRollupStatus")
    public String getTempRollupStatus() {
        return tempRollupStatus;
    }

    @JsonProperty("TempRollupStatus")
    public void setTempRollupStatus(String tempRollupStatus) {
        this.tempRollupStatus = tempRollupStatus;
    }

    @JsonProperty("BIOSVersionString")
    public String getBIOSVersionString() {
        return bIOSVersionString;
    }

    @JsonProperty("BIOSVersionString")
    public void setBIOSVersionString(String bIOSVersionString) {
        this.bIOSVersionString = bIOSVersionString;
    }

    @JsonProperty("LastUpdateTime")
    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    @JsonProperty("LastUpdateTime")
    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @JsonProperty("PlatformGUID")
    public String getPlatformGUID() {
        return platformGUID;
    }

    @JsonProperty("PlatformGUID")
    public void setPlatformGUID(String platformGUID) {
        this.platformGUID = platformGUID;
    }

    @JsonProperty("SysMemTotalSize")
    public String getSysMemTotalSize() {
        return sysMemTotalSize;
    }

    @JsonProperty("SysMemTotalSize")
    public void setSysMemTotalSize(String sysMemTotalSize) {
        this.sysMemTotalSize = sysMemTotalSize;
    }

    @JsonProperty("Manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    @JsonProperty("Manufacturer")
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @JsonProperty("BIOSReleaseDate")
    public String getBIOSReleaseDate() {
        return bIOSReleaseDate;
    }

    @JsonProperty("BIOSReleaseDate")
    public void setBIOSReleaseDate(String bIOSReleaseDate) {
        this.bIOSReleaseDate = bIOSReleaseDate;
    }

    @JsonProperty("UUID")
    public String getUUID() {
        return uUID;
    }

    @JsonProperty("UUID")
    public void setUUID(String uUID) {
        this.uUID = uUID;
    }

    @JsonProperty("HostName")
    public String getHostName() {
        return hostName;
    }

    @JsonProperty("HostName")
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    @JsonProperty("EstimatedSystemAirflow")
    public String getEstimatedSystemAirflow() {
        return estimatedSystemAirflow;
    }

    @JsonProperty("EstimatedSystemAirflow")
    public void setEstimatedSystemAirflow(String estimatedSystemAirflow) {
        this.estimatedSystemAirflow = estimatedSystemAirflow;
    }

    @JsonProperty("LifecycleControllerVersion")
    public String getLifecycleControllerVersion() {
        return lifecycleControllerVersion;
    }

    @JsonProperty("LifecycleControllerVersion")
    public void setLifecycleControllerVersion(String lifecycleControllerVersion) {
        this.lifecycleControllerVersion = lifecycleControllerVersion;
    }

    @JsonProperty("PopulatedPCIeSlots")
    public String getPopulatedPCIeSlots() {
        return populatedPCIeSlots;
    }

    @JsonProperty("PopulatedPCIeSlots")
    public void setPopulatedPCIeSlots(String populatedPCIeSlots) {
        this.populatedPCIeSlots = populatedPCIeSlots;
    }

    @JsonProperty("PopulatedCPUSockets")
    public String getPopulatedCPUSockets() {
        return populatedCPUSockets;
    }

    @JsonProperty("PopulatedCPUSockets")
    public void setPopulatedCPUSockets(String populatedCPUSockets) {
        this.populatedCPUSockets = populatedCPUSockets;
    }

    @JsonProperty("IntrusionRollupStatus")
    public String getIntrusionRollupStatus() {
        return intrusionRollupStatus;
    }

    @JsonProperty("IntrusionRollupStatus")
    public void setIntrusionRollupStatus(String intrusionRollupStatus) {
        this.intrusionRollupStatus = intrusionRollupStatus;
    }

    @JsonProperty("StorageRollupStatus")
    public String getStorageRollupStatus() {
        return storageRollupStatus;
    }

    @JsonProperty("StorageRollupStatus")
    public void setStorageRollupStatus(String storageRollupStatus) {
        this.storageRollupStatus = storageRollupStatus;
    }

    @JsonProperty("BoardSerialNumber")
    public String getBoardSerialNumber() {
        return boardSerialNumber;
    }

    @JsonProperty("BoardSerialNumber")
    public void setBoardSerialNumber(String boardSerialNumber) {
        this.boardSerialNumber = boardSerialNumber;
    }

    @JsonProperty("FQDD")
    public String getFQDD() {
        return fQDD;
    }

    @JsonProperty("FQDD")
    public void setFQDD(String fQDD) {
        this.fQDD = fQDD;
    }

    @JsonProperty("LicensingRollupStatus")
    public String getLicensingRollupStatus() {
        return licensingRollupStatus;
    }

    @JsonProperty("LicensingRollupStatus")
    public void setLicensingRollupStatus(String licensingRollupStatus) {
        this.licensingRollupStatus = licensingRollupStatus;
    }

    @JsonProperty("PowerCap")
    public String getPowerCap() {
        return powerCap;
    }

    @JsonProperty("PowerCap")
    public void setPowerCap(String powerCap) {
        this.powerCap = powerCap;
    }

    @JsonProperty("PrimaryStatus")
    public String getPrimaryStatus() {
        return primaryStatus;
    }

    @JsonProperty("PrimaryStatus")
    public void setPrimaryStatus(String primaryStatus) {
        this.primaryStatus = primaryStatus;
    }

    @JsonProperty("AssetTag")
    public String getAssetTag() {
        return assetTag;
    }

    @JsonProperty("AssetTag")
    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    @JsonProperty("SysMemPrimaryStatus")
    public String getSysMemPrimaryStatus() {
        return sysMemPrimaryStatus;
    }

    @JsonProperty("SysMemPrimaryStatus")
    public void setSysMemPrimaryStatus(String sysMemPrimaryStatus) {
        this.sysMemPrimaryStatus = sysMemPrimaryStatus;
    }

    @JsonProperty("PopulatedDIMMSlots")
    public String getPopulatedDIMMSlots() {
        return populatedDIMMSlots;
    }

    @JsonProperty("PopulatedDIMMSlots")
    public void setPopulatedDIMMSlots(String populatedDIMMSlots) {
        this.populatedDIMMSlots = populatedDIMMSlots;
    }

    @JsonProperty("CurrentRollupStatus")
    public String getCurrentRollupStatus() {
        return currentRollupStatus;
    }

    @JsonProperty("CurrentRollupStatus")
    public void setCurrentRollupStatus(String currentRollupStatus) {
        this.currentRollupStatus = currentRollupStatus;
    }

    @JsonProperty("BaseBoardChassisSlot")
    public String getBaseBoardChassisSlot() {
        return baseBoardChassisSlot;
    }

    @JsonProperty("BaseBoardChassisSlot")
    public void setBaseBoardChassisSlot(String baseBoardChassisSlot) {
        this.baseBoardChassisSlot = baseBoardChassisSlot;
    }

    @JsonProperty("MemoryRollupStatus")
    public String getMemoryRollupStatus() {
        return memoryRollupStatus;
    }

    @JsonProperty("MemoryRollupStatus")
    public void setMemoryRollupStatus(String memoryRollupStatus) {
        this.memoryRollupStatus = memoryRollupStatus;
    }

    @JsonProperty("ChassisServiceTag")
    public String getChassisServiceTag() {
        return chassisServiceTag;
    }

    @JsonProperty("ChassisServiceTag")
    public void setChassisServiceTag(String chassisServiceTag) {
        this.chassisServiceTag = chassisServiceTag;
    }

    @JsonProperty("BatteryRollupStatus")
    public String getBatteryRollupStatus() {
        return batteryRollupStatus;
    }

    @JsonProperty("BatteryRollupStatus")
    public void setBatteryRollupStatus(String batteryRollupStatus) {
        this.batteryRollupStatus = batteryRollupStatus;
    }

    @JsonProperty("ExpressServiceCode")
    public String getExpressServiceCode() {
        return expressServiceCode;
    }

    @JsonProperty("ExpressServiceCode")
    public void setExpressServiceCode(String expressServiceCode) {
        this.expressServiceCode = expressServiceCode;
    }

    @JsonProperty("ServiceTag")
    public String getServiceTag() {
        return serviceTag;
    }

    @JsonProperty("ServiceTag")
    public void setServiceTag(String serviceTag) {
        this.serviceTag = serviceTag;
    }

    @JsonProperty("SystemGeneration")
    public String getSystemGeneration() {
        return systemGeneration;
    }

    @JsonProperty("SystemGeneration")
    public void setSystemGeneration(String systemGeneration) {
        this.systemGeneration = systemGeneration;
    }

    @JsonProperty("TempStatisticsRollupStatus")
    public String getTempStatisticsRollupStatus() {
        return tempStatisticsRollupStatus;
    }

    @JsonProperty("TempStatisticsRollupStatus")
    public void setTempStatisticsRollupStatus(String tempStatisticsRollupStatus) {
        this.tempStatisticsRollupStatus = tempStatisticsRollupStatus;
    }

    @JsonProperty("RollupStatus")
    public String getRollupStatus() {
        return rollupStatus;
    }

    @JsonProperty("RollupStatus")
    public void setRollupStatus(String rollupStatus) {
        this.rollupStatus = rollupStatus;
    }

    @JsonProperty("IDSDMRollupStatus")
    public String getIDSDMRollupStatus() {
        return iDSDMRollupStatus;
    }

    @JsonProperty("IDSDMRollupStatus")
    public void setIDSDMRollupStatus(String iDSDMRollupStatus) {
        this.iDSDMRollupStatus = iDSDMRollupStatus;
    }

    @JsonProperty("SysMemFailOverState")
    public String getSysMemFailOverState() {
        return sysMemFailOverState;
    }

    @JsonProperty("SysMemFailOverState")
    public void setSysMemFailOverState(String sysMemFailOverState) {
        this.sysMemFailOverState = sysMemFailOverState;
    }

    @JsonProperty("CMCIP")
    public String getCMCIP() {
        return cMCIP;
    }

    @JsonProperty("CMCIP")
    public void setCMCIP(String cMCIP) {
        this.cMCIP = cMCIP;
    }

    @JsonProperty("NodeID")
    public String getNodeID() {
        return nodeID;
    }

    @JsonProperty("NodeID")
    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    @JsonProperty("SysMemMaxCapacitySize")
    public String getSysMemMaxCapacitySize() {
        return sysMemMaxCapacitySize;
    }

    @JsonProperty("SysMemMaxCapacitySize")
    public void setSysMemMaxCapacitySize(String sysMemMaxCapacitySize) {
        this.sysMemMaxCapacitySize = sysMemMaxCapacitySize;
    }

    @JsonProperty("MaxPCIeSlots")
    public String getMaxPCIeSlots() {
        return maxPCIeSlots;
    }

    @JsonProperty("MaxPCIeSlots")
    public void setMaxPCIeSlots(String maxPCIeSlots) {
        this.maxPCIeSlots = maxPCIeSlots;
    }

    @JsonProperty("MaxDIMMSlots")
    public String getMaxDIMMSlots() {
        return maxDIMMSlots;
    }

    @JsonProperty("MaxDIMMSlots")
    public void setMaxDIMMSlots(String maxDIMMSlots) {
        this.maxDIMMSlots = maxDIMMSlots;
    }

    @JsonProperty("PowerState")
    public String getPowerState() {
        return powerState;
    }

    @JsonProperty("PowerState")
    public void setPowerState(String powerState) {
        this.powerState = powerState;
    }

    @JsonProperty("SDCardRollupStatus")
    public String getSDCardRollupStatus() {
        return sDCardRollupStatus;
    }

    @JsonProperty("SDCardRollupStatus")
    public void setSDCardRollupStatus(String sDCardRollupStatus) {
        this.sDCardRollupStatus = sDCardRollupStatus;
    }

    @JsonProperty("ServerAllocation")
    public String getServerAllocation() {
        return serverAllocation;
    }

    @JsonProperty("ServerAllocation")
    public void setServerAllocation(String serverAllocation) {
        this.serverAllocation = serverAllocation;
    }

    @JsonProperty("ChassisName")
    public String getChassisName() {
        return chassisName;
    }

    @JsonProperty("ChassisName")
    public void setChassisName(String chassisName) {
        this.chassisName = chassisName;
    }

    @JsonProperty("FanRollupStatus")
    public String getFanRollupStatus() {
        return fanRollupStatus;
    }

    @JsonProperty("FanRollupStatus")
    public void setFanRollupStatus(String fanRollupStatus) {
        this.fanRollupStatus = fanRollupStatus;
    }

    @JsonProperty("CPURollupStatus")
    public String getCPURollupStatus() {
        return cPURollupStatus;
    }

    @JsonProperty("CPURollupStatus")
    public void setCPURollupStatus(String cPURollupStatus) {
        this.cPURollupStatus = cPURollupStatus;
    }

    @JsonProperty("smbiosGUID")
    public String getSmbiosGUID() {
        return smbiosGUID;
    }

    @JsonProperty("smbiosGUID")
    public void setSmbiosGUID(String smbiosGUID) {
        this.smbiosGUID = smbiosGUID;
    }

    @JsonProperty("PowerCapEnabledState")
    public String getPowerCapEnabledState() {
        return powerCapEnabledState;
    }

    @JsonProperty("PowerCapEnabledState")
    public void setPowerCapEnabledState(String powerCapEnabledState) {
        this.powerCapEnabledState = powerCapEnabledState;
    }

    @JsonProperty("CPLDVersion")
    public String getCPLDVersion() {
        return cPLDVersion;
    }

    @JsonProperty("CPLDVersion")
    public void setCPLDVersion(String cPLDVersion) {
        this.cPLDVersion = cPLDVersion;
    }

    @JsonProperty("LastSystemInventoryTime")
    public String getLastSystemInventoryTime() {
        return lastSystemInventoryTime;
    }

    @JsonProperty("LastSystemInventoryTime")
    public void setLastSystemInventoryTime(String lastSystemInventoryTime) {
        this.lastSystemInventoryTime = lastSystemInventoryTime;
    }

    @JsonProperty("Model")
    public String getModel() {
        return model;
    }

    @JsonProperty("Model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("BladeGeometry")
    public String getBladeGeometry() {
        return bladeGeometry;
    }

    @JsonProperty("BladeGeometry")
    public void setBladeGeometry(String bladeGeometry) {
        this.bladeGeometry = bladeGeometry;
    }

    @JsonProperty("SystemRevision")
    public String getSystemRevision() {
        return systemRevision;
    }

    @JsonProperty("SystemRevision")
    public void setSystemRevision(String systemRevision) {
        this.systemRevision = systemRevision;
    }

    @JsonProperty("SysMemErrorMethodology")
    public String getSysMemErrorMethodology() {
        return sysMemErrorMethodology;
    }

    @JsonProperty("SysMemErrorMethodology")
    public void setSysMemErrorMethodology(String sysMemErrorMethodology) {
        this.sysMemErrorMethodology = sysMemErrorMethodology;
    }

    @JsonProperty("MaxCPUSockets")
    public String getMaxCPUSockets() {
        return maxCPUSockets;
    }

    @JsonProperty("MaxCPUSockets")
    public void setMaxCPUSockets(String maxCPUSockets) {
        this.maxCPUSockets = maxCPUSockets;
    }

    @JsonProperty("ChassisModel")
    public String getChassisModel() {
        return chassisModel;
    }

    @JsonProperty("ChassisModel")
    public void setChassisModel(String chassisModel) {
        this.chassisModel = chassisModel;
    }

    @JsonProperty("VoltRollupStatus")
    public String getVoltRollupStatus() {
        return voltRollupStatus;
    }

    @JsonProperty("VoltRollupStatus")
    public void setVoltRollupStatus(String voltRollupStatus) {
        this.voltRollupStatus = voltRollupStatus;
    }

}
