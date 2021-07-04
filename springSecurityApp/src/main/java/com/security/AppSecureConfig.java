package com.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class AppSecureConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	
	/*
	 * //in memory
	 * 
	 * @Bean
	 * 
	 * @Override protected UserDetailsService userDetailsService() {
	 * 
	 * List<UserDetails> users=new ArrayList<UserDetails>();
	 * users.add(User.withDefaultPasswordEncoder().username("megha").password("1234"
	 * ).roles("USER").build());
	 * 
	 * return new InMemoryUserDetailsManager(users); }
	 */
	
	
	/*
	 * //to use username and password from database
	 * 
	 * @Bean public AuthenticationProvider authProvider() {
	 * DaoAuthenticationProvider provider=new DaoAuthenticationProvider(); //to talk
	 * to database provider.setUserDetailsService(userDetailsService); //call
	 * service //provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
	 * provider.setPasswordEncoder(new BCryptPasswordEncoder()); return provider;
	 * 
	 * }
	 */

	//to have customize login-logout pages
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests().antMatchers("/login").permitAll()
			.anyRequest().authenticated(); //for default login page
		/*
		 * .formLogin() .loginPage("/login").permitAll() .and()
		 * .logout().invalidateHttpSession(true) .clearAuthentication(true)
		 * .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		 * .logoutSuccessUrl("logout-success").permitAll();
		 */
			
	}
	
	

}
