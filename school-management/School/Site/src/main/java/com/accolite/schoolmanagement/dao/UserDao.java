package com.accolite.schoolmanagement.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.accolite.schoolmanagement.model.User;

public class UserDao {

	private HibernateTemplate hibernateTemplate;
	
	public boolean validate(User user) {
		// TODO Auto-generated method stub
		String hql = "from user where email = :email and password = :password";
		User user2 =  (User) hibernateTemplate.findByNamedParam(hql, new String[]{"email","password"}, 
				new String[]{user.getEmail(),user.getPassword()});
		if(user2 == null) 
			return false;
		else
			return true;
	}

	public void insert(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(user);
	}

	public User getUser(String email) {
		// TODO Auto-generated method stub
		String hql = "from user where email = :email";
		return (User) hibernateTemplate.findByNamedParam(hql, new String[]{"email"}, new String[]{email});
	}

	
}
