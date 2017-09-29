/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.software;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "MajorVersion",
    "Status",
    "Classifications",
    "ComponentType",
    "VersionString",
    "InstanceID",
    "DeviceID",
    "VendorID",
    "IsEntity",
    "MinorVersion",
    "RevisionString",
    "FQDD",
    "IdentityInfoValue",
    "InstallationDate",
    "RevisionNumber",
    "SubVendorID",
    "SubDeviceID",
    "BuildNumber",
    "ElementName",
    "Updateable",
    "IdentityInfoType",
    "impactsTPMmeasurements",
    "ComponentID"
})
public class DCIMSoftwareIdentity {

    @JsonProperty("MajorVersion")
    private String majorVersion;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Classifications")
    private String classifications;
    @JsonProperty("ComponentType")
    private String componentType;
    @JsonProperty("VersionString")
    private String versionString;
    @JsonProperty("InstanceID")
    private String instanceID;
    @JsonProperty("DeviceID")
    private String deviceID;
    @JsonProperty("VendorID")
    private String vendorID;
    @JsonProperty("IsEntity")
    private String isEntity;
    @JsonProperty("MinorVersion")
    private String minorVersion;
    @JsonProperty("RevisionString")
    private String revisionString;
    @JsonProperty("FQDD")
    private String fQDD;
    @JsonProperty("IdentityInfoValue")
    private String identityInfoValue;
    @JsonProperty("InstallationDate")
    private String installationDate;
    @JsonProperty("RevisionNumber")
    private String revisionNumber;
    @JsonProperty("SubVendorID")
    private String subVendorID;
    @JsonProperty("SubDeviceID")
    private String subDeviceID;
    @JsonProperty("BuildNumber")
    private String buildNumber;
    @JsonProperty("ElementName")
    private String elementName;
    @JsonProperty("Updateable")
    private String updateable;
    @JsonProperty("IdentityInfoType")
    private String identityInfoType;
    @JsonProperty("impactsTPMmeasurements")
    private String impactsTPMmeasurements;
    @JsonProperty("ComponentID")
    private String componentID;

    @JsonProperty("MajorVersion")
    public String getMajorVersion() {
        return majorVersion;
    }

    @JsonProperty("MajorVersion")
    public void setMajorVersion(String majorVersion) {
        this.majorVersion = majorVersion;
    }

    @JsonProperty("Status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("Classifications")
    public String getClassifications() {
        return classifications;
    }

    @JsonProperty("Classifications")
    public void setClassifications(String classifications) {
        this.classifications = classifications;
    }

    @JsonProperty("ComponentType")
    public String getComponentType() {
        return componentType;
    }

    @JsonProperty("ComponentType")
    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    @JsonProperty("VersionString")
    public String getVersionString() {
        return versionString;
    }

    @JsonProperty("VersionString")
    public void setVersionString(String versionString) {
        this.versionString = versionString;
    }

    @JsonProperty("InstanceID")
    public String getInstanceID() {
        return instanceID;
    }

    @JsonProperty("InstanceID")
    public void setInstanceID(String instanceID) {
        this.instanceID = instanceID;
    }

    @JsonProperty("DeviceID")
    public String getDeviceID() {
        return deviceID;
    }

    @JsonProperty("DeviceID")
    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    @JsonProperty("VendorID")
    public String getVendorID() {
        return vendorID;
    }

    @JsonProperty("VendorID")
    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }

    @JsonProperty("IsEntity")
    public String getIsEntity() {
        return isEntity;
    }

    @JsonProperty("IsEntity")
    public void setIsEntity(String isEntity) {
        this.isEntity = isEntity;
    }

    @JsonProperty("MinorVersion")
    public String getMinorVersion() {
        return minorVersion;
    }

    @JsonProperty("MinorVersion")
    public void setMinorVersion(String minorVersion) {
        this.minorVersion = minorVersion;
    }

    @JsonProperty("RevisionString")
    public String getRevisionString() {
        return revisionString;
    }

    @JsonProperty("RevisionString")
    public void setRevisionString(String revisionString) {
        this.revisionString = revisionString;
    }

    @JsonProperty("FQDD")
    public String getFQDD() {
        return fQDD;
    }

    @JsonProperty("FQDD")
    public void setFQDD(String fQDD) {
        this.fQDD = fQDD;
    }

    @JsonProperty("IdentityInfoValue")
    public String getIdentityInfoValue() {
        return identityInfoValue;
    }

    @JsonProperty("IdentityInfoValue")
    public void setIdentityInfoValue(String identityInfoValue) {
        this.identityInfoValue = identityInfoValue;
    }

    @JsonProperty("InstallationDate")
    public String getInstallationDate() {
        return installationDate;
    }

    @JsonProperty("InstallationDate")
    public void setInstallationDate(String installationDate) {
        this.installationDate = installationDate;
    }

    @JsonProperty("RevisionNumber")
    public String getRevisionNumber() {
        return revisionNumber;
    }

    @JsonProperty("RevisionNumber")
    public void setRevisionNumber(String revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    @JsonProperty("SubVendorID")
    public String getSubVendorID() {
        return subVendorID;
    }

    @JsonProperty("SubVendorID")
    public void setSubVendorID(String subVendorID) {
        this.subVendorID = subVendorID;
    }

    @JsonProperty("SubDeviceID")
    public String getSubDeviceID() {
        return subDeviceID;
    }

    @JsonProperty("SubDeviceID")
    public void setSubDeviceID(String subDeviceID) {
        this.subDeviceID = subDeviceID;
    }

    @JsonProperty("BuildNumber")
    public String getBuildNumber() {
        return buildNumber;
    }

    @JsonProperty("BuildNumber")
    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

    @JsonProperty("ElementName")
    public String getElementName() {
        return elementName;
    }

    @JsonProperty("ElementName")
    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    @JsonProperty("Updateable")
    public String getUpdateable() {
        return updateable;
    }

    @JsonProperty("Updateable")
    public void setUpdateable(String updateable) {
        this.updateable = updateable;
    }

    @JsonProperty("IdentityInfoType")
    public String getIdentityInfoType() {
        return identityInfoType;
    }

    @JsonProperty("IdentityInfoType")
    public void setIdentityInfoType(String identityInfoType) {
        this.identityInfoType = identityInfoType;
    }

    @JsonProperty("impactsTPMmeasurements")
    public String getImpactsTPMmeasurements() {
        return impactsTPMmeasurements;
    }

    @JsonProperty("impactsTPMmeasurements")
    public void setImpactsTPMmeasurements(String impactsTPMmeasurements) {
        this.impactsTPMmeasurements = impactsTPMmeasurements;
    }

    @JsonProperty("ComponentID")
    public String getComponentID() {
        return componentID;
    }

    @JsonProperty("ComponentID")
    public void setComponentID(String componentID) {
        this.componentID = componentID;
    }

}
