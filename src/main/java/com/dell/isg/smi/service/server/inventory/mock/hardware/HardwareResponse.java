/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.hardware;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "DCIM_SystemView",
    "DCIM_Memoryview",
    "DCIM_Powersupplyview",
    "DCIM_CPUView",
    "DCIM_VFlashView",
    "DCIM_FanView",
    "DCIM_EnclosureView",
    "DCIM_VirtualDiskView",
    "DCIM_Sensor",
    "DCIM_NumericSensor",
    "DCIM_SystemString",
    "DCIM_ControllerView",
    "DCIM_ControllerBatteryView",
    "DCIM_RAIDEnumeration",
    "DCIM_RAIDInteger"
})
public class HardwareResponse {

    @JsonProperty("DCIM_SystemView")
    private DCIMSystemView dCIMSystemView;
    @JsonProperty("DCIM_Memoryview")
    private List<DCIMMemoryview> dCIMMemoryview = null;
    @JsonProperty("DCIM_Powersupplyview")
    private List<DCIMPowersupplyview> dCIMPowersupplyview = null;
    @JsonProperty("DCIM_CPUView")
    private List<DCIMCPUView> dCIMCPUView = null;
    @JsonProperty("DCIM_VFlashView")
    private DCIMVFlashView dCIMVFlashView;
    @JsonProperty("DCIM_FanView")
    private List<DCIMFanView> dCIMFanView = null;
    @JsonProperty("DCIM_EnclosureView")
    private DCIMEnclosureView dCIMEnclosureView;
    @JsonProperty("DCIM_VirtualDiskView")
    private String dCIMVirtualDiskView;
    @JsonProperty("DCIM_Sensor")
    private List<DCIMSensor> dCIMSensor = null;
    @JsonProperty("DCIM_NumericSensor")
    private List<DCIMNumericSensor> dCIMNumericSensor = null;
    @JsonProperty("DCIM_SystemString")
    private List<DCIMSystemString> dCIMSystemString = null;
    @JsonProperty("DCIM_ControllerView")
    private List<DCIMControllerView> dCIMControllerView = null;
    @JsonProperty("DCIM_ControllerBatteryView")
    private String dCIMControllerBatteryView;
    @JsonProperty("DCIM_RAIDEnumeration")
    private List<DCIMRAIDEnumeration> dCIMRAIDEnumeration = null;
    @JsonProperty("DCIM_RAIDInteger")
    private List<DCIMRAIDInteger> dCIMRAIDInteger = null;

    @JsonProperty("DCIM_SystemView")
    public DCIMSystemView getDCIMSystemView() {
        return dCIMSystemView;
    }

    @JsonProperty("DCIM_SystemView")
    public void setDCIMSystemView(DCIMSystemView dCIMSystemView) {
        this.dCIMSystemView = dCIMSystemView;
    }

    @JsonProperty("DCIM_Memoryview")
    public List<DCIMMemoryview> getDCIMMemoryview() {
        return dCIMMemoryview;
    }

    @JsonProperty("DCIM_Memoryview")
    public void setDCIMMemoryview(List<DCIMMemoryview> dCIMMemoryview) {
        this.dCIMMemoryview = dCIMMemoryview;
    }

    @JsonProperty("DCIM_Powersupplyview")
    public List<DCIMPowersupplyview> getDCIMPowersupplyview() {
        return dCIMPowersupplyview;
    }

    @JsonProperty("DCIM_Powersupplyview")
    public void setDCIMPowersupplyview(List<DCIMPowersupplyview> dCIMPowersupplyview) {
        this.dCIMPowersupplyview = dCIMPowersupplyview;
    }

    @JsonProperty("DCIM_CPUView")
    public List<DCIMCPUView> getDCIMCPUView() {
        return dCIMCPUView;
    }

    @JsonProperty("DCIM_CPUView")
    public void setDCIMCPUView(List<DCIMCPUView> dCIMCPUView) {
        this.dCIMCPUView = dCIMCPUView;
    }

    @JsonProperty("DCIM_VFlashView")
    public DCIMVFlashView getDCIMVFlashView() {
        return dCIMVFlashView;
    }

