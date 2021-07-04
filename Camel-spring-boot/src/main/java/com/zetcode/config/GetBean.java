package com.zetcode.config;

import org.springframework.stereotype.Component;

@Component
public class GetBean {

    public ResponseType sayHello() {
    	System.out.println("in sayHello method");
        // Your logic can go here! If you return a POJO, Camel will try and serialise it to JSON.
        return new ResponseType("Hello, world!");
    }

}