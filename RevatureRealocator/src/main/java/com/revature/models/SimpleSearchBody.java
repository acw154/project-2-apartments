package com.revature.models;

import java.util.Objects;

public class SimpleSearchBody {
	private String state_code;
	private String city;
	public SimpleSearchBody() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SimpleSearchBody(String state_code, String city) {
		super();
		this.state_code = state_code;
		this.city = city;
	}
	public String getState_code() {
		return state_code;
	}
	public void setState_code(String state_code) {
		this.state_code = state_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public int hashCode() {
		return Objects.hash(city, state_code);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof SimpleSearchBody)) {
			return false;
		}
		SimpleSearchBody other = (SimpleSearchBody) obj;
		return Objects.equals(city, other.city) && Objects.equals(state_code, other.state_code);
	}
	@Override
	public String toString() {
		return "SimpleSearchBody [state_code=" + state_code + ", city=" + city + "]";
	}
	
	
}
