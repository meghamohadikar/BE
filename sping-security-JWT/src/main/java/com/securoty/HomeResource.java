package com.securoty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.securoty.models.AuthenticationRequest;
import com.securoty.models.AuthenticationResponse;
import com.securoty.util.JwtUtil;

@RestController
public class HomeResource {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	//[{"key":"Authorization","value":"Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmb28iLCJleHAiOjE1OTMxODIyMjUsImlhdCI6MTU5MzE0NjIyNX0.BuWLEovnuCtT6nCPW47DaegJyYNSWVgX-fTGzKix1Cg","description":""}]
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World!";
	}
	
	@RequestMapping(value="/authenticate",method =RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest request) 
		throws Exception{
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword())
					);
		}catch(BadCredentialsException e){
			throw new Exception("Incorrect username or password",e);
			
		}
		final UserDetails userDetails=myUserDetailsService.loadUserByUsername(request.getUsername());
		final String jwt=jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
