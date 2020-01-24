package com.revature.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="property_type")
public class PropertyType implements Serializable {
	
	private static final long serialVersionUID = 7411704252555786151L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="type")
	private String type;
	
	@OneToMany(mappedBy="propertyType", fetch = FetchType.EAGER)
	private Set<Property> property;
	
	public PropertyType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
		this.property = new HashSet<>();
	}
	
	public PropertyType(String type) {
		super();
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PropertyType)) {
			return false;
		}
		PropertyType other = (PropertyType) obj;
		return id == other.id && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "PropertyType [id=" + id + ", type=" + type + "]";
	}
	
	
}
