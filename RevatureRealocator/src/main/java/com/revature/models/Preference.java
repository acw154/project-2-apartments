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
	
	@Column(name = "min_walk")
	private int minWalk;
	
	@Column(name = "min_bike")
	private int minBike;
	
	@Column(name = "min_transit")
	private int minTransit;
	
	@Column(name = "min_price")
	private double minPrice;
	
	@Column(name = "max_price")
	private double maxPrice;
	
	@Column(name = "num_beds")
	private double numBeds;
	
	@Column(name = "num_baths")
	private double numBaths;
	
	@Column
	private boolean furnished;
	
	@OneToOne(mappedBy = "user_id")
	private User user;

	
	
	// constructors
	
	public Preference() {
		super();
	}



	public Preference(int id, boolean pets, int minWalk, int minBike, int minTransit, double minPrice, double maxPrice,
			double numBeds, double numBaths, boolean furnished, User user) {
		super();
		this.id = id;
		this.pets = pets;
		this.minWalk = minWalk;
		this.minBike = minBike;
		this.minTransit = minTransit;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.numBeds = numBeds;
		this.numBaths = numBaths;
		this.furnished = furnished;
		this.user = user;
	}


	// getters and setters

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



	public int getMinWalk() {
		return minWalk;
	}



	public void setMinWalk(int minWalk) {
		this.minWalk = minWalk;
	}



	public int getMinBike() {
		return minBike;
	}



	public void setMinBike(int minBike) {
		this.minBike = minBike;
	}



	public int getMinTransit() {
		return minTransit;
	}



	public void setMinTransit(int minTransit) {
		this.minTransit = minTransit;
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



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}


	// hashcode + equals

	@Override
	public int hashCode() {
		return Objects.hash(furnished, id, maxPrice, minBike, minPrice, minTransit, minWalk, numBaths, numBeds, pets,
				user);
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
		return furnished == other.furnished && id == other.id
				&& Double.doubleToLongBits(maxPrice) == Double.doubleToLongBits(other.maxPrice)
				&& minBike == other.minBike
				&& Double.doubleToLongBits(minPrice) == Double.doubleToLongBits(other.minPrice)
				&& minTransit == other.minTransit && minWalk == other.minWalk && numBaths == other.numBaths
				&& numBeds == other.numBeds && pets == other.pets && Objects.equals(user, other.user);
	}



	// to string
	
	@Override
	public String toString() {
		return "Preference [id=" + id + ", pets=" + pets + ", minWalk=" + minWalk + ", minBike=" + minBike
				+ ", minTransit=" + minTransit + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice + ", numBeds="
				+ numBeds + ", numBaths=" + numBaths + ", furnished=" + furnished + ", user=" + user + "]";
	}
	
	
	
	
	
	
}
