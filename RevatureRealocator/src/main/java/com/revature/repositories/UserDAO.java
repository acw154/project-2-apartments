package com.revature.repositories;

import java.util.List;

import com.revature.models.User;

public interface UserDAO {


	User getUserByEmail(String email);
	public void upsertUser(User user);
	public List<User> findByState(String state);
}

