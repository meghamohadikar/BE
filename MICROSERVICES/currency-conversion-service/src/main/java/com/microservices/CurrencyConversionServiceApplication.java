package com.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import brave.sampler.Sampler;

//http://localhost:8100/currency-converter-feign/from/EUR/to/INR/quantity/10
@SpringBootApplication
@EnableFeignClients("com.microservices")
@EnableDiscoveryClient
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}

	//sleuth configuration
		public Sampler defaultSampler() {
			return Sampler.ALWAYS_SAMPLE;
		}
}
