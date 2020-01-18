package com.revature.repositories;



import java.util.List;

import com.revature.models.User;

public interface UserDAOi {

	public List<User> findAll();
	public User findById(int id);
	public void save(User u);
	public void update(User u);
<<<<<<< HEAD:RevatureRealocator/src/main/java/com/revature/repositories/IUserDAO.java
	public User getUserByEmail(String email);
	User findByFirstLastName(String f_name, String l_name);

=======
>>>>>>> master:RevatureRealocator/src/main/java/com/revature/repositories/UserDAOi.java
}
