package com.zetcode.config;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class MySpringBootRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
    	 restConfiguration()
    	       .component("servlet")
    	       .bindingMode(RestBindingMode.auto);
    	
    	 rest()
         .path("/api")
         	.consumes("application/json")
         	.produces("application/json")
//http://localhost:8080/services/api
         .get()
             .outType(ResponseType.class) 
             .to("bean:getBean") 
//http://localhost:8080/services/api
//{
     //"name": "MEGHA"
//}
         .post()
             .type(PostRequestType.class) // Setting the request type enables Camel to unmarshal the request to a Java object
             .outType(ResponseType.class) // Setting the response type enables Camel to marshal the response to JSON
             .to("bean:postBean");
    	 
    	 }
    
	/*
	 * rest("/customers")
	 * .get().route().to("bean:customerService?method=listCustomers")
	 * .post().route().to("jms:queue:CUSTOMERS");
	 */

}