    @JsonProperty("DCIM_VFlashView")
    public void setDCIMVFlashView(DCIMVFlashView dCIMVFlashView) {
        this.dCIMVFlashView = dCIMVFlashView;
    }

    @JsonProperty("DCIM_FanView")
    public List<DCIMFanView> getDCIMFanView() {
        return dCIMFanView;
    }

    @JsonProperty("DCIM_FanView")
    public void setDCIMFanView(List<DCIMFanView> dCIMFanView) {
        this.dCIMFanView = dCIMFanView;
    }

    @JsonProperty("DCIM_EnclosureView")
    public DCIMEnclosureView getDCIMEnclosureView() {
        return dCIMEnclosureView;
    }

    @JsonProperty("DCIM_EnclosureView")
    public void setDCIMEnclosureView(DCIMEnclosureView dCIMEnclosureView) {
        this.dCIMEnclosureView = dCIMEnclosureView;
    }

    @JsonProperty("DCIM_VirtualDiskView")
    public String getDCIMVirtualDiskView() {
        return dCIMVirtualDiskView;
    }

    @JsonProperty("DCIM_VirtualDiskView")
    public void setDCIMVirtualDiskView(String dCIMVirtualDiskView) {
        this.dCIMVirtualDiskView = dCIMVirtualDiskView;
    }

    @JsonProperty("DCIM_Sensor")
    public List<DCIMSensor> getDCIMSensor() {
        return dCIMSensor;
    }

    @JsonProperty("DCIM_Sensor")
    public void setDCIMSensor(List<DCIMSensor> dCIMSensor) {
        this.dCIMSensor = dCIMSensor;
    }

    @JsonProperty("DCIM_NumericSensor")
    public List<DCIMNumericSensor> getDCIMNumericSensor() {
        return dCIMNumericSensor;
    }

    @JsonProperty("DCIM_NumericSensor")
    public void setDCIMNumericSensor(List<DCIMNumericSensor> dCIMNumericSensor) {
        this.dCIMNumericSensor = dCIMNumericSensor;
    }

    @JsonProperty("DCIM_SystemString")
    public List<DCIMSystemString> getDCIMSystemString() {
        return dCIMSystemString;
    }

    @JsonProperty("DCIM_SystemString")
    public void setDCIMSystemString(List<DCIMSystemString> dCIMSystemString) {
        this.dCIMSystemString = dCIMSystemString;
    }

    @JsonProperty("DCIM_ControllerView")
    public List<DCIMControllerView> getDCIMControllerView() {
        return dCIMControllerView;
    }

    @JsonProperty("DCIM_ControllerView")
    public void setDCIMControllerView(List<DCIMControllerView> dCIMControllerView) {
        this.dCIMControllerView = dCIMControllerView;
    }

    @JsonProperty("DCIM_ControllerBatteryView")
    public String getDCIMControllerBatteryView() {
        return dCIMControllerBatteryView;
    }

    @JsonProperty("DCIM_ControllerBatteryView")
    public void setDCIMControllerBatteryView(String dCIMControllerBatteryView) {
        this.dCIMControllerBatteryView = dCIMControllerBatteryView;
    }

    @JsonProperty("DCIM_RAIDEnumeration")
    public List<DCIMRAIDEnumeration> getDCIMRAIDEnumeration() {
        return dCIMRAIDEnumeration;
    }

    @JsonProperty("DCIM_RAIDEnumeration")
    public void setDCIMRAIDEnumeration(List<DCIMRAIDEnumeration> dCIMRAIDEnumeration) {
        this.dCIMRAIDEnumeration = dCIMRAIDEnumeration;
    }

    @JsonProperty("DCIM_RAIDInteger")
    public List<DCIMRAIDInteger> getDCIMRAIDInteger() {
        return dCIMRAIDInteger;
    }

    @JsonProperty("DCIM_RAIDInteger")
    public void setDCIMRAIDInteger(List<DCIMRAIDInteger> dCIMRAIDInteger) {
        this.dCIMRAIDInteger = dCIMRAIDInteger;
    }

}
