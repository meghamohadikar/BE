package com.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.security.Principal;

//by default username: user having role MANAGER
//password created by spring boot:in console
@Controller
public class HomeController {
	
		@RequestMapping("/")
		public String home()
		{
			Authentication auth=SecurityContextHolder.getContext().getAuthentication();
			System.out.println("user: "+auth.getName());
			System.out.println("roles: "+auth.getAuthorities());
			return "home.jsp";
		}
		
		@RequestMapping("/login")
		public String loginPage() {
			return "login.jsp";
		}
	
		@RequestMapping("/logout-success")
		public String logoutPage() {
			return "logout.jsp";
		}
		
		@RequestMapping("user")
		@ResponseBody
		public Principal user(Principal principal) {
			return principal;
		}
	

}
