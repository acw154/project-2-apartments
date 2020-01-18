package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.User;
import com.revature.repositories.UserDAO;

public class UserService {
	
	public UserService(UserDAO dao) {
		super();
		this.dao = dao;
	}

	@Autowired
	private UserDAO dao;
	
	public List<User> findAll() {
		return dao.findAll();
	}
	
	public User findById(int id) {
		return dao.findById(id);
	}

}
