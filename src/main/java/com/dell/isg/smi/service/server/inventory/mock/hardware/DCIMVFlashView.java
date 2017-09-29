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
    "InstanceID",
    "ComponentName",
    "FQDD"
})
public class DCIMVFlashView {

    @JsonProperty("DeviceDescription")
    private String deviceDescription;
    @JsonProperty("InstanceID")
    private String instanceID;
    @JsonProperty("ComponentName")
    private String componentName;
    @JsonProperty("FQDD")
    private String fQDD;

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

    @JsonProperty("ComponentName")
    public String getComponentName() {
        return componentName;
    }

    @JsonProperty("ComponentName")
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    @JsonProperty("FQDD")
    public String getFQDD() {
        return fQDD;
    }

    @JsonProperty("FQDD")
    public void setFQDD(String fQDD) {
        this.fQDD = fQDD;
    }

}
