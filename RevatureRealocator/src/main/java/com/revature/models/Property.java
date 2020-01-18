package com.revature.models;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity 
@Table(name="properties")
public class Property implements Serializable{

	private static final long serialVersionUID = 5217316358226596240L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="property_id")
	private int property_id;
	
	@ManyToOne
	@JoinColumn(name="property_type_id", nullable=false, referencedColumnName = "id")
	private PropertyType propertyType;
	
	@Column(name="street_num", nullable=false)
	private int street_num;
	
	@Column(name="street", nullable=false)
	private String street;
	
	@Column(name="city", nullable=false)
	private String city;
	
	@Column(name="zip", nullable=false)
	private int zip;
	
	@Column(name="state", nullable=false)
	private String state;
	
	@Column(name="apt_num")
	private int apt_num;
	
	@Column(name="walk_score")
	private int walk_score;
	
	@Column(name="transit_score")
	private int transit_score;
	
	@Column(name="bike_score")
	private int bike_score;
	
	@Column(name="photo")
	private byte[] photo;
	
	@Column(name="sq_ft")
	private double sq_ft;
	
	@ManyToOne
	@JoinColumn(name="parking_type_id", referencedColumnName = "id")
	private ParkingType parkingType;
	
	@Column(name="revemp_owned", nullable=false)
	private boolean revemp_owned;
	
	@ManyToMany(mappedBy="users") //User owns the Many-To-Many relationship
	private Set<User> users = new HashSet<>();
	
	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Property(int property_id, PropertyType propertyType, int street_num, String street, String city, int zip,
			String state, int apt_num, int walk_score, int transit_score, int bike_score, byte[] photo, double sq_ft,
			ParkingType parkingType, boolean revemp_owned, Set<User> users) {
		super();
		this.property_id = property_id;
		this.propertyType = propertyType;
		this.street_num = street_num;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.apt_num = apt_num;
		this.walk_score = walk_score;
		this.transit_score = transit_score;
		this.bike_score = bike_score;
		this.photo = photo;
		this.sq_ft = sq_ft;
		this.parkingType = parkingType;
		this.revemp_owned = revemp_owned;
		this.users = users;
	}

	public Property(PropertyType propertyType, int street_num, String street, String city, int zip, String state,
			int bike_score, byte[] photo, double sq_ft, ParkingType parkingType, boolean revemp_owned) {
		super();
		this.propertyType = propertyType;
		this.street_num = street_num;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.bike_score = bike_score;
		this.photo = photo;
		this.sq_ft = sq_ft;
		this.parkingType = parkingType;
		this.revemp_owned = revemp_owned;
	}

	public Property(PropertyType propertyType, int street_num, String street, String city, int zip, String state,
			int apt_num, byte[] photo, double sq_ft, ParkingType parkingType, boolean revemp_owned, Set<User> users) {
		super();
		this.propertyType = propertyType;
		this.street_num = street_num;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.apt_num = apt_num;
		this.photo = photo;
		this.sq_ft = sq_ft;
		this.parkingType = parkingType;
		this.revemp_owned = revemp_owned;
		this.users = users;
	}

	public Property(PropertyType propertyType, int street_num, String street, String city, int zip, String state,
			int apt_num, int walk_score, int transit_score, int bike_score, byte[] photo, double sq_ft,
			ParkingType parkingType, boolean revemp_owned, Set<User> users) {
		super();
		this.propertyType = propertyType;
		this.street_num = street_num;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.apt_num = apt_num;
		this.walk_score = walk_score;
		this.transit_score = transit_score;
		this.bike_score = bike_score;
		this.photo = photo;
		this.sq_ft = sq_ft;
		this.parkingType = parkingType;
		this.revemp_owned = revemp_owned;
		this.users = users;
	}

	public int getProperty_id() {
		return property_id;
	}

	public void setProperty_id(int property_id) {
		this.property_id = property_id;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getApt_num() {
		return apt_num;
	}

	public void setApt_num(int apt_num) {
		this.apt_num = apt_num;
	}

	public int getWalk_score() {
		return walk_score;
	}

	public void setWalk_score(int walk_score) {
		this.walk_score = walk_score;
	}

	public int getTransit_score() {
		return transit_score;
	}

	public void setTransit_score(int transit_score) {
		this.transit_score = transit_score;
	}

	public int getBike_score() {
		return bike_score;
	}

	public void setBike_score(int bike_score) {
		this.bike_score = bike_score;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public double getSq_ft() {
		return sq_ft;
	}

	public void setSq_ft(double sq_ft) {
		this.sq_ft = sq_ft;
	}

	public ParkingType getParkingType() {
		return parkingType;
	}

	public void setParkingType(ParkingType parkingType) {
		this.parkingType = parkingType;
	}

	public boolean isRevemp_owned() {
		return revemp_owned;
	}

	public void setRevemp_owned(boolean revemp_owned) {
		this.revemp_owned = revemp_owned;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(photo);
		result = prime * result + Objects.hash(apt_num, bike_score, city, parkingType, propertyType, property_id,
				revemp_owned, sq_ft, state, street, street_num, transit_score, users, walk_score, zip);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Property)) {
			return false;
		}
		Property other = (Property) obj;
		return apt_num == other.apt_num && bike_score == other.bike_score && Objects.equals(city, other.city)
				&& Objects.equals(parkingType, other.parkingType) && Arrays.equals(photo, other.photo)
				&& Objects.equals(propertyType, other.propertyType) && property_id == other.property_id
				&& revemp_owned == other.revemp_owned
				&& Double.doubleToLongBits(sq_ft) == Double.doubleToLongBits(other.sq_ft)
				&& Objects.equals(state, other.state) && Objects.equals(street, other.street)
				&& street_num == other.street_num && transit_score == other.transit_score
				&& Objects.equals(users, other.users) && walk_score == other.walk_score && zip == other.zip;
	}

	@Override
	public String toString() {
		return "Property [property_id=" + property_id + ", propertyType=" + propertyType + ", street_num=" + street_num
				+ ", street=" + street + ", city=" + city + ", zip=" + zip + ", state=" + state + ", apt_num=" + apt_num
				+ ", walk_score=" + walk_score + ", transit_score=" + transit_score + ", bike_score=" + bike_score
				+ ", photo=" + Arrays.toString(photo) + ", sq_ft=" + sq_ft + ", parkingType=" + parkingType
				+ ", revemp_owned=" + revemp_owned + ", users=" + users + "]";
	}



}