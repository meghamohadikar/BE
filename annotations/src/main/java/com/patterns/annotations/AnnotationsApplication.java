package com.patterns.annotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages= {"com.patterns.annotations"})
public class AnnotationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnotationsApplication.class, args);
	}

}
