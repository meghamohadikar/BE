package com.zetcode.config;

import org.springframework.context.annotation.Configuration;
import org.glassfish.jersey.server.ResourceConfig;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        
        register(HelloService.class);
        register(ReverseService.class);
    }
}