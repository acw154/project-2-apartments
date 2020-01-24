package com.revature.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Preference;
import com.revature.models.PreferenceDTO;
import com.revature.models.UserDTO;
import com.revature.services.PreferenceService;
import com.revature.services.UserService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class PreferenceController {

	private static final Logger logger = LogManager.getLogger(PreferenceController.class);
	
	@Autowired
	 private PreferenceService ps;
	
	
	@PostMapping(value = "/preferences/user")
	public ResponseEntity<Preference> findByEmail(@RequestBody UserDTO dto) {
		String email = dto.getEmail();
		if(ps.findByEmail(email) != null) {
			Preference pref = ps.findByEmail(email);
			return ResponseEntity.ok().body(pref);
		} else {
			Preference pref = null;
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(pref);
		}
	}
	
	
	@PostMapping(value = "/preferences/update")
	public ResponseEntity<Preference> saveOrAddPreference(@RequestBody PreferenceDTO dto) {
		String email = dto.getEmail();
		Preference pref = new Preference(dto);
		if(ps.upsert(pref, email) != null) {
			pref = ps.findByEmail(email);
			return ResponseEntity.status(HttpStatus.CREATED).body(pref);
		} else {
			pref = null;
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(pref);
		}
	}
}
