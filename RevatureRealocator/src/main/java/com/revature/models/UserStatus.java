package com.revature.models;

import java.io.Serializable;
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
	
	@OneToMany(mappedBy = "userStatus")
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
		return Objects.hash(id, status, user);
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
		return "UserStatus [id=" + id + ", status=" + status + ", user=" + user + "]";
	}
	
	
	
	
}
