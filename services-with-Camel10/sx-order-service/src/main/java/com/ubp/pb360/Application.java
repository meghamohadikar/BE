package com.ubp.pb360;

import com.backbase.buildingblocks.backend.configuration.autoconfigure.BackbaseApplication;
import com.backbase.buildingblocks.jwt.internal.config.EnableInternalJwtConsumer;
import com.backbase.buildingblocks.registry.client.api.EnableRegistryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@BackbaseApplication
@EnableInternalJwtConsumer
@EnableRegistryClient
@ComponentScan(basePackages = {"com.backbase", "com.ubp.pb360"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class)})
public class Application extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}