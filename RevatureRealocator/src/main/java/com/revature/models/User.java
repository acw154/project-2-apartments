package com.revature.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "users_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@Column(name = "password")
	String password;

	@Column(name = "f_name", nullable = false)
	String f_name;

	@Column(name = "l_name", nullable = false)
	String l_name;

	@Column(name = "email")
	String email;

	@Column(name = "preference_id")
	int preference_id;

	@Column(name = "current_state")
	String current_state;
	
	@ManyToMany
	@JoinTable(name="saved_properties", joinColumns= {@JoinColumn(name="user_id")},
		inverseJoinColumns= {@JoinColumn(name="property_id")})
	private List<Property> savedProperties = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "user_status_id", nullable = false, referencedColumnName = "id")
	private UserStatus userStatus;

	public User() {
		super();
	}

	public User(int id, String password, String f_name, String l_name, String email, int preference_id,
			String current_state, List<Property> savedProperties, UserStatus userStatus) {
		super();
		this.id = id;
		this.password = password;
		this.f_name = f_name;
		this.l_name = l_name;
		this.email = email;
		this.preference_id = preference_id;
		this.current_state = current_state;
		this.savedProperties = savedProperties;
		this.userStatus = userStatus;
	}

	public User(String password, String f_name, String l_name, String email, int preference_id, String current_state,
			UserStatus userStatus) {
		super();
		this.password = password;
		this.f_name = f_name;
		this.l_name = l_name;
		this.email = email;
		this.preference_id = preference_id;
		this.current_state = current_state;
		this.userStatus = userStatus;
	}

	public User(int id, String password, String f_name, String l_name, String email, int preference_id,
			String current_state, UserStatus userStatus) {
		super();
		this.id = id;
		this.password = password;
		this.f_name = f_name;
		this.l_name = l_name;
		this.email = email;
		this.preference_id = preference_id;
		this.current_state = current_state;
		this.userStatus = userStatus;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPreference_id() {
		return preference_id;
	}

	public void setPreference_id(int preference_id) {
		this.preference_id = preference_id;
	}

	public String getCurrent_state() {
		return current_state;
	}

	public void setCurrent_state(String current_state) {
		this.current_state = current_state;
	}

	public List<Property> getSavedProperties() {
		return savedProperties;
	}

	public void setSavedProperties(List<Property> savedProperties) {
		this.savedProperties = savedProperties;
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(current_state, email, f_name, id, l_name, password, preference_id, savedProperties,
				userStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(current_state, other.current_state) && Objects.equals(email, other.email)
				&& Objects.equals(f_name, other.f_name) && id == other.id && Objects.equals(l_name, other.l_name)
				&& Objects.equals(password, other.password) && preference_id == other.preference_id
				&& Objects.equals(savedProperties, other.savedProperties)
				&& Objects.equals(userStatus, other.userStatus);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", f_name=" + f_name + ", l_name=" + l_name + ", email="
				+ email + ", preference_id=" + preference_id + ", current_state=" + current_state + ", savedProperties="
				+ savedProperties + ", userStatus=" + userStatus + "]";
	}
	
	
	
	
	
}
