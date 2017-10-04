/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.manager;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "DCIM_IDRACCardView",
    "DCIM_iDRACCardEnumeration",
    "DCIM_iDRACCardString"
})
public class ManagerResponse {

    @JsonProperty("DCIM_IDRACCardView")
    private DCIMIDRACCardView dCIMIDRACCardView;
    @JsonProperty("DCIM_iDRACCardEnumeration")
    private List<DCIMIDRACCardEnumeration> dCIMIDRACCardEnumeration = null;
    @JsonProperty("DCIM_iDRACCardString")
    private List<DCIMIDRACCardString> dCIMIDRACCardString = null;

    @JsonProperty("DCIM_IDRACCardView")
    public DCIMIDRACCardView getDCIMIDRACCardView() {
        return dCIMIDRACCardView;
    }

    @JsonProperty("DCIM_IDRACCardView")
    public void setDCIMIDRACCardView(DCIMIDRACCardView dCIMIDRACCardView) {
        this.dCIMIDRACCardView = dCIMIDRACCardView;
    }

    @JsonProperty("DCIM_iDRACCardEnumeration")
    public List<DCIMIDRACCardEnumeration> getDCIMIDRACCardEnumeration() {
        return dCIMIDRACCardEnumeration;
    }

    @JsonProperty("DCIM_iDRACCardEnumeration")
    public void setDCIMIDRACCardEnumeration(List<DCIMIDRACCardEnumeration> dCIMIDRACCardEnumeration) {
        this.dCIMIDRACCardEnumeration = dCIMIDRACCardEnumeration;
    }

    @JsonProperty("DCIM_iDRACCardString")
    public List<DCIMIDRACCardString> getDCIMIDRACCardString() {
        return dCIMIDRACCardString;
    }

    @JsonProperty("DCIM_iDRACCardString")
    public void setDCIMIDRACCardString(List<DCIMIDRACCardString> dCIMIDRACCardString) {
        this.dCIMIDRACCardString = dCIMIDRACCardString;
    }

}
