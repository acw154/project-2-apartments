package com.revature.models;

import java.util.Objects;

public class LoginDTO {

	// member fields
	private String email;
	private String password;
	
	// constructors
	public LoginDTO() {
		super();
	}

	public LoginDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	
	// getters and setters 
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	// hashcode and equals
	@Override
	public int hashCode() {
		return Objects.hash(email, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof LoginDTO)) {
			return false;
		}
		LoginDTO other = (LoginDTO) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password);
	}

	
	// to string
	@Override
	public String toString() {
		return "LoginDTO [email=" + email + ", password=" + password + "]";
	}
	
	
	
	
}
