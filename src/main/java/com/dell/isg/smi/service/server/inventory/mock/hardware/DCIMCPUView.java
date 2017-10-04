/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.hardware;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Cache2SRAMType",
    "Cache2WritePolicy",
    "DeviceDescription",
    "InstanceID",
    "Cache3ErrorMethodology",
    "LastUpdateTime",
    "VirtualizationTechnologyEnabled",
    "Manufacturer",
    "Cache1Type",
    "Cache3Size",
    "VirtualizationTechnologyCapable",
    "Cache3Level",
    "NumberOfProcessorCores",
    "FQDD",
    "Cache2Location",
    "PrimaryStatus",
    "NumberOfEnabledThreads",
    "Cache1Associativity",
    "HyperThreadingEnabled",
    "Cache2Associativity",
    "Cache2Size",
    "MaxClockSpeed",
    "CPUFamily",
    "Cache3Associativity",
    "TurboModeCapable",
    "Cache1Level",
    "Cache1SRAMType",
    "Cache1Size",
    "CurrentClockSpeed",
    "ExecuteDisabledCapable",
    "ExecuteDisabledEnabled",
    "Cache3SRAMType",
    "Cache2ErrorMethodology",
    "Cache3WritePolicy",
    "TurboModeEnabled",
    "Voltage",
    "Cache2PrimaryStatus",
    "Cache3PrimaryStatus",
    "Cache1PrimaryStatus",
    "Cache1Location",
    "Cache1WritePolicy",
    "Cache2Type",
    "NumberOfEnabledCores",
    "CPUStatus",
    "Cache2Level",
    "Cache3Location",
    "Characteristics",
    "Cache3Type",
    "LastSystemInventoryTime",
    "Model",
    "Cache1ErrorMethodology",
    "HyperThreadingCapable",
    "ExternalBusClockSpeed"
})
public class DCIMCPUView {

    @JsonProperty("Cache2SRAMType")
    private String cache2SRAMType;
    @JsonProperty("Cache2WritePolicy")
    private String cache2WritePolicy;
    @JsonProperty("DeviceDescription")
    private String deviceDescription;
    @JsonProperty("InstanceID")
    private String instanceID;
    @JsonProperty("Cache3ErrorMethodology")
    private String cache3ErrorMethodology;
    @JsonProperty("LastUpdateTime")
    private String lastUpdateTime;
    @JsonProperty("VirtualizationTechnologyEnabled")
    private String virtualizationTechnologyEnabled;
    @JsonProperty("Manufacturer")
    private String manufacturer;
    @JsonProperty("Cache1Type")
    private String cache1Type;
    @JsonProperty("Cache3Size")
    private String cache3Size;
    @JsonProperty("VirtualizationTechnologyCapable")
    private String virtualizationTechnologyCapable;
    @JsonProperty("Cache3Level")
    private String cache3Level;
    @JsonProperty("NumberOfProcessorCores")
    private String numberOfProcessorCores;
    @JsonProperty("FQDD")
    private String fQDD;
    @JsonProperty("Cache2Location")
    private String cache2Location;
    @JsonProperty("PrimaryStatus")
    private String primaryStatus;
    @JsonProperty("NumberOfEnabledThreads")
    private String numberOfEnabledThreads;
    @JsonProperty("Cache1Associativity")
    private String cache1Associativity;
    @JsonProperty("HyperThreadingEnabled")
    private String hyperThreadingEnabled;
    @JsonProperty("Cache2Associativity")
    private String cache2Associativity;
    @JsonProperty("Cache2Size")
    private String cache2Size;
    @JsonProperty("MaxClockSpeed")
    private String maxClockSpeed;
    @JsonProperty("CPUFamily")
    private String cPUFamily;
    @JsonProperty("Cache3Associativity")
    private String cache3Associativity;
    @JsonProperty("TurboModeCapable")
    private String turboModeCapable;
    @JsonProperty("Cache1Level")
    private String cache1Level;
    @JsonProperty("Cache1SRAMType")
    private String cache1SRAMType;
    @JsonProperty("Cache1Size")
    private String cache1Size;
    @JsonProperty("CurrentClockSpeed")
    private String currentClockSpeed;
    @JsonProperty("ExecuteDisabledCapable")
    private String executeDisabledCapable;
    @JsonProperty("ExecuteDisabledEnabled")
    private String executeDisabledEnabled;
    @JsonProperty("Cache3SRAMType")
    private String cache3SRAMType;
    @JsonProperty("Cache2ErrorMethodology")
    private String cache2ErrorMethodology;
    @JsonProperty("Cache3WritePolicy")
    private String cache3WritePolicy;
    @JsonProperty("TurboModeEnabled")
    private String turboModeEnabled;
    @JsonProperty("Voltage")
    private String voltage;
    @JsonProperty("Cache2PrimaryStatus")
    private String cache2PrimaryStatus;
    @JsonProperty("Cache3PrimaryStatus")
    private String cache3PrimaryStatus;
    @JsonProperty("Cache1PrimaryStatus")
    private String cache1PrimaryStatus;
    @JsonProperty("Cache1Location")
    private String cache1Location;
    @JsonProperty("Cache1WritePolicy")
    private String cache1WritePolicy;
    @JsonProperty("Cache2Type")
    private String cache2Type;
    @JsonProperty("NumberOfEnabledCores")
    private String numberOfEnabledCores;
    @JsonProperty("CPUStatus")
    private String cPUStatus;
    @JsonProperty("Cache2Level")
    private String cache2Level;
    @JsonProperty("Cache3Location")
    private String cache3Location;
    @JsonProperty("Characteristics")
    private String characteristics;
    @JsonProperty("Cache3Type")
    private String cache3Type;
    @JsonProperty("LastSystemInventoryTime")
    private String lastSystemInventoryTime;
    @JsonProperty("Model")
    private String model;
    @JsonProperty("Cache1ErrorMethodology")
    private String cache1ErrorMethodology;
    @JsonProperty("HyperThreadingCapable")
    private String hyperThreadingCapable;
    @JsonProperty("ExternalBusClockSpeed")
    private String externalBusClockSpeed;

