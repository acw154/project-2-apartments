package com.revature.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.revature.models.Preference;

@Service
public class APIUtil {
	// Host + Endpoint that we are searching
	private String host = "https://realtor.p.rapidapi.com/properties/list-for-rent";
	// API key
	private String rapid_key = "4fe0fd3c9fmsh916c639381ef0a2p119cb7jsn1b5fefd7545c";
	private String rapid_host = "realtor.p.rapidapi.com";
	private String charset = "UTF-8";
	
	public HttpResponse<String> getResponse(String query){
		// Where query is a string of format i=%s,...
		HttpResponse<String> response;
		try {
			response = Unirest.get(host + "?" + query).header("X-RapidAPI-Host", rapid_host)
					.header("X-RapidAPI-Key", rapid_key).asString();
			return response;
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String createSimpleQuery(Preference p) {
		String sc;
		String c;
		try {
			sc = URLEncoder.encode(p.getState_code(), charset);
			c = URLEncoder.encode(p.getCity(), charset);
			String query = String.format("state_code=%s&limit=50&city=%s&offset=0", sc, c);
			return query;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
	}
	
	public String createSimpleQuery(String state_code, String city) {
		try {
			String sc = URLEncoder.encode(state_code, charset);
			String c = URLEncoder.encode(city, charset);
			String query = String.format("state_code=%s&limit=200&city=%s&offset=0", sc, c);
			return query;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
	}
	
	public String createQueryByPreference(Preference pref) {
		String c, sc;
		double min, max, beds, baths;
		try {
			c = URLEncoder.encode(pref.getCity(), charset);
			sc = URLEncoder.encode(pref.getState_code(), charset);

			min = pref.getMinPrice();
			max = pref.getMaxPrice();
			beds = pref.getNumBeds();
			baths = pref.getNumBaths();
			String query = String.format("state_code=%s&limit=50&city=%s&offset=0&"
					+ "price_min=%.2f&price_max=%.2f&beds_min=%.2f&baths_min=%.2f", sc, c, min, max, beds, baths);
			System.out.println(query);

			return query;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
		
	}

}
