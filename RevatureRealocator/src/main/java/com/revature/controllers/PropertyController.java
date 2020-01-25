package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Preference;
import com.revature.models.PreferenceDTO;
import com.revature.models.Property;
import com.revature.models.PropertyDTO;
import com.revature.models.SimpleSearchBody;
import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.services.APIParse;
import com.revature.services.PropertyService;
import com.revature.util.APIUtil;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PropertyController {
	
	@Autowired 
	private PropertyService ps;
	
	@Autowired
	private APIUtil api;
	
	
	@PostMapping("/propsearchpref")
	public ResponseEntity<List<Property>> getProperties(@RequestBody PreferenceDTO pref){
		//Get POST request values and create a preference object to create an API call with
		System.out.println(pref);
		Preference full = new Preference(pref);
		List<Property> list = ps.findPropertiesByFilter(full);
//		String query = api.createQueryByPreference(full);
//		List<Property> list = APIParse.parse(api.getResponse(query).toString()); //TODO: Map the response body to Properties and return them
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping("/propsearchsimple")
	public ResponseEntity<List<Property>> getPropertiesSimpleSearch(@RequestBody SimpleSearchBody ssb){
		String state_code = ssb.getState_code();
		String city = ssb.getCity();
		String query = api.createSimpleQuery(state_code, city);
		List<Property> list = APIParse.parse(api.getResponse(query).toString());
		return ResponseEntity.ok().body(list);
	}
	
//	@PostMapping("/propsearch")
//	public List<Property> getPropertiesSimpleSearch(@RequestBody Preference pref){
//		String query = api.createSimpleQuery(pref);
//		List<Property> list = APIParse.parse(api.getResponse(query).toString()); //TODO: Map the response body to Properties and return them
//		return list;
//	}
	
	@PostMapping("/propsearch")
	public ResponseEntity<List<Property>> getProperties(String state_code, String city){
		//Get POST request values and create a preference object to create an API call with
		String query = api.createSimpleQuery(state_code, city);
		List<Property> list = APIParse.parse(api.getResponse(query).toString()); //TODO: Map the response body to Properties and return them
		return ResponseEntity.ok().body(list);
	}	
	

	@PostMapping(value = "/propsave")
	@ResponseBody
	//public ResponseEntity<Property> saveOrAddProperty(@RequestBody PropertyDTO dto) {
	public Property saveOrAddProperty(@RequestBody PropertyDTO dto) {
		System.out.println("inside of saveOrAddProperty method in UserController");

		System.out.println(dto);
		Property property = new Property(dto);
		System.out.println(property);
		if(ps.upsert(property) != false) {
			System.out.println("good creation.. returned true... about to send back a good status with the property in the body");
			//return ResponseEntity.status(HttpStatus.CREATED).body(property);
			return property;
		} else {
			property = null;
			System.out.println("bad creation??? returned false in services... about to send back a NO_CONTENT status with a null property");
			//return ResponseEntity.status(HttpStatus.NO_CONTENT).body(property);
			return property;
		}
	}
	
	
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/userpropsave")
	@ResponseBody
	public ResponseEntity<UserDTO> saveUserToProperty(@RequestBody PropertyDTO dto) {
		System.out.println("inside of saveUserToProperty method in UserController");
		String email = dto.getEmail();
		System.out.println(dto);
		Property property = new Property(dto);
		System.out.println(property);
		UserDTO uDTO = ps.associateUserAndProperty(property, email);
		if(uDTO != null) {
			return ResponseEntity.ok().body(uDTO);
		} else {
			uDTO = null;
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(uDTO);
		}
		
		
//		if(ps.upsert(property) != false) {
//			System.out.println("good creation.. returned true... about to send back a good status with the property in the body");
//			return ResponseEntity.status(HttpStatus.CREATED).body(property);
//		} else {
//			property = null;
//			System.out.println("bad creation??? returned false in services... about to send back a NO_CONTENT status with a null property");
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(property);
//		}
	}
}
