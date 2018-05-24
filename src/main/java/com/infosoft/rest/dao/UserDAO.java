package com.infosoft.rest.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.infosoft.rest.model.User;

//Just to avoid DB calls in this example, Assume below data is interacting with DB

@Repository
public class UserDAO {
	static HashMap<Integer, User> usersMap = new HashMap<Integer, User>();

	public UserDAO() {
			User user1 = new User();
			user1.setId(1);
			user1.setAge(20);
			user1.setName("Bhushan");
			
	
			usersMap.put(1, user1);
			
	}

	public List<User> getAllUsers() {

		List<User> userList = new ArrayList<User>(usersMap.values());
		return userList;
	}

	public User getUserForId(int id) {
		User user = usersMap.get(id);
		return user;
	}

	public User createUser(@RequestBody User user) {
		usersMap.put(user.getId(), user);
		return user;
	}

	public User updateUser(@RequestBody User user) {
		if (usersMap.get(user.getId()) != null) {
			usersMap.get(user.getId()).setName(user.getName());
			usersMap.get(user.getId()).setAge(user.getAge());
		} else {
			usersMap.put(user.getId(), user);
		}
		return user;
	}

	public User deleteUser(int id) {
		User userResponse = usersMap.remove(id);
		return userResponse;
	}

}
