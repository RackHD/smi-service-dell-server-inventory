/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.smi.service.server.inventory;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.dell.isg.smi.service.server.inventory.BuildInfo;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableAutoConfiguration
@EnableSwagger2
@EnableDiscoveryClient
@EnableAsync
@ComponentScan("com.dell.isg.smi")
public class Application extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Autowired
	private BuildInfo buildInfo;

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }


    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    public Docket newsApiV1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("serverInventory-v1.0").apiInfo(new ApiInfoBuilder().title("SMI Micro-service :  Server Inventory v1.0").version(buildInfo.toString()).build()).select().paths(regex("/api/1.0.*")).build();
    }
    
    @Bean
    public Docket newsApiV2() {
    	buildInfo.setApiVersion("2.0");
        return new Docket(DocumentationType.SWAGGER_2).groupName("serverInventory-v2.0").apiInfo(new ApiInfoBuilder().title("SMI Micro-service :  Server Inventory v2.0").version(buildInfo.toString()).build()).select().paths(regex("/api/2.0.*")).build();
    }
    
}
