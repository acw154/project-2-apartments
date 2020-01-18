package com.revature.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="parking_type")
public class ParkingType implements Serializable {

	private static final long serialVersionUID = -9077204287380189558L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="parking_type")
	private String parking_type;
	
	@OneToMany(mappedBy="parking_type_id")
	private Set<Property> property;
	
	public ParkingType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParkingType(int id, String parking_type) {
		super();
		this.id = id;
		this.parking_type = parking_type;
		this.property = new HashSet<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParking_type() {
		return parking_type;
	}

	public void setParking_type(String parking_type) {
		this.parking_type = parking_type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, parking_type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ParkingType)) {
			return false;
		}
		ParkingType other = (ParkingType) obj;
		return id == other.id && Objects.equals(parking_type, other.parking_type);
	}

	@Override
	public String toString() {
		return "ParkingType [id=" + id + ", parking_type=" + parking_type + "]";
	}
	
	
	
}
