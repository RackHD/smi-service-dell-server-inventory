/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.boot;

public class DCIM_BIOSEnumeration
{
    private String FQDD;

    private String DisplayOrder;

    private String InstanceID;

    private String IsReadOnly;

    private String CurrentValue;

    private String GroupID;

    private String Dependency;

    private String AttributeDisplayName;

    private String[] PossibleValues;

    private String GroupDisplayName;

    private String AttributeName;

    private String PendingValue;

    private String[] PossibleValuesDescription;

    public String getFQDD ()
    {
        return FQDD;
    }

    public void setFQDD (String FQDD)
    {
        this.FQDD = FQDD;
    }

    public String getDisplayOrder ()
    {
        return DisplayOrder;
    }

    public void setDisplayOrder (String DisplayOrder)
    {
        this.DisplayOrder = DisplayOrder;
    }

    public String getInstanceID ()
    {
        return InstanceID;
    }

    public void setInstanceID (String InstanceID)
    {
        this.InstanceID = InstanceID;
    }

    public String getIsReadOnly ()
    {
        return IsReadOnly;
    }

    public void setIsReadOnly (String IsReadOnly)
    {
        this.IsReadOnly = IsReadOnly;
    }

    public String getCurrentValue ()
    {
        return CurrentValue;
    }

    public void setCurrentValue (String CurrentValue)
    {
        this.CurrentValue = CurrentValue;
    }

    public String getGroupID ()
    {
        return GroupID;
    }

    public void setGroupID (String GroupID)
    {
        this.GroupID = GroupID;
    }

    public String getDependency ()
    {
        return Dependency;
    }

    public void setDependency (String Dependency)
    {
        this.Dependency = Dependency;
    }

    public String getAttributeDisplayName ()
    {
        return AttributeDisplayName;
    }

    public void setAttributeDisplayName (String AttributeDisplayName)
    {
        this.AttributeDisplayName = AttributeDisplayName;
    }

    public String[] getPossibleValues ()
    {
        return PossibleValues;
    }

    public void setPossibleValues (String[] PossibleValues)
    {
        this.PossibleValues = PossibleValues;
    }

    public String getGroupDisplayName ()
    {
        return GroupDisplayName;
    }

    public void setGroupDisplayName (String GroupDisplayName)
    {
        this.GroupDisplayName = GroupDisplayName;
    }

    public String getAttributeName ()
    {
        return AttributeName;
    }

    public void setAttributeName (String AttributeName)
    {
        this.AttributeName = AttributeName;
    }

    public String getPendingValue ()
    {
        return PendingValue;
    }

    public void setPendingValue (String PendingValue)
    {
        this.PendingValue = PendingValue;
    }

    public String[] getPossibleValuesDescription ()
    {
        return PossibleValuesDescription;
    }

    public void setPossibleValuesDescription (String[] PossibleValuesDescription)
    {
        this.PossibleValuesDescription = PossibleValuesDescription;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [FQDD = "+FQDD+", DisplayOrder = "+DisplayOrder+", InstanceID = "+InstanceID+", IsReadOnly = "+IsReadOnly+", CurrentValue = "+CurrentValue+", GroupID = "+GroupID+", Dependency = "+Dependency+", AttributeDisplayName = "+AttributeDisplayName+", PossibleValues = "+PossibleValues+", GroupDisplayName = "+GroupDisplayName+", AttributeName = "+AttributeName+", PendingValue = "+PendingValue+", PossibleValuesDescription = "+PossibleValuesDescription+"]";
    }
}
