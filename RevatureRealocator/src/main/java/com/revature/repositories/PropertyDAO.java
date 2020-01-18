package com.revature.repositories;

import java.util.List;

import com.revature.models.Property;
import com.revature.models.Preference;

public interface PropertyDAO {
	public List<Property> findAll();
	public Property findById(int id);
	public Property findByAddressWithApt(int street_num, String street, int apt_num, String city, String state);
	public Property findByAddressNoApt(int street_num, String street, String city, String state);
	public void upsert(Property p);
	public List<Property> getPropertiesByUserId(int user_id);
	public void delete(Property p);
	public List<Property> findPropertiesByFilter(Preference pref);
	
	
}
