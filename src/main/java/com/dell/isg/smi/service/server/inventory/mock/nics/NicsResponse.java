/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.nics;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "DCIM_NICView",
    "DCIM_NICEnumeration",
    "DCIM_NICString"
})
public class NicsResponse {

    @JsonProperty("DCIM_NICView")
    private List<DCIMNICView> dCIMNICView = null;
    @JsonProperty("DCIM_NICEnumeration")
    private List<DCIMNICEnumeration> dCIMNICEnumeration = null;
    @JsonProperty("DCIM_NICString")
    private List<DCIMNICString> dCIMNICString = null;

    @JsonProperty("DCIM_NICView")
    public List<DCIMNICView> getDCIMNICView() {
        return dCIMNICView;
    }

    @JsonProperty("DCIM_NICView")
    public void setDCIMNICView(List<DCIMNICView> dCIMNICView) {
        this.dCIMNICView = dCIMNICView;
    }

    @JsonProperty("DCIM_NICEnumeration")
    public List<DCIMNICEnumeration> getDCIMNICEnumeration() {
        return dCIMNICEnumeration;
    }

    @JsonProperty("DCIM_NICEnumeration")
    public void setDCIMNICEnumeration(List<DCIMNICEnumeration> dCIMNICEnumeration) {
        this.dCIMNICEnumeration = dCIMNICEnumeration;
    }

    @JsonProperty("DCIM_NICString")
    public List<DCIMNICString> getDCIMNICString() {
        return dCIMNICString;
    }

    @JsonProperty("DCIM_NICString")
    public void setDCIMNICString(List<DCIMNICString> dCIMNICString) {
        this.dCIMNICString = dCIMNICString;
    }

}
