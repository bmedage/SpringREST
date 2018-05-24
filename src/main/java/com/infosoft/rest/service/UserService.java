package com.infosoft.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosoft.rest.dao.UserDAO;
import com.infosoft.rest.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDao;

	public List<User> getAllUsers() {
		List<User> userList = userDao.getAllUsers();
		return userList;
	}

	public User getUserForId(int id) {
		User user = userDao.getUserForId(id);
		return user;
	}

	public User createUser(User user) {
		User userResponse = userDao.createUser(user);
		return userResponse;
	}

	public User updateUser(User user) {
		User userResponse = userDao.updateUser(user);
		return userResponse;
	}

	public User deleteUser(int id) {
		User userResponse = userDao.deleteUser(id);
		return userResponse;
	}

}
