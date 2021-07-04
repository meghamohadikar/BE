package com.microservices;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//for feign configuration
//@FeignClient(name="currency-exchange-service", url="localhost:8000") //for particular instance

//for ribbon configuration
//@FeignClient(name="currency-exchange-service")
//@RibbonClient(name="currency-exchange-service") //for dynamic instance

//for zuul configuration
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")

public interface CurrencyExchangeServiceProxy {
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}") //for zuul
	public CurrencyConversionBean retrieveExchangeValue
		(@PathVariable("from") String from, @PathVariable("to") String to);

}
