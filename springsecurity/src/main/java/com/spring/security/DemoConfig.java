package com.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class DemoConfig extends WebSecurityConfigurerAdapter {
	
	//authority
	@Override
	protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/user").access("hasRole('ROLE_MANAGER')").and().formLogin(); //use "myjavablog" and "secure" 
	//http.authorizeRequests().antMatchers("/login").hasAuthority("ADMIN").antMatchers("/").hasAuthority("MANAGER");
	}
	
	//creating user
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).
	withUser("myjavablog").password("secure").roles("MANAGER");
	}
}
