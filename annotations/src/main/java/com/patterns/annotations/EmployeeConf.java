package com.patterns.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class EmployeeConf {
	
	@Bean(name="first")
	public Emp empBean() {
		return new Employee();
	}
	
	 @Bean(name="second")
	 @Primary
	 public Emp empBeans() { 
		 return new Emploee1(); 
		 }
	

}
