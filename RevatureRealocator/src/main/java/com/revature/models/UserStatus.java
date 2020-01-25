package com.revature.models;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@Entity
@Table
public class UserStatus implements Serializable{

	
	private static final long serialVersionUID = 522133826993898565L;

	
	// fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column
	private String status;
	
	@JsonIgnoreProperties("userStatus")
	@OneToMany(mappedBy = "userStatus", fetch = FetchType.EAGER)
	private Set<User> user;

	
	// constructors
	
	public UserStatus() {
		super();
	}

	public UserStatus(int id, String status, Set<User> user) {
		super();
		this.id = id;
		this.status = status;
		this.user = user;
	}

	public UserStatus(String status) {
		super();
		this.status = status;
	}
	// getters and setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	
	// hashcode + equals
	@Override
	public int hashCode() {
		return Objects.hash(id, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof UserStatus)) {
			return false;
		}
		UserStatus other = (UserStatus) obj;
		return id == other.id && Objects.equals(status, other.status) && Objects.equals(user, other.user);
	}

	
	// to string 
	@Override
	public String toString() {
		return "UserStatus [id=" + id + ", status=" + status + "]";
	}
	
	
	
	
}
