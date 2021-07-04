package com.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users=new ArrayList();
	private static int userCount=3;
	
	static {
		users.add(new User(1,"Megha",new Date()));
		users.add(new User(2,"Anagha",new Date()));
		users.add(new User(3,"Megh",new Date()));
	}
	
	//list out all user
	public List<User> findUsers(){
		return users;
	}
	
	//save new user
	public User save(User user) {
		if(user.getId()==null)
			user.setId(++userCount);
		users.add(user);
		return user;
	}
	
	//fing out particular user
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId()==id)
				return user;
		}
		return null;
	}
	
	//delete particular user
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
	
}
