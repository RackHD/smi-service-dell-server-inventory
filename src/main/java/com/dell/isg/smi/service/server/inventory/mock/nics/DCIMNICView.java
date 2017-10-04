/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.nics;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "DeviceDescription",
    "NicMode",
    "ProductName",
    "InstanceID",
    "MaxBandwidth",
    "PermanentMACAddress",
    "AutoNegotiation",
    "MinBandwidth",
    "FunctionNumber",
    "VirtWWPN",
    "EFIVersion",
    "LastUpdateTime",
    "MediaType",
    "PCISubDeviceID",
    "PermanentiSCSIMACAddress",
    "DataBusWidth",
    "Protocol",
    "FCoEWWNN",
    "PCIVendorID",
    "DeviceNumber",
    "PCISubVendorID",
    "VendorName",
    "PermanentFCOEMACAddress",
    "iScsiOffloadMode",
    "CurrentMACAddress",
    "FamilyVersion",
    "FQDD",
    "PCIDeviceID",
    "TransmitFlowControl",
    "SlotType",
    "WWN",
    "FCoEOffloadMode",
    "BusNumber",
    "SlotLength",
    "LinkDuplex",
    "ReceiveFlowControl",
    "WWPN",
    "LastSystemInventoryTime",
    "VirtWWN",
    "LinkSpeed",
    "ControllerBIOSVersion"
})
public class DCIMNICView {

    @JsonProperty("DeviceDescription")
    private String deviceDescription;
    @JsonProperty("NicMode")
    private String nicMode;
    @JsonProperty("ProductName")
    private String productName;
    @JsonProperty("InstanceID")
    private String instanceID;
    @JsonProperty("MaxBandwidth")
    private String maxBandwidth;
    @JsonProperty("PermanentMACAddress")
    private String permanentMACAddress;
    @JsonProperty("AutoNegotiation")
    private String autoNegotiation;
    @JsonProperty("MinBandwidth")
    private String minBandwidth;
    @JsonProperty("FunctionNumber")
    private String functionNumber;
    @JsonProperty("VirtWWPN")
    private String virtWWPN;
    @JsonProperty("EFIVersion")
    private String eFIVersion;
    @JsonProperty("LastUpdateTime")
    private String lastUpdateTime;
    @JsonProperty("MediaType")
    private String mediaType;
    @JsonProperty("PCISubDeviceID")
    private String pCISubDeviceID;
    @JsonProperty("PermanentiSCSIMACAddress")
    private String permanentiSCSIMACAddress;
    @JsonProperty("DataBusWidth")
    private String dataBusWidth;
    @JsonProperty("Protocol")
    private String protocol;
    @JsonProperty("FCoEWWNN")
    private String fCoEWWNN;
    @JsonProperty("PCIVendorID")
    private String pCIVendorID;
    @JsonProperty("DeviceNumber")
    private String deviceNumber;
    @JsonProperty("PCISubVendorID")
    private String pCISubVendorID;
    @JsonProperty("VendorName")
    private String vendorName;
    @JsonProperty("PermanentFCOEMACAddress")
    private String permanentFCOEMACAddress;
    @JsonProperty("iScsiOffloadMode")
    private String iScsiOffloadMode;
    @JsonProperty("CurrentMACAddress")
    private String currentMACAddress;
    @JsonProperty("FamilyVersion")
    private String familyVersion;
    @JsonProperty("FQDD")
    private String fQDD;
    @JsonProperty("PCIDeviceID")
    private String pCIDeviceID;
    @JsonProperty("TransmitFlowControl")
    private String transmitFlowControl;
    @JsonProperty("SlotType")
    private String slotType;
    @JsonProperty("WWN")
    private String wWN;
    @JsonProperty("FCoEOffloadMode")
    private String fCoEOffloadMode;
    @JsonProperty("BusNumber")
    private String busNumber;
    @JsonProperty("SlotLength")
    private String slotLength;
    @JsonProperty("LinkDuplex")
    private String linkDuplex;
    @JsonProperty("ReceiveFlowControl")
    private String receiveFlowControl;
    @JsonProperty("WWPN")
    private String wWPN;
    @JsonProperty("LastSystemInventoryTime")
    private String lastSystemInventoryTime;
    @JsonProperty("VirtWWN")
    private String virtWWN;
    @JsonProperty("LinkSpeed")
    private String linkSpeed;
    @JsonProperty("ControllerBIOSVersion")
    private String controllerBIOSVersion;

    @JsonProperty("DeviceDescription")
    public String getDeviceDescription() {
        return deviceDescription;
    }

    @JsonProperty("DeviceDescription")
    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    @JsonProperty("NicMode")
    public String getNicMode() {
        return nicMode;
    }

