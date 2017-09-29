/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.boot;

public class BootResponse
{
    private DCIM_BIOSEnumeration[] DCIM_BIOSEnumeration;

    private DCIM_BootConfigSetting[] DCIM_BootConfigSetting;

    private DCIM_BootSourceSetting[] DCIM_BootSourceSetting;

    public DCIM_BIOSEnumeration[] getDCIM_BIOSEnumeration ()
    {
        return DCIM_BIOSEnumeration;
    }

    public void setDCIM_BIOSEnumeration (DCIM_BIOSEnumeration[] DCIM_BIOSEnumeration)
    {
        this.DCIM_BIOSEnumeration = DCIM_BIOSEnumeration;
    }

    public DCIM_BootConfigSetting[] getDCIM_BootConfigSetting ()
    {
        return DCIM_BootConfigSetting;
    }

    public void setDCIM_BootConfigSetting (DCIM_BootConfigSetting[] DCIM_BootConfigSetting)
    {
        this.DCIM_BootConfigSetting = DCIM_BootConfigSetting;
    }

    public DCIM_BootSourceSetting[] getDCIM_BootSourceSetting ()
    {
        return DCIM_BootSourceSetting;
    }

    public void setDCIM_BootSourceSetting (DCIM_BootSourceSetting[] DCIM_BootSourceSetting)
    {
        this.DCIM_BootSourceSetting = DCIM_BootSourceSetting;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [DCIM_BIOSEnumeration = "+DCIM_BIOSEnumeration+", DCIM_BootConfigSetting = "+DCIM_BootConfigSetting+", DCIM_BootSourceSetting = "+DCIM_BootSourceSetting+"]";
    }
}
