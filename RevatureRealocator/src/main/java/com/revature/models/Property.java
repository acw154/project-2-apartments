package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity 
@Table(name="properties")
public class Property implements Serializable{

	private static final long serialVersionUID = 5217316358226596240L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="property_id")
	private int property_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name="property_type_id", nullable=false, referencedColumnName = "id")
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
	
	@Column(name="num_beds")
	private double num_beds;
	
	@Column(name="num_baths")
	private double num_baths;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="sq_ft")
	private double sq_ft;
	
	@Column(name="pets")
	private boolean pets;
	
	@Column(name="furnished")
	private boolean furnished;
	
	@Column(name="price")
	private double price;
	
	@Column(name="revemp_owned", nullable=false)
	private boolean revemp_owned;
	
	@ManyToMany(fetch = FetchType.EAGER) //User owns the Many-To-Many relationship
	@JoinTable(name="saved_users", joinColumns= {@JoinColumn(name="property_id", referencedColumnName = "property_id")},
	inverseJoinColumns= {@JoinColumn(name="user_id", referencedColumnName = "user_id")})
	private List<User> users = new ArrayList<>();
	
	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Property(int property_id, PropertyType propertyType, int street_num, String street, String city, int zip,
			String state, int apt_num, double num_beds, double num_baths, String photo, double sq_ft, boolean pets,
			boolean furnished, double price, boolean revemp_owned, List<User> users) {
		super();
		this.property_id = property_id;
		this.propertyType = propertyType;
		this.street_num = street_num;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.apt_num = apt_num;
		this.num_beds = num_beds;
		this.num_baths = num_baths;
		this.photo = photo;
		this.sq_ft = sq_ft;
		this.pets = pets;
		this.furnished = furnished;
		this.price = price;
		this.revemp_owned = revemp_owned;
		this.users = users;
	}

	public Property(PropertyType propertyType, int street_num, String street, String city, int zip, String state,
			int apt_num, double num_beds, double num_baths, String photo, double sq_ft, boolean pets, boolean furnished,
			double price, boolean revemp_owned) {
		super();
		this.propertyType = propertyType;
		this.street_num = street_num;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.apt_num = apt_num;
		this.num_beds = num_beds;
		this.num_baths = num_baths;
		this.photo = photo;
		this.sq_ft = sq_ft;
		this.pets = pets;
		this.furnished = furnished;
		this.price = price;
		this.revemp_owned = revemp_owned;
	}

	public Property(PropertyType propertyType, int street_num, String street, String city, int zip, String state,
			double num_beds, double num_baths, String photo, double sq_ft, boolean pets, boolean furnished,
			double price, boolean revemp_owned) {
		super();
		this.propertyType = propertyType;
		this.street_num = street_num;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.num_beds = num_beds;
		this.num_baths = num_baths;
		this.photo = photo;
		this.sq_ft = sq_ft;
		this.pets = pets;
		this.furnished = furnished;
		this.price = price;
		this.revemp_owned = revemp_owned;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public double getSq_ft() {
		return sq_ft;
	}

	public void setSq_ft(double sq_ft) {
		this.sq_ft = sq_ft;
	}

	public boolean isPets() {
		return pets;
	}

	public void setPets(boolean pets) {
		this.pets = pets;
	}

	public boolean isFurnished() {
		return furnished;
	}

	public void setFurnished(boolean furnished) {
		this.furnished = furnished;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public boolean addUser(User u) {
		if(!this.users.contains(u)) {
			this.users.add(u);
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apt_num, city, furnished, num_baths, num_beds, pets, photo, price,
				propertyType, property_id, revemp_owned, sq_ft, state, street, street_num, users, zip);
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
		return apt_num == other.apt_num && Objects.equals(city, other.city) && furnished == other.furnished
				&& Double.doubleToLongBits(num_baths) == Double.doubleToLongBits(other.num_baths)
				&& Double.doubleToLongBits(num_beds) == Double.doubleToLongBits(other.num_beds)
				&& pets == other.pets
				&& Objects.equals(photo, other.photo)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(propertyType, other.propertyType) && property_id == other.property_id
				&& revemp_owned == other.revemp_owned
				&& Double.doubleToLongBits(sq_ft) == Double.doubleToLongBits(other.sq_ft)
				&& Objects.equals(state, other.state) && Objects.equals(street, other.street)
				&& street_num == other.street_num && Objects.equals(users, other.users) && zip == other.zip;
	}

	@Override
	public String toString() {
		return "Property [property_id=" + property_id + ", propertyType=" + propertyType + ", street_num=" + street_num
				+ ", street=" + street + ", city=" + city + ", zip=" + zip + ", state=" + state + ", apt_num=" + apt_num
				+ ", num_beds=" + num_beds + ", num_baths=" + num_baths + ", photo=" + photo + ", sq_ft=" + sq_ft
				+ ", pets=" + pets + ", furnished=" + furnished + ", price=" + price + ", revemp_owned=" + revemp_owned + ", users=" + users + "]";
	}
	

}