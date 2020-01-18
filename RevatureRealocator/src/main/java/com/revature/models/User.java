package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	@ManyToOne
	@JoinColumn(name = "user_status_id", nullable = false, referencedColumnName = "id")
	private UserStatus userStatus;

	public User() {
		super();
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

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", f_name=" + f_name + ", l_name=" + l_name + ", email="
				+ email + ", preference_id=" + preference_id + ", current_state=" + current_state + ", userStatus="
				+ userStatus + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((current_state == null) ? 0 : current_state.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((f_name == null) ? 0 : f_name.hashCode());
		result = prime * result + id;
		result = prime * result + ((l_name == null) ? 0 : l_name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + preference_id;
		result = prime * result + ((userStatus == null) ? 0 : userStatus.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (current_state == null) {
			if (other.current_state != null)
				return false;
		} else if (!current_state.equals(other.current_state))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (f_name == null) {
			if (other.f_name != null)
				return false;
		} else if (!f_name.equals(other.f_name))
			return false;
		if (id != other.id)
			return false;
		if (l_name == null) {
			if (other.l_name != null)
				return false;
		} else if (!l_name.equals(other.l_name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (preference_id != other.preference_id)
			return false;
		if (userStatus == null) {
			if (other.userStatus != null)
				return false;
		} else if (!userStatus.equals(other.userStatus))
			return false;
		return true;
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

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}
		
	
	
}
