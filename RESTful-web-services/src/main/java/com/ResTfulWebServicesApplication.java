package com;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class ResTfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResTfulWebServicesApplication.class, args);
	}

	//for internationalization
	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	//we can remove below method by mentioning  in application.properties
	/*
	 * @Bean //method name should be messageSource() 
	 * public ResourceBundleMessageSource messageSource() { 
	 * ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
	 * messageSource.setBasename("messages"); 
	 * return messageSource;
	 * 
	 * }
	 */
}
