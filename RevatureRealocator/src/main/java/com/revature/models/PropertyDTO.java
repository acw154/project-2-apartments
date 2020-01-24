package com.revature.models;

import java.util.Objects;

public class PropertyDTO {

	private String type;
	private int street_num;
	private String street;
	private String city;
	private int zip;
	private int apt_num;
	private int num_beds;
	private double num_baths;
	private String photo;
	private double price;
	private boolean revemp_owned;
	private int sq_ft;
	private String state;
	
	
	
	
	public PropertyDTO() {
		super();
	}
	
	public PropertyDTO(String type, int street_num, String street, String city, int zip, int apt_num, int num_beds,
			int num_baths, String photo, double price, boolean revemp_owned, int sq_ft, String state) {
		super();
		this.type = type;
		this.street_num = street_num;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.apt_num = apt_num;
		this.num_beds = num_beds;
		this.num_baths = num_baths;
		this.photo = photo;
		this.price = price;
		this.revemp_owned = revemp_owned;
		this.sq_ft = sq_ft;
		this.state = state;
	}
	
	
	
	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getStreet_num() {
		return street_num;
	}
	public void setStreet_num(int street_num) {
		this.street_num = street_num;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public int getApt_num() {
		return apt_num;
	}
	public void setApt_num(int apt_num) {
		this.apt_num = apt_num;
	}
	public int getNum_beds() {
		return num_beds;
	}
	public void setNum_beds(int num_beds) {
		this.num_beds = num_beds;
	}
	public double getNum_baths() {
		return num_baths;
	}
	public void setNum_baths(int num_baths) {
		this.num_baths = num_baths;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isRevemp_owned() {
		return revemp_owned;
	}
	public void setRevemp_owned(boolean revemp_owned) {
		this.revemp_owned = revemp_owned;
	}
	public int getSq_ft() {
		return sq_ft;
	}
	public void setSq_ft(int sq_ft) {
		this.sq_ft = sq_ft;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apt_num, city, num_baths, num_beds, photo, price, revemp_owned, sq_ft, state, street,
				street_num, type, zip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PropertyDTO)) {
			return false;
		}
		PropertyDTO other = (PropertyDTO) obj;
		return apt_num == other.apt_num && Objects.equals(city, other.city)
				&& Double.doubleToLongBits(num_baths) == Double.doubleToLongBits(other.num_baths)
				&& num_beds == other.num_beds && Objects.equals(photo, other.photo)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& revemp_owned == other.revemp_owned && sq_ft == other.sq_ft && Objects.equals(state, other.state)
				&& Objects.equals(street, other.street) && street_num == other.street_num
				&& Objects.equals(type, other.type) && zip == other.zip;
	}

	@Override
	public String toString() {
		return "PropertyDTO [type=" + type + ", street_num=" + street_num + ", street=" + street + ", city=" + city
				+ ", zip=" + zip + ", apt_num=" + apt_num + ", num_beds=" + num_beds + ", num_baths=" + num_baths
				+ ", photo=" + photo + ", price=" + price + ", revemp_owned=" + revemp_owned + ", sq_ft=" + sq_ft
				+ ", state=" + state + "]";
	}


	
	
	
	
	
	
	
	
	
}