    @JsonProperty("Cache2SRAMType")
    public String getCache2SRAMType() {
        return cache2SRAMType;
    }

    @JsonProperty("Cache2SRAMType")
    public void setCache2SRAMType(String cache2SRAMType) {
        this.cache2SRAMType = cache2SRAMType;
    }

    @JsonProperty("Cache2WritePolicy")
    public String getCache2WritePolicy() {
        return cache2WritePolicy;
    }

    @JsonProperty("Cache2WritePolicy")
    public void setCache2WritePolicy(String cache2WritePolicy) {
        this.cache2WritePolicy = cache2WritePolicy;
    }

    @JsonProperty("DeviceDescription")
    public String getDeviceDescription() {
        return deviceDescription;
    }

    @JsonProperty("DeviceDescription")
    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    @JsonProperty("InstanceID")
    public String getInstanceID() {
        return instanceID;
    }

    @JsonProperty("InstanceID")
    public void setInstanceID(String instanceID) {
        this.instanceID = instanceID;
    }

    @JsonProperty("Cache3ErrorMethodology")
    public String getCache3ErrorMethodology() {
        return cache3ErrorMethodology;
    }

    @JsonProperty("Cache3ErrorMethodology")
    public void setCache3ErrorMethodology(String cache3ErrorMethodology) {
        this.cache3ErrorMethodology = cache3ErrorMethodology;
    }

    @JsonProperty("LastUpdateTime")
    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    @JsonProperty("LastUpdateTime")
    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @JsonProperty("VirtualizationTechnologyEnabled")
    public String getVirtualizationTechnologyEnabled() {
        return virtualizationTechnologyEnabled;
    }

    @JsonProperty("VirtualizationTechnologyEnabled")
    public void setVirtualizationTechnologyEnabled(String virtualizationTechnologyEnabled) {
        this.virtualizationTechnologyEnabled = virtualizationTechnologyEnabled;
    }

