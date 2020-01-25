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
import com.revature.models.PropertyType;
import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.repositories.PropertyDAO;
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
		System.out.println("inside upsert() of PropertyServices, about to grabActualPropertyType");
		System.out.println(p);
		p.setPropertyType(grabActualPropertyType(p));
		System.out.println("inside upsert() of PropertyServices, just set a complete propertyType ");
		System.out.println(p);
		pdao.upsert(p);
		System.out.println("inside upsert() of PropertyServices, just used upsert() of propertyDAO ");
		
		if(p.getApt_num() != 0) {
			System.out.println("inside if, with apartment comparison");
			Property other = pdao.findByAddressWithApt(p.getStreet_num(), p.getStreet(), p.getApt_num(), p.getCity(), p.getState());
			if(p.equals(other)) {
				return true;
			}
			System.out.println("did not hit true for .equals");
		} else {
			System.out.println("inside if, without apartment comparison");
			Property other = pdao.findByAddressNoApt(p.getStreet_num(), p.getStreet(), p.getCity(), p.getState());
			if(p.equals(other)) {
				return true;
			}
			System.out.println("did not hit true for .equals");
		}
		System.out.println("about to hit false");
		return false;
//		if(pdao.findById(p.getProperty_id()).equals(p)) {
//			System.out.println("property");
//			return true;
//		}
//		return false;
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
		// from the api
//		String query = api.createQueryByPreference(pref);
//		List<Property> list = APIParse.parse((api.getResponse(query)));
		String city = pref.getCity();
		String state = pref.getState_code();
		
		String query = api.createSimpleQuery(state, city);
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		JsonParser jp = new JsonParser();
//		JsonElement je = jp.parse(api.getResponse(query).getBody().toString());
//		String prettyJsonString = gson.toJson(je);
		List<Property> list3 = APIParse.parse(api.getResponse(query).getBody());
		for(Property p : list3) {
			p.setState(state);
		}
		//Filter by min max bed bath
		double prefmin = pref.getMinPrice();
		double prefmax = pref.getMaxPrice();
		double prefbath = pref.getNumBaths();
		double prefbed = pref.getNumBeds();
		System.out.println(list3);
		List<Property> list2 = new ArrayList<>();
		for(Property prop : list3) {
			//System.out.println(prop);
			if((prop.getPrice() > prefmin) && (prop.getPrice() < prefmax) &&
					(prop.getNum_baths() > prefbath) && (prop.getNum_beds() > prefbed)) {
				list2.add(prop);
			}
		}
		//System.out.println(list3);
		// from the db
		//String state = pref.getState_code();
		List<Property> emplist = pdao.findByStateNoApt(state);
		//System.out.println(emplist);
		if(emplist != null) {
		emplist.addAll(list2);
		return emplist;
		}
		return list3;
	}
	
	public PropertyType grabActualPropertyType(Property property) {
		String typeString = property.getPropertyType().getType();
		PropertyType fullType = ptService.findByType(typeString);
		return fullType;
	}
	
	public UserDTO associateUserAndProperty(Property property, String email) {
		User user = us.findByEmail(email);
		System.out.println("user from userservice findbyemail(): "+user);
		List<Property> list = user.getSavedProperties();
		System.out.println("list from the user from last method: "+list);
		upsert(property);
		int streetnum = property.getStreet_num();
		String street = property.getStreet();
		int apt = property.getApt_num();
		String cty = property.getCity();
		String st = property.getState();
		Property p = findByAddress(streetnum, street, apt, cty, st);
		list.add(p);
		System.out.println("list with property injected added to it: "+list);
		user.setSavedProperties(list);
		System.out.println("user with list set to it: "+user);
		try {
			user = us.upsert(user);
			System.out.println("user returned after upserted using userservice: "+user);
			//property.addUser(user);
			System.out.println("property after adding the user returned from last method: "+property);
			//pdao.upsert(property);
			System.out.println("property returned from pdao upsert method: "+property);
			UserDTO dto = new UserDTO(user);
			System.out.println("dto from injecting the user into dto constructor"+dto);
			return dto;
		} catch (Exception e) {
			return null;
		}
	}
	
	
}
