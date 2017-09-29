/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.software;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "DCIM_SoftwareIdentity",
    "CIM_InstalledSoftwareIdentity"
})
public class SoftwareResponse {

    @JsonProperty("DCIM_SoftwareIdentity")
    private List<DCIMSoftwareIdentity> dCIMSoftwareIdentity = null;
    @JsonProperty("CIM_InstalledSoftwareIdentity")
    private CIMInstalledSoftwareIdentity cIMInstalledSoftwareIdentity;

    @JsonProperty("DCIM_SoftwareIdentity")
    public List<DCIMSoftwareIdentity> getDCIMSoftwareIdentity() {
        return dCIMSoftwareIdentity;
    }

    @JsonProperty("DCIM_SoftwareIdentity")
    public void setDCIMSoftwareIdentity(List<DCIMSoftwareIdentity> dCIMSoftwareIdentity) {
        this.dCIMSoftwareIdentity = dCIMSoftwareIdentity;
    }

    @JsonProperty("CIM_InstalledSoftwareIdentity")
    public CIMInstalledSoftwareIdentity getCIMInstalledSoftwareIdentity() {
        return cIMInstalledSoftwareIdentity;
    }

    @JsonProperty("CIM_InstalledSoftwareIdentity")
    public void setCIMInstalledSoftwareIdentity(CIMInstalledSoftwareIdentity cIMInstalledSoftwareIdentity) {
        this.cIMInstalledSoftwareIdentity = cIMInstalledSoftwareIdentity;
    }

}
