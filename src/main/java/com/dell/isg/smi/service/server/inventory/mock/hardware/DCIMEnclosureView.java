/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.hardware;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Connector",
    "DeviceDescription",
    "ProductName",
    "InstanceID",
    "ServiceTag",
    "SlotCount",
    "FQDD",
    "TempProbeCount",
    "RollupStatus",
    "PrimaryStatus",
    "PSUCount",
    "EMMCount",
    "AssetTag",
    "FanCount",
    "LastUpdateTime",
    "Version",
    "State",
    "LastSystemInventoryTime",
    "WiredOrder"
})
public class DCIMEnclosureView {

    @JsonProperty("Connector")
    private String connector;
    @JsonProperty("DeviceDescription")
    private String deviceDescription;
    @JsonProperty("ProductName")
    private String productName;
    @JsonProperty("InstanceID")
    private String instanceID;
    @JsonProperty("ServiceTag")
    private String serviceTag;
    @JsonProperty("SlotCount")
    private String slotCount;
    @JsonProperty("FQDD")
    private String fQDD;
    @JsonProperty("TempProbeCount")
    private String tempProbeCount;
    @JsonProperty("RollupStatus")
    private String rollupStatus;
    @JsonProperty("PrimaryStatus")
    private String primaryStatus;
    @JsonProperty("PSUCount")
    private String pSUCount;
    @JsonProperty("EMMCount")
    private String eMMCount;
    @JsonProperty("AssetTag")
    private String assetTag;
    @JsonProperty("FanCount")
    private String fanCount;
    @JsonProperty("LastUpdateTime")
    private String lastUpdateTime;
    @JsonProperty("Version")
    private String version;
    @JsonProperty("State")
    private String state;
    @JsonProperty("LastSystemInventoryTime")
    private String lastSystemInventoryTime;
    @JsonProperty("WiredOrder")
    private String wiredOrder;

    @JsonProperty("Connector")
    public String getConnector() {
        return connector;
    }

    @JsonProperty("Connector")
    public void setConnector(String connector) {
        this.connector = connector;
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

    @JsonProperty("InstanceID")
    public String getInstanceID() {
        return instanceID;
    }

    @JsonProperty("InstanceID")
    public void setInstanceID(String instanceID) {
        this.instanceID = instanceID;
    }

    @JsonProperty("ServiceTag")
    public String getServiceTag() {
        return serviceTag;
    }

    @JsonProperty("ServiceTag")
    public void setServiceTag(String serviceTag) {
        this.serviceTag = serviceTag;
    }

    @JsonProperty("SlotCount")
    public String getSlotCount() {
        return slotCount;
    }

    @JsonProperty("SlotCount")
    public void setSlotCount(String slotCount) {
        this.slotCount = slotCount;
    }

    @JsonProperty("FQDD")
    public String getFQDD() {
        return fQDD;
    }

    @JsonProperty("FQDD")
    public void setFQDD(String fQDD) {
        this.fQDD = fQDD;
    }

    @JsonProperty("TempProbeCount")
    public String getTempProbeCount() {
        return tempProbeCount;
    }

    @JsonProperty("TempProbeCount")
    public void setTempProbeCount(String tempProbeCount) {
        this.tempProbeCount = tempProbeCount;
    }

    @JsonProperty("RollupStatus")
    public String getRollupStatus() {
        return rollupStatus;
    }

    @JsonProperty("RollupStatus")
    public void setRollupStatus(String rollupStatus) {
        this.rollupStatus = rollupStatus;
    }

    @JsonProperty("PrimaryStatus")
    public String getPrimaryStatus() {
        return primaryStatus;
    }

    @JsonProperty("PrimaryStatus")
    public void setPrimaryStatus(String primaryStatus) {
        this.primaryStatus = primaryStatus;
    }

    @JsonProperty("PSUCount")
    public String getPSUCount() {
        return pSUCount;
    }

    @JsonProperty("PSUCount")
    public void setPSUCount(String pSUCount) {
        this.pSUCount = pSUCount;
    }

    @JsonProperty("EMMCount")
    public String getEMMCount() {
        return eMMCount;
    }

    @JsonProperty("EMMCount")
    public void setEMMCount(String eMMCount) {
        this.eMMCount = eMMCount;
    }

    @JsonProperty("AssetTag")
    public String getAssetTag() {
        return assetTag;
    }

    @JsonProperty("AssetTag")
    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    @JsonProperty("FanCount")
    public String getFanCount() {
        return fanCount;
    }

    @JsonProperty("FanCount")
    public void setFanCount(String fanCount) {
        this.fanCount = fanCount;
    }

    @JsonProperty("LastUpdateTime")
    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    @JsonProperty("LastUpdateTime")
    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @JsonProperty("Version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("Version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("State")
    public String getState() {
        return state;
    }

    @JsonProperty("State")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("LastSystemInventoryTime")
    public String getLastSystemInventoryTime() {
        return lastSystemInventoryTime;
    }

    @JsonProperty("LastSystemInventoryTime")
    public void setLastSystemInventoryTime(String lastSystemInventoryTime) {
        this.lastSystemInventoryTime = lastSystemInventoryTime;
    }

    @JsonProperty("WiredOrder")
    public String getWiredOrder() {
        return wiredOrder;
    }

    @JsonProperty("WiredOrder")
    public void setWiredOrder(String wiredOrder) {
        this.wiredOrder = wiredOrder;
    }

}
