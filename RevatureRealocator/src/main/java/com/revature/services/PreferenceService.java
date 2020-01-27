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
		System.out.println(" preference p coming into upsert() : \n"+p);
		System.out.println(" email coming into upsert() : \n"+email);
		User user = us.findByEmail(email);
		System.out.println(" user after findByEmail(email): \n"+user);
		Preference current = user.getPreference();
		System.out.println(" current preference from user.getPreference(): \n"+current);
		if(current != null) {
			p.setId(current.getId());
		}
		System.out.println("preference p inserted with current preference's id saved to it: \n"+p);
		user.setPreference(p);
		System.out.println("user after user.setPreference: \n"+user);
		p.setUser(user);
		System.out.println("preference p inserted with user set from p.setUser: \n"+p);
		pdao.upsertPreference(p);
		System.out.println("you have passed pdao.upsertPreference(p)...");
		p = pdao.getPreferenceByUserId(user.getId());
		System.out.println("p = pdao.getPreferenceByUserId(user.getId()).... : \n"+p);
		return p;
	}
}
