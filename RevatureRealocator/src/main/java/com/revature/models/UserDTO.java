package com.revature.models;

import java.util.Objects;

public class UserDTO {

	int id;
	String f_name;
	String l_name;
	String 	email;
	String password;
	String user_status;
	String current_state;
	
	
	
	
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(User user) {
		super();
		this.id = user.getId();
		this.f_name = user.getF_name();
		this.l_name = user.getL_name();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.user_status = user.getUserStatus().getStatus();
		this.current_state = user.getCurrent_state();
		
	}
	
	public UserDTO(String f_name, String l_name, String email, String password, String user_status,
			String current_state) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
		this.email = email;
		this.password = password;
		this.user_status = user_status;
		this.current_state = current_state;
	}


	public UserDTO(int id, String f_name, String l_name, String email, String password, String user_status, String current_state) {
		super();
		this.id = id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.email = email;
		this.password = password;
		this.user_status = user_status;
		this.current_state = current_state;
	}
	
	
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	public String getCurrent_state() {
		return current_state;
	}
	public void setCurrent_state(String current_state) {
		this.current_state = current_state;
	}
	@Override
	public int hashCode() {
		return Objects.hash(current_state, email, f_name, l_name, password, user_status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof UserDTO)) {
			return false;
		}
		UserDTO other = (UserDTO) obj;
		return Objects.equals(current_state, other.current_state) && Objects.equals(email, other.email)
				&& Objects.equals(f_name, other.f_name) && Objects.equals(l_name, other.l_name)
				&& Objects.equals(password, other.password) && Objects.equals(user_status, other.user_status);
	}
	@Override
	public String toString() {
		return "UserDTO [f_name=" + f_name + ", l_name=" + l_name + ", email=" + email + ", password=" + password
				+ ", user_status=" + user_status + ", current_state=" + current_state + "]";
	}
	
	
	
	
	
	
}
