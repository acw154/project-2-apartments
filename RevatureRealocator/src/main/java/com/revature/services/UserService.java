package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Property;
import com.revature.models.User;
import com.revature.repositories.UserDAO;

@Service
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

	
	public boolean upsert(User u) {
		dao.upsertUser(u);
		if(dao.findById(u.getId()).equals(u)) {
			return true;
		}
		return false;
	}

}
