/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.manager;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "DeviceDescription",
    "LANEnabledState",
    "InstanceID",
    "DNSDomainName",
    "GUID",
    "SOLEnabledState",
    "PermanentMACAddress",
    "FQDD",
    "DNSRacName",
    "URLString",
    "FirmwareVersion",
    "LastUpdateTime",
    "IPMIVersion",
    "LastSystemInventoryTime",
    "Model",
    "ProductDescription"
})
public class DCIMIDRACCardView {

    @JsonProperty("DeviceDescription")
    private String deviceDescription;
    @JsonProperty("LANEnabledState")
    private String lANEnabledState;
    @JsonProperty("InstanceID")
    private String instanceID;
    @JsonProperty("DNSDomainName")
    private String dNSDomainName;
    @JsonProperty("GUID")
    private String gUID;
    @JsonProperty("SOLEnabledState")
    private String sOLEnabledState;
    @JsonProperty("PermanentMACAddress")
    private String permanentMACAddress;
    @JsonProperty("FQDD")
    private String fQDD;
    @JsonProperty("DNSRacName")
    private String dNSRacName;
    @JsonProperty("URLString")
    private String uRLString;
    @JsonProperty("FirmwareVersion")
    private String firmwareVersion;
    @JsonProperty("LastUpdateTime")
    private String lastUpdateTime;
    @JsonProperty("IPMIVersion")
    private String iPMIVersion;
    @JsonProperty("LastSystemInventoryTime")
    private String lastSystemInventoryTime;
    @JsonProperty("Model")
    private String model;
    @JsonProperty("ProductDescription")
    private String productDescription;

    @JsonProperty("DeviceDescription")
    public String getDeviceDescription() {
        return deviceDescription;
    }

    @JsonProperty("DeviceDescription")
    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    @JsonProperty("LANEnabledState")
    public String getLANEnabledState() {
        return lANEnabledState;
    }

    @JsonProperty("LANEnabledState")
    public void setLANEnabledState(String lANEnabledState) {
        this.lANEnabledState = lANEnabledState;
    }

    @JsonProperty("InstanceID")
    public String getInstanceID() {
        return instanceID;
    }

    @JsonProperty("InstanceID")
    public void setInstanceID(String instanceID) {
        this.instanceID = instanceID;
    }

    @JsonProperty("DNSDomainName")
    public String getDNSDomainName() {
        return dNSDomainName;
    }

    @JsonProperty("DNSDomainName")
    public void setDNSDomainName(String dNSDomainName) {
        this.dNSDomainName = dNSDomainName;
    }

    @JsonProperty("GUID")
    public String getGUID() {
        return gUID;
    }

    @JsonProperty("GUID")
    public void setGUID(String gUID) {
        this.gUID = gUID;
    }

    @JsonProperty("SOLEnabledState")
    public String getSOLEnabledState() {
        return sOLEnabledState;
    }

    @JsonProperty("SOLEnabledState")
    public void setSOLEnabledState(String sOLEnabledState) {
        this.sOLEnabledState = sOLEnabledState;
    }

    @JsonProperty("PermanentMACAddress")
    public String getPermanentMACAddress() {
        return permanentMACAddress;
    }

    @JsonProperty("PermanentMACAddress")
    public void setPermanentMACAddress(String permanentMACAddress) {
        this.permanentMACAddress = permanentMACAddress;
    }

    @JsonProperty("FQDD")
    public String getFQDD() {
        return fQDD;
    }

    @JsonProperty("FQDD")
    public void setFQDD(String fQDD) {
        this.fQDD = fQDD;
    }

    @JsonProperty("DNSRacName")
    public String getDNSRacName() {
        return dNSRacName;
    }

    @JsonProperty("DNSRacName")
    public void setDNSRacName(String dNSRacName) {
        this.dNSRacName = dNSRacName;
    }

    @JsonProperty("URLString")
    public String getURLString() {
        return uRLString;
    }

    @JsonProperty("URLString")
    public void setURLString(String uRLString) {
        this.uRLString = uRLString;
    }

    @JsonProperty("FirmwareVersion")
    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    @JsonProperty("FirmwareVersion")
    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    @JsonProperty("LastUpdateTime")
    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    @JsonProperty("LastUpdateTime")
    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @JsonProperty("IPMIVersion")
    public String getIPMIVersion() {
        return iPMIVersion;
    }

    @JsonProperty("IPMIVersion")
    public void setIPMIVersion(String iPMIVersion) {
        this.iPMIVersion = iPMIVersion;
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

    @JsonProperty("ProductDescription")
    public String getProductDescription() {
        return productDescription;
    }

    @JsonProperty("ProductDescription")
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

}
