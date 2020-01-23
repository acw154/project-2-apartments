package com.revature.repositories;

import com.revature.models.UserStatus;

public interface UserStatusDAO {

	public UserStatus getStatusByString(String status);
	
}
