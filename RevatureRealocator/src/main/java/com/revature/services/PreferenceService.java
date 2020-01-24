package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Preference;
import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.repositories.PreferencesDAO;

@Service
public class PreferenceService {

	public PreferenceService() {
		super();
	}
	
	public PreferenceService(PreferencesDAO dao) {
		super();
		this.pdao = dao;
	}
	public PreferenceService(PreferencesDAO dao, UserService us) {
		super();
		this.pdao = dao;
		this.us = us;
	}
	
	
	@Autowired
	private PreferencesDAO pdao;
	@Autowired
	private UserService us;
	
	public Preference findByEmail(String emailString) {
		//String emailString = dto.getEmail();
		User user = us.findByEmail(emailString);
		int userId = user.getId();
		Preference p = pdao.getPreferenceByUserId(userId);
		return p;
	}
	
	
	public Preference upsert(Preference p, String email) {
		User user = us.findByEmail(email);
		user.setPreference(p);
		p.setUser(user);
		pdao.upsertPreference(p);
		p = pdao.getPreferenceByUserId(user.getId());
		return p;
	}
}
