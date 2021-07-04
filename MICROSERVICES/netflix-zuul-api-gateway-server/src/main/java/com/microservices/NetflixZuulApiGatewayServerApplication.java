package com.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import brave.sampler.Sampler;

//dependency: zuul,eureka discovery,actuator,devtools
//http://localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/INR  explicitely routing through the zuul
//http://localhost:8765/currency-conversion-service/currency-converter-feign/from/EUR/to/INR/quantity/10

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class NetflixZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
	}
	
	//sleuth configuration
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
