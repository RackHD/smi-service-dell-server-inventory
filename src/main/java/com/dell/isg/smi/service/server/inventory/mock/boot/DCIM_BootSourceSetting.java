/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.boot;

public class DCIM_BootSourceSetting
{
    private String CurrentAssignedSequence;

    private String CurrentEnabledStatus;

    private String BootString;

    private String InstanceID;

    private String PendingAssignedSequence;

    private String FailThroughSupported;

    private String PendingEnabledStatus;

    private String BIOSBootString;

    private String BootSourceType;

    private String ElementName;

    public String getCurrentAssignedSequence ()
    {
        return CurrentAssignedSequence;
    }

    public void setCurrentAssignedSequence (String CurrentAssignedSequence)
    {
        this.CurrentAssignedSequence = CurrentAssignedSequence;
    }

    public String getCurrentEnabledStatus ()
    {
        return CurrentEnabledStatus;
    }

    public void setCurrentEnabledStatus (String CurrentEnabledStatus)
    {
        this.CurrentEnabledStatus = CurrentEnabledStatus;
    }

    public String getBootString ()
    {
        return BootString;
    }

    public void setBootString (String BootString)
    {
        this.BootString = BootString;
    }

    public String getInstanceID ()
    {
        return InstanceID;
    }

    public void setInstanceID (String InstanceID)
    {
        this.InstanceID = InstanceID;
    }

    public String getPendingAssignedSequence ()
    {
        return PendingAssignedSequence;
    }

    public void setPendingAssignedSequence (String PendingAssignedSequence)
    {
        this.PendingAssignedSequence = PendingAssignedSequence;
    }

    public String getFailThroughSupported ()
    {
        return FailThroughSupported;
    }

    public void setFailThroughSupported (String FailThroughSupported)
    {
        this.FailThroughSupported = FailThroughSupported;
    }

    public String getPendingEnabledStatus ()
    {
        return PendingEnabledStatus;
    }

    public void setPendingEnabledStatus (String PendingEnabledStatus)
    {
        this.PendingEnabledStatus = PendingEnabledStatus;
    }

    public String getBIOSBootString ()
    {
        return BIOSBootString;
    }

    public void setBIOSBootString (String BIOSBootString)
    {
        this.BIOSBootString = BIOSBootString;
    }

    public String getBootSourceType ()
    {
        return BootSourceType;
    }

    public void setBootSourceType (String BootSourceType)
    {
        this.BootSourceType = BootSourceType;
    }

    public String getElementName ()
    {
        return ElementName;
    }

    public void setElementName (String ElementName)
    {
        this.ElementName = ElementName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [CurrentAssignedSequence = "+CurrentAssignedSequence+", CurrentEnabledStatus = "+CurrentEnabledStatus+", BootString = "+BootString+", InstanceID = "+InstanceID+", PendingAssignedSequence = "+PendingAssignedSequence+", FailThroughSupported = "+FailThroughSupported+", PendingEnabledStatus = "+PendingEnabledStatus+", BIOSBootString = "+BIOSBootString+", BootSourceType = "+BootSourceType+", ElementName = "+ElementName+"]";
    }
}
