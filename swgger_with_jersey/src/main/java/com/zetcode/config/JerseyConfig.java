package com.zetcode.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(HelloService.class);
    }

    @PostConstruct
    public void init() {
        // Register components where DI is needed
        this.configureSwagger();
        //this.registerEndpoints();
    }

    private void configureSwagger() {
        // Available at localhost:port/api/swagger.json
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);

        BeanConfig config = new BeanConfig();
        config.setConfigId("springboot-jersey-swagger-test-app");
        config.setTitle("Spring Boot, Jersey, Swagger Test Application");
        config.setVersion("v1");
        config.setContact("Dmitry Kovalsky");
        config.setSchemes(new String[] { "http", "https" });
        config.setBasePath("/api");
        config.setResourcePackage("com.example.demo");
        config.setPrettyPrint(true);
        config.setScan(true);
    }
}