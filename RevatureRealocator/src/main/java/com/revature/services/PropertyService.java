package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Preference;
import com.revature.models.Property;
import com.revature.repositories.PropertyDAO;
import com.revature.repositories.PropertyDAOImpl;

@Service
public class PropertyService {
	@Autowired
	private PropertyDAO pdao = new PropertyDAOImpl();
	
	public List<Property> findAll(){
		return pdao.findAll();
	}
	
	public Property findById(int id) {
		return pdao.findById(id);
	}
	
	public Property findByAddress(int street_num, String street, int apt_num, String city, String state) {
		if(apt_num != 0) {
			return pdao.findByAddressWithApt(street_num, street, apt_num, city, state);
		} else {
			return pdao.findByAddressNoApt(street_num, street, city, state);
		}
	}
	
	public boolean upsert(Property p) {
		pdao.upsert(p);
		if(pdao.findById(p.getProperty_id()).equals(p)) {
			return true;
		}
		return false;
	}
	
	public List<Property> getPropertiesByUserId(int user_id){
		return pdao.getPropertiesByUserId(user_id);
	}
	
	public boolean delete(Property p) {
		pdao.delete(p);
		if(pdao.findById(p.getProperty_id()) == null) {
			return true;
		}
		return false;
	}
	public List<Property> findPropertiesByFilter(Preference pref){
		return pdao.findPropertiesByFilter(pref);
	}
}
