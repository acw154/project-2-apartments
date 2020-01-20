package com.revature.util;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.revature.models.Preference;

public class APIUtil {
	// Host + Endpoint that we are searching
	private String host = "https://realtor.p.rapidapi.com/properties/list-for-rent";
	// API key
	private String rapid_key = "4fe0fd3c9fmsh916c639381ef0a2p119cb7jsn1b5fefd7545c";
	private String rapid_host = "realtor.p.rapidapi.com";
	private String charset = "UTF-8";
	
	public HttpResponse<JsonNode> getResponse(String query){
		// Where query is a string of format i=%s,...
		HttpResponse<JsonNode> response;
		try {
			response = Unirest.get(host + "?" + query).header("X-RapidAPI-Host", rapid_host)
					.header("X-RapidAPI-Key", rapid_key).asJson();
			return response;
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String createSimpleQuery(Preference p) {
		String sc = p.getState_code();
		String c = p.getCity();
		String query = "state_code=%sc, limit=50, city=%c, offset=0";
		return query;
	}
	
	public String createQueryByPreference(Preference pref) {
		String c = pref.getCity(); 
		String sc = pref.getState_code();
		double min = pref.getMinPrice();
		double max = pref.getMaxPrice();
		double beds = pref.getNumBeds();
		double baths = pref.getNumBaths();
		String p = Boolean.toString(pref.isPets());
		String f = Boolean.toString(pref.isFurnished());
		String query = "state_code=%sc, limit=50, city=%c, offset=0, no_pets_allowed=%p, "
				+ "price_min=%min, price_max=$max, beds_min=%beds, baths_min=%baths";
		return query;
	}

}
