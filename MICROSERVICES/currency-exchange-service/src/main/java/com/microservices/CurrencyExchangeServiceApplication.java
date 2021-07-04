package com.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import brave.sampler.Sampler;

//dependency:web,actuator,devtools,config client
//http://localhost:8000/h2-console
//h2 datasource url=jdbc:h2:mem:testdb
//http://localhost:8000/currency-exchange/from/EUR/to/INR
//http://localhost:8001/currency-exchange/from/EUR/to/INR

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}

	//sleuth configuration
		public Sampler defaultSampler() {
			return Sampler.ALWAYS_SAMPLE;
		}
}
