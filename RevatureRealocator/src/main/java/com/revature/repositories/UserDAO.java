package com.revature.repositories;
import java.util.List;
import com.revature.models.User;

public interface UserDAO {

	public List<User> findAll();
	public User findById(int id);
	public void save(User u);
	public void update(User u);
	User findByFirstLastName(String f_name, String l_name);
	User getUserByEmail(String email);
}

