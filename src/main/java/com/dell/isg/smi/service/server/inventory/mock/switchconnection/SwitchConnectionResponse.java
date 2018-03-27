/**
 * Copyright © 2018 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.mock.switchconnection;


public class SwitchConnectionResponse {

    private String instanceID;
    private String fqdd;
    private String switchConnectionID;
    private String switchPortConnectionID;
    private long staleData;

    public String getFQDD() {
        return fqdd;
    }

    public void setFQDD(String fqdd) {
        this.fqdd = fqdd;
    }

    public String getSwitchConnectionID() {
        return switchConnectionID;
    }

    public void setSwitchConnectionID(String switchConnectionID) {
        this.switchConnectionID = switchConnectionID;
    }

    public String getInstanceID() {
        return instanceID;
    }

    public void setInstanceID(String instanceID) {
        this.instanceID = instanceID;
    }

    public String getSwitchPortConnectionID() {
        return switchPortConnectionID;
    }

    public void setSwitchPortConnectionID(String switchPortConnectionID) {
        this.switchPortConnectionID = switchPortConnectionID;
    }

    public long getStaleData() {
        return staleData;
    }

    public void setStaleData(long staleData) {
        this.staleData = staleData;
    }

}

