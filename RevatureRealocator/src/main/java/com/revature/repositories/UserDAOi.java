package com.revature.repositories;



import java.util.List;

import com.revature.models.User;

public interface UserDAOi {

	public List<User> findAll();
	public User findById(int id);
	public void save(User u);
	public void update(User u);
}
