package com.securoty;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//try username=ben with password=benspassword
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	//for authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.ldapAuthentication()
		.userDnPatterns("uid={0},ou=people")
        .groupSearchBase("ou=groups")
        .contextSource()
        .url("ldap://localhost:8389/dc=springframework,dc=org")
        .and()
        .passwordCompare()
        .passwordEncoder(new BCryptPasswordEncoder())
        .passwordAttribute("userPassword");
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	//for authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.anyRequest().fullyAuthenticated()
		.and()
		.formLogin();
	}
}
