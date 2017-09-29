/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.bios;

public class BiosResponse
{
    private DCIM_BIOSEnumeration[] DCIM_BIOSEnumeration;

    private DCIM_BIOSString[] DCIM_BIOSString;

    public DCIM_BIOSEnumeration[] getDCIM_BIOSEnumeration ()
    {
        return DCIM_BIOSEnumeration;
    }

    public void setDCIM_BIOSEnumeration (DCIM_BIOSEnumeration[] DCIM_BIOSEnumeration)
    {
        this.DCIM_BIOSEnumeration = DCIM_BIOSEnumeration;
    }

    public DCIM_BIOSString[] getDCIM_BIOSString ()
    {
        return DCIM_BIOSString;
    }

    public void setDCIM_BIOSString (DCIM_BIOSString[] DCIM_BIOSString)
    {
        this.DCIM_BIOSString = DCIM_BIOSString;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [DCIM_BIOSEnumeration = "+DCIM_BIOSEnumeration+", DCIM_BIOSString = "+DCIM_BIOSString+"]";
    }
}
