package com.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //enables class for handling http rest methods
public class HelloWorldController {
	
	@Autowired
	MessageSource messageSource;
	
	//@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World!";
	}
	
	//returns object in json format 
	@GetMapping(path="/hello-world-bean")
	public HelloWorld helloWorldBean() {
		return new HelloWorld("Hello World!");
	}
	
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorld helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorld(String.format("Hello World!,%s",name));
	}
	
	//add header in request[{"key":"Accept-Language","value":"fr","description":""}]
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language",required=false)Locale locale) {
		//return messageSource.getMessage("good.morning.message", null, locale);
		return messageSource.getMessage("good.morning.message", null,LocaleContextHolder.getLocale());
	}

}
