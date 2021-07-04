package com.second;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

@RestController
@RibbonClient(name = "hello-service", configuration = HelloServiceConfiguration.class)
@SpringBootApplication
public class UserServiceApplication {
	
	@LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
    @Autowired
    RestTemplate restTemplate;
    
    @RequestMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "Rafael") String name) {

        String greeting = this.restTemplate.getForObject("http://hello-service/greeting", String.class);
        return String.format("%s, %s!,", greeting, name);
    }
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}


	class HelloServiceConfiguration {
    @Autowired
    IClientConfig ribbonClientConfig;
    @Bean
    public IPing ribbonPing(IClientConfig config) {
        return new PingUrl();
    }
    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new AvailabilityFilteringRule();
    }
}

