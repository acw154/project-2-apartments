package com.revature.models;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class User {

	
	
	
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "user_status_id", nullable=false, referencedColumnName = "id")
	private UserStatus userStatus;
	
	
	
}
