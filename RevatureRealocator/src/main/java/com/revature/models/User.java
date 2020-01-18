package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

public class User {

	
	
	
	@ManyToMany
	@JoinTable(name="saved_properties", joinColumns= {@JoinColumn(name="user_id")},
		inverseJoinColumns= {@JoinColumn(name="property_id")})
	private List<Property> savedProperties = new ArrayList<>();
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "user_status_id", nullable=false, referencedColumnName = "id")
	private UserStatus userStatus;
	
	
	
}
