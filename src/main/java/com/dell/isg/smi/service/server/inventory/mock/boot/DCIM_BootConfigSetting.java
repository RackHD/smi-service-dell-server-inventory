/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.boot;

public class DCIM_BootConfigSetting
{
    private String IsNext;

    private String InstanceID;

    private String IsDefault;

    private String ElementName;

    private String IsCurrent;

    public String getIsNext ()
    {
        return IsNext;
    }

    public void setIsNext (String IsNext)
    {
        this.IsNext = IsNext;
    }

    public String getInstanceID ()
    {
        return InstanceID;
    }

    public void setInstanceID (String InstanceID)
    {
        this.InstanceID = InstanceID;
    }

    public String getIsDefault ()
    {
        return IsDefault;
    }

    public void setIsDefault (String IsDefault)
    {
        this.IsDefault = IsDefault;
    }

    public String getElementName ()
    {
        return ElementName;
    }

    public void setElementName (String ElementName)
    {
        this.ElementName = ElementName;
    }

    public String getIsCurrent ()
    {
        return IsCurrent;
    }

    public void setIsCurrent (String IsCurrent)
    {
        this.IsCurrent = IsCurrent;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [IsNext = "+IsNext+", InstanceID = "+InstanceID+", IsDefault = "+IsDefault+", ElementName = "+ElementName+", IsCurrent = "+IsCurrent+"]";
    }
}