    @JsonProperty("NicMode")
    public void setNicMode(String nicMode) {
        this.nicMode = nicMode;
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

    @JsonProperty("MaxBandwidth")
    public String getMaxBandwidth() {
        return maxBandwidth;
    }

    @JsonProperty("MaxBandwidth")
    public void setMaxBandwidth(String maxBandwidth) {
        this.maxBandwidth = maxBandwidth;
    }

    @JsonProperty("PermanentMACAddress")
    public String getPermanentMACAddress() {
        return permanentMACAddress;
    }

    @JsonProperty("PermanentMACAddress")
    public void setPermanentMACAddress(String permanentMACAddress) {
        this.permanentMACAddress = permanentMACAddress;
    }

    @JsonProperty("AutoNegotiation")
    public String getAutoNegotiation() {
        return autoNegotiation;
    }

    @JsonProperty("AutoNegotiation")
    public void setAutoNegotiation(String autoNegotiation) {
        this.autoNegotiation = autoNegotiation;
    }

    @JsonProperty("MinBandwidth")
    public String getMinBandwidth() {
        return minBandwidth;
    }

    @JsonProperty("MinBandwidth")
    public void setMinBandwidth(String minBandwidth) {
        this.minBandwidth = minBandwidth;
    }

    @JsonProperty("FunctionNumber")
    public String getFunctionNumber() {
        return functionNumber;
    }

    @JsonProperty("FunctionNumber")
    public void setFunctionNumber(String functionNumber) {
        this.functionNumber = functionNumber;
    }

    @JsonProperty("VirtWWPN")
    public String getVirtWWPN() {
        return virtWWPN;
    }

    @JsonProperty("VirtWWPN")
    public void setVirtWWPN(String virtWWPN) {
        this.virtWWPN = virtWWPN;
    }

    @JsonProperty("EFIVersion")
    public String getEFIVersion() {
        return eFIVersion;
    }

    @JsonProperty("EFIVersion")
    public void setEFIVersion(String eFIVersion) {
        this.eFIVersion = eFIVersion;
    }

    @JsonProperty("LastUpdateTime")
    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    @JsonProperty("LastUpdateTime")
    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @JsonProperty("MediaType")
    public String getMediaType() {
        return mediaType;
    }

    @JsonProperty("MediaType")
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    @JsonProperty("PCISubDeviceID")
    public String getPCISubDeviceID() {
        return pCISubDeviceID;
    }

    @JsonProperty("PCISubDeviceID")
    public void setPCISubDeviceID(String pCISubDeviceID) {
        this.pCISubDeviceID = pCISubDeviceID;
    }

    @JsonProperty("PermanentiSCSIMACAddress")
    public String getPermanentiSCSIMACAddress() {
        return permanentiSCSIMACAddress;
    }

    @JsonProperty("PermanentiSCSIMACAddress")
    public void setPermanentiSCSIMACAddress(String permanentiSCSIMACAddress) {
        this.permanentiSCSIMACAddress = permanentiSCSIMACAddress;
    }

    @JsonProperty("DataBusWidth")
    public String getDataBusWidth() {
        return dataBusWidth;
    }

    @JsonProperty("DataBusWidth")
    public void setDataBusWidth(String dataBusWidth) {
        this.dataBusWidth = dataBusWidth;
    }

    @JsonProperty("Protocol")
    public String getProtocol() {
        return protocol;
    }

    @JsonProperty("Protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @JsonProperty("FCoEWWNN")
    public String getFCoEWWNN() {
        return fCoEWWNN;
    }

    @JsonProperty("FCoEWWNN")
    public void setFCoEWWNN(String fCoEWWNN) {
        this.fCoEWWNN = fCoEWWNN;
    }

    @JsonProperty("PCIVendorID")
    public String getPCIVendorID() {
        return pCIVendorID;
    }

    @JsonProperty("PCIVendorID")
    public void setPCIVendorID(String pCIVendorID) {
        this.pCIVendorID = pCIVendorID;
    }

    @JsonProperty("DeviceNumber")
    public String getDeviceNumber() {
        return deviceNumber;
    }

    @JsonProperty("DeviceNumber")
    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    @JsonProperty("PCISubVendorID")
    public String getPCISubVendorID() {
        return pCISubVendorID;
    }

    @JsonProperty("PCISubVendorID")
    public void setPCISubVendorID(String pCISubVendorID) {
        this.pCISubVendorID = pCISubVendorID;
    }

    @JsonProperty("VendorName")
    public String getVendorName() {
        return vendorName;
    }

    @JsonProperty("VendorName")
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @JsonProperty("PermanentFCOEMACAddress")
    public String getPermanentFCOEMACAddress() {
        return permanentFCOEMACAddress;
    }

    @JsonProperty("PermanentFCOEMACAddress")
    public void setPermanentFCOEMACAddress(String permanentFCOEMACAddress) {
        this.permanentFCOEMACAddress = permanentFCOEMACAddress;
    }

    @JsonProperty("iScsiOffloadMode")
    public String getIScsiOffloadMode() {
        return iScsiOffloadMode;
    }

    @JsonProperty("iScsiOffloadMode")
    public void setIScsiOffloadMode(String iScsiOffloadMode) {
        this.iScsiOffloadMode = iScsiOffloadMode;
    }

    @JsonProperty("CurrentMACAddress")
    public String getCurrentMACAddress() {
        return currentMACAddress;
    }

    @JsonProperty("CurrentMACAddress")
    public void setCurrentMACAddress(String currentMACAddress) {
        this.currentMACAddress = currentMACAddress;
    }

    @JsonProperty("FamilyVersion")
    public String getFamilyVersion() {
        return familyVersion;
    }

    @JsonProperty("FamilyVersion")
    public void setFamilyVersion(String familyVersion) {
        this.familyVersion = familyVersion;
    }

    @JsonProperty("FQDD")
    public String getFQDD() {
        return fQDD;
    }

    @JsonProperty("FQDD")
    public void setFQDD(String fQDD) {
        this.fQDD = fQDD;
    }

    @JsonProperty("PCIDeviceID")
    public String getPCIDeviceID() {
        return pCIDeviceID;
    }

    @JsonProperty("PCIDeviceID")
    public void setPCIDeviceID(String pCIDeviceID) {
        this.pCIDeviceID = pCIDeviceID;
    }

    @JsonProperty("TransmitFlowControl")
    public String getTransmitFlowControl() {
        return transmitFlowControl;
    }

    @JsonProperty("TransmitFlowControl")
    public void setTransmitFlowControl(String transmitFlowControl) {
        this.transmitFlowControl = transmitFlowControl;
    }

    @JsonProperty("SlotType")
    public String getSlotType() {
        return slotType;
    }

    @JsonProperty("SlotType")
    public void setSlotType(String slotType) {
        this.slotType = slotType;
    }

    @JsonProperty("WWN")
    public String getWWN() {
        return wWN;
    }

    @JsonProperty("WWN")
    public void setWWN(String wWN) {
        this.wWN = wWN;
    }

    @JsonProperty("FCoEOffloadMode")
    public String getFCoEOffloadMode() {
        return fCoEOffloadMode;
    }

    @JsonProperty("FCoEOffloadMode")
    public void setFCoEOffloadMode(String fCoEOffloadMode) {
        this.fCoEOffloadMode = fCoEOffloadMode;
    }

    @JsonProperty("BusNumber")
    public String getBusNumber() {
        return busNumber;
    }

    @JsonProperty("BusNumber")
    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    @JsonProperty("SlotLength")
    public String getSlotLength() {
        return slotLength;
    }

    @JsonProperty("SlotLength")
    public void setSlotLength(String slotLength) {
        this.slotLength = slotLength;
    }

    @JsonProperty("LinkDuplex")
    public String getLinkDuplex() {
        return linkDuplex;
    }

    @JsonProperty("LinkDuplex")
    public void setLinkDuplex(String linkDuplex) {
        this.linkDuplex = linkDuplex;
    }

    @JsonProperty("ReceiveFlowControl")
    public String getReceiveFlowControl() {
        return receiveFlowControl;
    }

    @JsonProperty("ReceiveFlowControl")
    public void setReceiveFlowControl(String receiveFlowControl) {
        this.receiveFlowControl = receiveFlowControl;
    }

    @JsonProperty("WWPN")
    public String getWWPN() {
        return wWPN;
    }

    @JsonProperty("WWPN")
    public void setWWPN(String wWPN) {
        this.wWPN = wWPN;
    }

    @JsonProperty("LastSystemInventoryTime")
    public String getLastSystemInventoryTime() {
        return lastSystemInventoryTime;
    }

    @JsonProperty("LastSystemInventoryTime")
    public void setLastSystemInventoryTime(String lastSystemInventoryTime) {
        this.lastSystemInventoryTime = lastSystemInventoryTime;
    }

    @JsonProperty("VirtWWN")
    public String getVirtWWN() {
        return virtWWN;
    }

    @JsonProperty("VirtWWN")
    public void setVirtWWN(String virtWWN) {
        this.virtWWN = virtWWN;
    }

    @JsonProperty("LinkSpeed")
    public String getLinkSpeed() {
        return linkSpeed;
    }

    @JsonProperty("LinkSpeed")
    public void setLinkSpeed(String linkSpeed) {
        this.linkSpeed = linkSpeed;
    }

    @JsonProperty("ControllerBIOSVersion")
    public String getControllerBIOSVersion() {
        return controllerBIOSVersion;
    }

    @JsonProperty("ControllerBIOSVersion")
    public void setControllerBIOSVersion(String controllerBIOSVersion) {
        this.controllerBIOSVersion = controllerBIOSVersion;
    }

}
