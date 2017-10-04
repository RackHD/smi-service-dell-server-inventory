/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.bios;

public class DCIM_BIOSString
{
    private String FQDD;

    private String ValueExpression;

    private String DisplayOrder;

    private String InstanceID;

    private String IsReadOnly;

    private String CurrentValue;

    private String GroupID;

    private String Dependency;

    private String MaxLength;

    private String AttributeDisplayName;

    private String GroupDisplayName;

    private String AttributeName;

    private String MinLength;

    private String PendingValue;

    public String getFQDD ()
    {
        return FQDD;
    }

    public void setFQDD (String FQDD)
    {
        this.FQDD = FQDD;
    }

    public String getValueExpression ()
    {
        return ValueExpression;
    }

    public void setValueExpression (String ValueExpression)
    {
        this.ValueExpression = ValueExpression;
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

    public String getMaxLength ()
    {
        return MaxLength;
    }

    public void setMaxLength (String MaxLength)
    {
        this.MaxLength = MaxLength;
    }

    public String getAttributeDisplayName ()
    {
        return AttributeDisplayName;
    }

    public void setAttributeDisplayName (String AttributeDisplayName)
    {
        this.AttributeDisplayName = AttributeDisplayName;
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

    public String getMinLength ()
    {
        return MinLength;
    }

    public void setMinLength (String MinLength)
    {
        this.MinLength = MinLength;
    }

    public String getPendingValue ()
    {
        return PendingValue;
    }

    public void setPendingValue (String PendingValue)
    {
        this.PendingValue = PendingValue;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [FQDD = "+FQDD+", ValueExpression = "+ValueExpression+", DisplayOrder = "+DisplayOrder+", InstanceID = "+InstanceID+", IsReadOnly = "+IsReadOnly+", CurrentValue = "+CurrentValue+", GroupID = "+GroupID+", Dependency = "+Dependency+", MaxLength = "+MaxLength+", AttributeDisplayName = "+AttributeDisplayName+", GroupDisplayName = "+GroupDisplayName+", AttributeName = "+AttributeName+", MinLength = "+MinLength+", PendingValue = "+PendingValue+"]";
    }
}
