package com.revature;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.revature.models.Property;
import com.revature.util.APIParse;
import com.revature.util.APIUtil;

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
	public static void main(String[] args) {
		APIUtil api = new APIUtil();
		String query = api.createSimpleQuery("VA", "Reston");
		HttpResponse<String> response = api.getResponse(query);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(response.getBody().toString());
		String prettyJsonString = gson.toJson(je);
		List<Property> list = APIParse.parse(prettyJsonString);
		for(Property p: list) {
			System.out.println(p);
		}
	}
//		
//	}
}
