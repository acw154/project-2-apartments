package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "user_preferences")
public class Preference implements Serializable{

	
	private static final long serialVersionUID = 8218209785167161460L;

	// fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "preference_id")
	private int id;
	
	@Column
	private boolean pets;
	
	@Column(name = "min_price")
	private double minPrice;
	
	@Column(name = "max_price")
	private double maxPrice;
	
	@Column(name = "num_beds")
	private double numBeds;
	
	@Column(name = "num_baths")
	private double numBaths;
	
	@Column(name="furnished")
	private boolean furnished;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state_code")
	private String state_code;
	
	@OneToOne(mappedBy = "user_id")
	private User user;

	
	
	// constructors
	
	public Preference() {
		super();
	}



	public Preference(int id, boolean pets, double minPrice, double maxPrice, double numBeds, double numBaths,
			boolean furnished, String city, String state_code, User user) {
		super();
		this.id = id;
		this.pets = pets;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.numBeds = numBeds;
		this.numBaths = numBaths;
		this.furnished = furnished;
		this.city = city;
		this.state_code = state_code;
		this.user = user;
	}



	public Preference(boolean pets, double minPrice, double maxPrice, double numBeds, double numBaths,
			boolean furnished, String city, String state_code, User user) {
		super();
		this.pets = pets;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.numBeds = numBeds;
		this.numBaths = numBaths;
		this.furnished = furnished;
		this.city = city;
		this.state_code = state_code;
		this.user = user;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public boolean isPets() {
		return pets;
	}



	public void setPets(boolean pets) {
		this.pets = pets;
	}



	public double getMinPrice() {
		return minPrice;
	}



	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}



	public double getMaxPrice() {
		return maxPrice;
	}



	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}



	public double getNumBeds() {
		return numBeds;
	}



	public void setNumBeds(double numBeds) {
		this.numBeds = numBeds;
	}



	public double getNumBaths() {
		return numBaths;
	}



	public void setNumBaths(double numBaths) {
		this.numBaths = numBaths;
	}



	public boolean isFurnished() {
		return furnished;
	}



	public void setFurnished(boolean furnished) {
		this.furnished = furnished;
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



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public int hashCode() {
		return Objects.hash(city, furnished, id, maxPrice, minPrice, numBaths, numBeds, pets, state_code, user);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Preference)) {
			return false;
		}
		Preference other = (Preference) obj;
		return Objects.equals(city, other.city) && furnished == other.furnished && id == other.id
				&& Double.doubleToLongBits(maxPrice) == Double.doubleToLongBits(other.maxPrice)
				&& Double.doubleToLongBits(minPrice) == Double.doubleToLongBits(other.minPrice)
				&& Double.doubleToLongBits(numBaths) == Double.doubleToLongBits(other.numBaths)
				&& Double.doubleToLongBits(numBeds) == Double.doubleToLongBits(other.numBeds) && pets == other.pets
				&& Objects.equals(state_code, other.state_code) && Objects.equals(user, other.user);
	}



	@Override
	public String toString() {
		return "Preference [id=" + id + ", pets=" + pets + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice
				+ ", numBeds=" + numBeds + ", numBaths=" + numBaths + ", furnished=" + furnished + ", city=" + city
				+ ", state_code=" + state_code + ", user=" + user + "]";
	}


	
	
}
