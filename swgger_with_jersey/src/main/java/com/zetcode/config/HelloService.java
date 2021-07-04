package com.zetcode.config;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Component;

@Path("/hello")
@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

@Api(value = "Group resource", produces = "application/json")
public class HelloService {

    @GET
    @Produces("application/json")
    @ApiOperation(value = "Create group.", response = String.class)
    public String hello() {
        return "Hello from Spring";
    }
}