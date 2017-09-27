/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "buildInfo")
@PropertySource({ 
	  "classpath:buildInfo.properties"
	})
@Component
public class BuildInfo {

	public BuildInfo() {
		super();
	}
	
	private String version;
	
	private String tag;
	
	private String date;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Release Version [Version=" + version + ", Tag=" + tag + ", Date=" + date + "]";
	}
	

	



}
