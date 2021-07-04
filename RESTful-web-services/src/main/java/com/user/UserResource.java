package com.user;

import java.net.URI;
import java.util.List;
//import org.springframework.hateoas.Resource;
//import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	
	@Autowired
	UserDaoService userDaoService;

	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userDaoService.findUsers();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUsers(@PathVariable int id){
	// Resource<User> retrieveUsers(@PathVariable int id){

		User user= userDaoService.findOne(id);
		if(user==null)
			throw new UserNotFoundException(" User not found for id="+id); 
		return user;
		
		// implementing HATOAS(Hypermedia As The Engine Of Application Service)(added dependency for hatoas)
	
		/*
		 * Resource<User> resource = new Resource<User>(user);
		 * 
		 * ControllerLinkBuilder linkTo =
		 * linkTo(methodOn(this.getClass()).retrieveAllUsers());
		 * 
		 * resource.add(linkTo.withRel("all-users")); 
		 * return resource;
		 */
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser=userDaoService.save(user);
		
		//to return 201 status code instead of 200
		//it will give/users/{id} where id=savedUser.getId()
		//see headers in postman
		URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build(); //returns status code
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userDaoService.deleteById(id);
		if(user==null)
			throw new UserNotFoundException(" User not found for id="+id);		
	}
	
}
