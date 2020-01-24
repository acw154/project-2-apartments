package com.revature.models;

import java.util.Objects;

public class PreferenceDTO {

	private double min_price;
	private double max_price;
	private double num_beds;
	private double num_baths;
	private String city;
	private String state_code;
	
	
	
	public PreferenceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public PreferenceDTO(double min_price, double max_price, double num_beds, double num_baths, String city,
			String state_code) {
		super();
		this.min_price = min_price;
		this.max_price = max_price;
		this.num_beds = num_beds;
		this.num_baths = num_baths;
		this.city = city;
		this.state_code = state_code;
	}



	public double getMin_price() {
		return min_price;
	}



	public void setMin_price(double min_price) {
		this.min_price = min_price;
	}



	public double getMax_price() {
		return max_price;
	}



	public void setMax_price(double max_price) {
		this.max_price = max_price;
	}



	public double getNum_beds() {
		return num_beds;
	}



	public void setNum_beds(double num_beds) {
		this.num_beds = num_beds;
	}



	public double getNum_baths() {
		return num_baths;
	}



	public void setNum_baths(double num_baths) {
		this.num_baths = num_baths;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState_code() {
		return state_code;
	}



	public void setState_code(String state_code) {
		this.state_code = state_code;
	}



	@Override
	public int hashCode() {
		return Objects.hash(city, max_price, min_price, num_baths, num_beds, state_code);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PreferenceDTO)) {
			return false;
		}
		PreferenceDTO other = (PreferenceDTO) obj;
		return Objects.equals(city, other.city)
				&& Double.doubleToLongBits(max_price) == Double.doubleToLongBits(other.max_price)
				&& Double.doubleToLongBits(min_price) == Double.doubleToLongBits(other.min_price)
				&& Double.doubleToLongBits(num_baths) == Double.doubleToLongBits(other.num_baths)
				&& Double.doubleToLongBits(num_beds) == Double.doubleToLongBits(other.num_beds)
				&& Objects.equals(state_code, other.state_code);
	}



	@Override
	public String toString() {
		return "PreferenceDTO [min_price=" + min_price + ", max_price=" + max_price + ", num_beds=" + num_beds
				+ ", num_baths=" + num_baths + ", city=" + city + ", state_code=" + state_code + "]";
	}
	
	
	
	 
	
}
