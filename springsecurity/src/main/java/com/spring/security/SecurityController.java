package com.spring.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

@RestController
public class SecurityController {
	
	@RequestMapping("/home")
	public String home() {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		System.out.println("user: "+auth.getName());
		System.out.println("roles: "+auth.getAuthorities());
		 return "Welcome Home!!!";	
	}

	@RequestMapping("/user")
	public String user() {
		return "returning user";
	}
}
