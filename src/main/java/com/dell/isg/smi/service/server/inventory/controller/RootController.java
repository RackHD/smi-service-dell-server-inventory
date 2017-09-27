/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dell.isg.smi.service.server.inventory.Version;

@RestController
@RequestMapping("/")
public class RootController {
	
	@Autowired
	private Version version;

    @RequestMapping(method = RequestMethod.GET)
    public String version() {
        return version.toString();
    }

}
