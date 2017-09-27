/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "version")
@PropertySource({ 
	  "classpath:version.properties"
	})
@Component
public class Version {

	public Version() {
		super();
	}
	
	private String major;
	
	private String tag;
	
	private String build;
	
	private String date;

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Release Version [Version=" + major + ", Tag=" + tag + ", Build=" + build + ", Date=" + date + "]";
	}
	

	



}
