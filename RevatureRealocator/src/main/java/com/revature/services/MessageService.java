package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;

public class MessageService {
	

	private static List<User> list = new ArrayList<>();
	
	public static List<User> findAll() {
		return list;
	}
	
	public static User upsert(User u) {
		boolean found = false;
		for(int i = 0; i < list.size(); i++) {
			User e = list.get(i);
/*Not sure what to do here ->*/ if(u.getF_name().equals(e.getF_name())) { 
				list.set(i, u);
				found = true;
			}
		}
		
		if(!found) {
			list.add(u);
		}
		
		return u;
	}
	
	public static User delete(int id) {
		User u = list.get(id);
		list.remove(id);
		return u;
	}
}