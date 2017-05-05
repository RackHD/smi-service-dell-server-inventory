/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.Transformer;

public class TransformerAssemblerConstants {

    public static final String[] DATE_PATTERNS = { "EEE MMM dd HH:mm:ss yyyy z", "EEE MMM dd HH:mm:ss z yyyy", "EEE MMM dd HH:mm:ss yyyy", "MMM dd, yyyy", "MMM dd yyyy", "yyyy-MM-dd'T'HH:mm:ss.SSS", "yyyyMMddHHmmss", "EEEMMMddHH:mm:ss yyyy", "mm/dd/yyyy", "yyyy-MM-dd'T'HH:mm:ss'Z'" };

    public static final String POWER_MONITORING_DATE_FORMAT = "EEE MMM dd HH:mm:ss z yyyy";

    public static final String LC_LOGS_DATE_FORMAT = "yyyyMMddHHmmss";

    public static final String ENCLOSURE_DATE_FORMAT = "yyyyMMddHHmmss";

    public static final String CHASSIS_LOG_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
}
