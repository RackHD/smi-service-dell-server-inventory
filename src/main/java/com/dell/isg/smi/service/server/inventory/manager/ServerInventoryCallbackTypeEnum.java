/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.manager;

import java.util.HashMap;
import java.util.Map;

public enum ServerInventoryCallbackTypeEnum {

    HARDWARE("hardware"), NICS("nics"), SOFTWARE("software"), SYSTEM("system"), BIOS("bios"), BOOT("boot"), SELLOG("sellog"), LCLOG("lclog");

    private final String name;


    private ServerInventoryCallbackTypeEnum(String name) {
        this.name = name;
    }

    // Reverse-lookup map for getting a day from an abbreviation
    private static final Map<String, ServerInventoryCallbackTypeEnum> lookup = new HashMap<String, ServerInventoryCallbackTypeEnum>();

    static {
        for (ServerInventoryCallbackTypeEnum enumType : ServerInventoryCallbackTypeEnum.values()) {
            lookup.put(enumType.getName(), enumType);
        }
    }


    public String getName() {
        return name;
    }


    public String getValue() {
        return name();
    }


    @Override
    public String toString() {
        return name;
    }


    public static ServerInventoryCallbackTypeEnum getEnum(String enumType) {
        return lookup.get(enumType);
    }

}
