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
	public ResponseEntity<PreferenceDTO> findByEmail(@RequestBody UserDTO dto) {
		String email = dto.getEmail();
		if(ps.findByEmail(email) != null) {
			Preference pref = ps.findByEmail(email);
			PreferenceDTO pdto = new PreferenceDTO(pref);
			return ResponseEntity.ok().body(pdto);
		} else {
			PreferenceDTO pref = null;
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(pref);
		}
	}
	
	
	@PostMapping(value = "/preferences/update")
	public ResponseEntity<PreferenceDTO> saveOrAddPreference(@RequestBody PreferenceDTO dto) {
		String email = dto.getEmail();
		Preference pref = new Preference(dto);
		if(ps.upsert(pref, email) != null) {
			pref = ps.findByEmail(email);
			PreferenceDTO pdto = new PreferenceDTO(pref);
			return ResponseEntity.status(HttpStatus.CREATED).body(pdto);
		} else {
			PreferenceDTO pdto = null;
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(pdto);
		}
	}
}
