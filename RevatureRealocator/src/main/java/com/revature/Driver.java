package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.PropertyType;
import com.revature.models.User;
import com.revature.models.UserStatus;
import com.revature.services.APIParse;
import com.revature.services.DummyData;
import com.revature.services.PropertyTypeService;
import com.revature.services.UserService;

public class Driver {

//	public static void main(String[] args) {

//		DummyData dummy = new DummyData();
//		String data = dummy.data;
//		APIParse.parse(data);
		
		
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		PropertyTypeService pts = (PropertyTypeService) ac.getBean("propertyTypeService");
//		pts.upsert(new PropertyType(1, "single_family"));
//		pts.upsert(new PropertyType(1, "apartment"));
//		pts.upsert(new PropertyType(1, "condo"));
//		pts.upsert(new PropertyType(1, "townhome"));
//		pts.findAll();
		
//		User u = new User();
//		u.setF_name("Larry");
//		u.setL_name("King");
//		u.setEmail("mail@mail.com");
//		u.setPassword("Password1");
//		
//		UserStatus ust = new UserStatus();
//		ust.setStatus("Looking for roommate");
//		u.setUserStatus(ust);
//		
//		UserService us = (UserService) ac.getBean("userService");
//		us.upsert(u);
//		
//	}
}