    @JsonProperty("Manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    @JsonProperty("Manufacturer")
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @JsonProperty("Cache1Type")
    public String getCache1Type() {
        return cache1Type;
    }

    @JsonProperty("Cache1Type")
    public void setCache1Type(String cache1Type) {
        this.cache1Type = cache1Type;
    }

    @JsonProperty("Cache3Size")
    public String getCache3Size() {
        return cache3Size;
    }

    @JsonProperty("Cache3Size")
    public void setCache3Size(String cache3Size) {
        this.cache3Size = cache3Size;
    }

    @JsonProperty("VirtualizationTechnologyCapable")
    public String getVirtualizationTechnologyCapable() {
        return virtualizationTechnologyCapable;
    }

    @JsonProperty("VirtualizationTechnologyCapable")
    public void setVirtualizationTechnologyCapable(String virtualizationTechnologyCapable) {
        this.virtualizationTechnologyCapable = virtualizationTechnologyCapable;
    }

    @JsonProperty("Cache3Level")
    public String getCache3Level() {
        return cache3Level;
    }

    @JsonProperty("Cache3Level")
    public void setCache3Level(String cache3Level) {
        this.cache3Level = cache3Level;
    }

    @JsonProperty("NumberOfProcessorCores")
    public String getNumberOfProcessorCores() {
        return numberOfProcessorCores;
    }

    @JsonProperty("NumberOfProcessorCores")
    public void setNumberOfProcessorCores(String numberOfProcessorCores) {
        this.numberOfProcessorCores = numberOfProcessorCores;
    }

    @JsonProperty("FQDD")
    public String getFQDD() {
        return fQDD;
    }

    @JsonProperty("FQDD")
    public void setFQDD(String fQDD) {
        this.fQDD = fQDD;
    }

    @JsonProperty("Cache2Location")
    public String getCache2Location() {
        return cache2Location;
    }

    @JsonProperty("Cache2Location")
    public void setCache2Location(String cache2Location) {
        this.cache2Location = cache2Location;
    }

    @JsonProperty("PrimaryStatus")
    public String getPrimaryStatus() {
        return primaryStatus;
    }

    @JsonProperty("PrimaryStatus")
    public void setPrimaryStatus(String primaryStatus) {
        this.primaryStatus = primaryStatus;
    }

    @JsonProperty("NumberOfEnabledThreads")
    public String getNumberOfEnabledThreads() {
        return numberOfEnabledThreads;
    }

    @JsonProperty("NumberOfEnabledThreads")
    public void setNumberOfEnabledThreads(String numberOfEnabledThreads) {
        this.numberOfEnabledThreads = numberOfEnabledThreads;
    }

    @JsonProperty("Cache1Associativity")
    public String getCache1Associativity() {
        return cache1Associativity;
    }

    @JsonProperty("Cache1Associativity")
    public void setCache1Associativity(String cache1Associativity) {
        this.cache1Associativity = cache1Associativity;
    }

    @JsonProperty("HyperThreadingEnabled")
    public String getHyperThreadingEnabled() {
        return hyperThreadingEnabled;
    }

    @JsonProperty("HyperThreadingEnabled")
    public void setHyperThreadingEnabled(String hyperThreadingEnabled) {
        this.hyperThreadingEnabled = hyperThreadingEnabled;
    }

    @JsonProperty("Cache2Associativity")
    public String getCache2Associativity() {
        return cache2Associativity;
    }

    @JsonProperty("Cache2Associativity")
    public void setCache2Associativity(String cache2Associativity) {
        this.cache2Associativity = cache2Associativity;
    }

    @JsonProperty("Cache2Size")
    public String getCache2Size() {
        return cache2Size;
    }

    @JsonProperty("Cache2Size")
    public void setCache2Size(String cache2Size) {
        this.cache2Size = cache2Size;
    }

    @JsonProperty("MaxClockSpeed")
    public String getMaxClockSpeed() {
        return maxClockSpeed;
    }

    @JsonProperty("MaxClockSpeed")
    public void setMaxClockSpeed(String maxClockSpeed) {
        this.maxClockSpeed = maxClockSpeed;
    }

    @JsonProperty("CPUFamily")
    public String getCPUFamily() {
        return cPUFamily;
    }

    @JsonProperty("CPUFamily")
    public void setCPUFamily(String cPUFamily) {
        this.cPUFamily = cPUFamily;
    }

    @JsonProperty("Cache3Associativity")
    public String getCache3Associativity() {
        return cache3Associativity;
    }

    @JsonProperty("Cache3Associativity")
    public void setCache3Associativity(String cache3Associativity) {
        this.cache3Associativity = cache3Associativity;
    }

    @JsonProperty("TurboModeCapable")
    public String getTurboModeCapable() {
        return turboModeCapable;
    }

    @JsonProperty("TurboModeCapable")
    public void setTurboModeCapable(String turboModeCapable) {
        this.turboModeCapable = turboModeCapable;
    }

    @JsonProperty("Cache1Level")
    public String getCache1Level() {
        return cache1Level;
    }

    @JsonProperty("Cache1Level")
    public void setCache1Level(String cache1Level) {
        this.cache1Level = cache1Level;
    }

    @JsonProperty("Cache1SRAMType")
    public String getCache1SRAMType() {
        return cache1SRAMType;
    }

    @JsonProperty("Cache1SRAMType")
    public void setCache1SRAMType(String cache1SRAMType) {
        this.cache1SRAMType = cache1SRAMType;
    }

    @JsonProperty("Cache1Size")
    public String getCache1Size() {
        return cache1Size;
    }

    @JsonProperty("Cache1Size")
    public void setCache1Size(String cache1Size) {
        this.cache1Size = cache1Size;
    }

    @JsonProperty("CurrentClockSpeed")
    public String getCurrentClockSpeed() {
        return currentClockSpeed;
    }

    @JsonProperty("CurrentClockSpeed")
    public void setCurrentClockSpeed(String currentClockSpeed) {
        this.currentClockSpeed = currentClockSpeed;
    }

    @JsonProperty("ExecuteDisabledCapable")
    public String getExecuteDisabledCapable() {
        return executeDisabledCapable;
    }

    @JsonProperty("ExecuteDisabledCapable")
    public void setExecuteDisabledCapable(String executeDisabledCapable) {
        this.executeDisabledCapable = executeDisabledCapable;
    }

    @JsonProperty("ExecuteDisabledEnabled")
    public String getExecuteDisabledEnabled() {
        return executeDisabledEnabled;
    }

    @JsonProperty("ExecuteDisabledEnabled")
    public void setExecuteDisabledEnabled(String executeDisabledEnabled) {
        this.executeDisabledEnabled = executeDisabledEnabled;
    }

    @JsonProperty("Cache3SRAMType")
    public String getCache3SRAMType() {
        return cache3SRAMType;
    }

    @JsonProperty("Cache3SRAMType")
    public void setCache3SRAMType(String cache3SRAMType) {
        this.cache3SRAMType = cache3SRAMType;
    }

    @JsonProperty("Cache2ErrorMethodology")
    public String getCache2ErrorMethodology() {
        return cache2ErrorMethodology;
    }

    @JsonProperty("Cache2ErrorMethodology")
    public void setCache2ErrorMethodology(String cache2ErrorMethodology) {
        this.cache2ErrorMethodology = cache2ErrorMethodology;
    }

    @JsonProperty("Cache3WritePolicy")
    public String getCache3WritePolicy() {
        return cache3WritePolicy;
    }

    @JsonProperty("Cache3WritePolicy")
    public void setCache3WritePolicy(String cache3WritePolicy) {
        this.cache3WritePolicy = cache3WritePolicy;
    }

    @JsonProperty("TurboModeEnabled")
    public String getTurboModeEnabled() {
        return turboModeEnabled;
    }

    @JsonProperty("TurboModeEnabled")
    public void setTurboModeEnabled(String turboModeEnabled) {
        this.turboModeEnabled = turboModeEnabled;
    }

    @JsonProperty("Voltage")
    public String getVoltage() {
        return voltage;
    }

    @JsonProperty("Voltage")
    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    @JsonProperty("Cache2PrimaryStatus")
    public String getCache2PrimaryStatus() {
        return cache2PrimaryStatus;
    }

    @JsonProperty("Cache2PrimaryStatus")
    public void setCache2PrimaryStatus(String cache2PrimaryStatus) {
        this.cache2PrimaryStatus = cache2PrimaryStatus;
    }

    @JsonProperty("Cache3PrimaryStatus")
    public String getCache3PrimaryStatus() {
        return cache3PrimaryStatus;
    }

    @JsonProperty("Cache3PrimaryStatus")
    public void setCache3PrimaryStatus(String cache3PrimaryStatus) {
        this.cache3PrimaryStatus = cache3PrimaryStatus;
    }

    @JsonProperty("Cache1PrimaryStatus")
    public String getCache1PrimaryStatus() {
        return cache1PrimaryStatus;
    }

    @JsonProperty("Cache1PrimaryStatus")
    public void setCache1PrimaryStatus(String cache1PrimaryStatus) {
        this.cache1PrimaryStatus = cache1PrimaryStatus;
    }

    @JsonProperty("Cache1Location")
    public String getCache1Location() {
        return cache1Location;
    }

    @JsonProperty("Cache1Location")
    public void setCache1Location(String cache1Location) {
        this.cache1Location = cache1Location;
    }

    @JsonProperty("Cache1WritePolicy")
    public String getCache1WritePolicy() {
        return cache1WritePolicy;
    }

    @JsonProperty("Cache1WritePolicy")
    public void setCache1WritePolicy(String cache1WritePolicy) {
        this.cache1WritePolicy = cache1WritePolicy;
    }

    @JsonProperty("Cache2Type")
    public String getCache2Type() {
        return cache2Type;
    }

    @JsonProperty("Cache2Type")
    public void setCache2Type(String cache2Type) {
        this.cache2Type = cache2Type;
    }

    @JsonProperty("NumberOfEnabledCores")
    public String getNumberOfEnabledCores() {
        return numberOfEnabledCores;
    }

    @JsonProperty("NumberOfEnabledCores")
    public void setNumberOfEnabledCores(String numberOfEnabledCores) {
        this.numberOfEnabledCores = numberOfEnabledCores;
    }

    @JsonProperty("CPUStatus")
    public String getCPUStatus() {
        return cPUStatus;
    }

    @JsonProperty("CPUStatus")
    public void setCPUStatus(String cPUStatus) {
        this.cPUStatus = cPUStatus;
    }

    @JsonProperty("Cache2Level")
    public String getCache2Level() {
        return cache2Level;
    }

    @JsonProperty("Cache2Level")
    public void setCache2Level(String cache2Level) {
        this.cache2Level = cache2Level;
    }

    @JsonProperty("Cache3Location")
    public String getCache3Location() {
        return cache3Location;
    }

    @JsonProperty("Cache3Location")
    public void setCache3Location(String cache3Location) {
        this.cache3Location = cache3Location;
    }

    @JsonProperty("Characteristics")
    public String getCharacteristics() {
        return characteristics;
    }

    @JsonProperty("Characteristics")
    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    @JsonProperty("Cache3Type")
    public String getCache3Type() {
        return cache3Type;
    }

    @JsonProperty("Cache3Type")
    public void setCache3Type(String cache3Type) {
        this.cache3Type = cache3Type;
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

    @JsonProperty("Cache1ErrorMethodology")
    public String getCache1ErrorMethodology() {
        return cache1ErrorMethodology;
    }

    @JsonProperty("Cache1ErrorMethodology")
    public void setCache1ErrorMethodology(String cache1ErrorMethodology) {
        this.cache1ErrorMethodology = cache1ErrorMethodology;
    }

    @JsonProperty("HyperThreadingCapable")
    public String getHyperThreadingCapable() {
        return hyperThreadingCapable;
    }

    @JsonProperty("HyperThreadingCapable")
    public void setHyperThreadingCapable(String hyperThreadingCapable) {
        this.hyperThreadingCapable = hyperThreadingCapable;
    }

    @JsonProperty("ExternalBusClockSpeed")
    public String getExternalBusClockSpeed() {
        return externalBusClockSpeed;
    }

    @JsonProperty("ExternalBusClockSpeed")
    public void setExternalBusClockSpeed(String externalBusClockSpeed) {
        this.externalBusClockSpeed = externalBusClockSpeed;
    }

}
