package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.JsonNode;
import com.revature.models.Preference;
import com.revature.models.Property;
import com.revature.models.PropertyDTO;
import com.revature.models.PropertyType;
import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.repositories.PropertyDAO;
import com.revature.util.APIParse;
import com.revature.util.APIUtil;

@Service
public class PropertyService {
	
	
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private APIUtil api;
	
	@Autowired
	private PropertyDAO pdao;
	
	@Autowired
	private PropertyTypeService ptService;
	
	@Autowired
	private UserService us;
	
	public PropertyService() {
		
	}
	public PropertyService(PropertyDAO pdao) {
		this.pdao = pdao;
	}
	
	public PropertyService(PropertyDAO pdao, PropertyTypeService ptService) {
		this.pdao = pdao;
		this.ptService = ptService;
	}
	
	public PropertyService(PropertyDAO pdao, PropertyTypeService ptService, UserService us) {
		this.pdao = pdao;
		this.ptService = ptService;
		this.us = us;
	}
	
	
	
	
	
	public Property findByAddress(int street_num, String street, int apt_num, String city, String state) {
		if(apt_num != 0) {
			return pdao.findByAddressWithApt(street_num, street, apt_num, city, state);
		} else {
			return pdao.findByAddressNoApt(street_num, street, city, state);
		}
	}
	
	public boolean upsert(Property p) {
		p.setPropertyType(grabActualPropertyType(p));
		pdao.upsert(p);
		
		if(p.getApt_num() != 0) {
			Property other = pdao.findByAddressWithApt(p.getStreet_num(), p.getStreet(), p.getApt_num(), p.getCity(), p.getState());
			if(p.equals(other)) {
				return true;
			}
		} else {
			Property other = pdao.findByAddressNoApt(p.getStreet_num(), p.getStreet(), p.getCity(), p.getState());
			if(p.equals(other)) {
				return true;
			}
		}
		return false;
	}
	
	
	

	public List<PropertyDTO> findPropertiesByFilter(Preference pref){
		// from the api
		String city = pref.getCity();
		String state = pref.getState_code();
		
		String query = api.createSimpleQuery(state, city);
		List<Property> list3 = APIParse.parse(api.getResponse(query).getBody());
		for(Property p : list3) {
			p.setState(state);
		}
		//Filter by min max bed bath
		double prefmin = pref.getMinPrice();
		double prefmax = pref.getMaxPrice();
		double prefbath = pref.getNumBaths();
		double prefbed = pref.getNumBeds();
		List<Property> list2 = new ArrayList<>();
		for(Property prop : list3) {
			if((prop.getPrice() > prefmin) && (prop.getPrice() < prefmax) &&
					(prop.getNum_baths() > prefbath) && (prop.getNum_beds() > prefbed)) {
				list2.add(prop);
			}
		}
		// from the db
		List<Property> emplist = pdao.findByStateNoApt(state);
		List<PropertyDTO> dtoList2 = new ArrayList<>();
		if(emplist != null) {
			emplist.addAll(list2);
			for(Property p: emplist) {
				dtoList2.add(new PropertyDTO(p));
			}
			return dtoList2;
		}
		List<PropertyDTO> dtoList = new ArrayList<>();
		for(Property p: list3) {
			dtoList.add(new PropertyDTO(p));
		}
		return dtoList;
	}
	
	public PropertyType grabActualPropertyType(Property property) {
		String typeString = property.getPropertyType().getType();
		PropertyType fullType = ptService.findByType(typeString);
		return fullType;
	}
	
	public UserDTO associateUserAndProperty(Property property, String email) {
		User user = us.findByEmail(email);
		List<Property> list = user.getSavedProperties();
		upsert(property);
		int streetnum = property.getStreet_num();
		String street = property.getStreet();
		int apt = property.getApt_num();
		String cty = property.getCity();
		String st = property.getState();
		Property p = findByAddress(streetnum, street, apt, cty, st);
		list.add(p);
		user.setSavedProperties(list);
		try {
			user = us.upsert(user);
			//property.addUser(user);
			//pdao.upsert(property);
			UserDTO dto = new UserDTO(user);
			return dto;
		} catch (Exception e) {
			return null;
		}
	}
	
	
}
