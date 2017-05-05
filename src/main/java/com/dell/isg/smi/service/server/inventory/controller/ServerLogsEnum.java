/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.controller;

public enum ServerLogsEnum {

    SEL("sel"), LC("lc");

    private String _label;


    private ServerLogsEnum(String label) {
        _label = label;
    }


    public String getLabel() {
        return _label;
    }


    public String getValue() {
        return name();
    }


    @Override
    public String toString() {
        return _label;
    }
}
