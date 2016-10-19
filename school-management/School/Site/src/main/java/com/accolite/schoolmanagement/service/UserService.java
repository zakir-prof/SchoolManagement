package com.accolite.schoolmanagement.service;

import com.accolite.schoolmanagement.dao.UserDao;
import com.accolite.schoolmanagement.model.User;

public class UserService {

	private UserDao userDao;
	
	public String signIn(User user) {
		// TODO Auto-generated method stub
		boolean userValidation =   validate(user);
		if(userValidation)
			return "success";
		else
			return "failure";
	}

	public boolean validate(User user) {
		// TODO Auto-generated method stub
		return userDao.validate(user);
	}

	public void register(User user) {
		// TODO Auto-generated method stub
		User existingUser = getUser(user.getEmail());
		if(existingUser != null)
			return ;
		else 
		   userDao.insert(user);
	}

	public User getUser(String email) {
		// TODO Auto-generated method stub
		return userDao.getUser(email);
	}

}
