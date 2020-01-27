package com.revature.models;

import java.util.List;
import java.util.Objects;

public class AdaptiveUser {
	private int id;
	private String email;
	private String password;
	private String f_name;
	private String l_name;
	private PreferenceDTO preference;
	private List<PropertyDTO> savedProperties;
	private String current_state;
	private String status;
	public AdaptiveUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdaptiveUser(int id, String email, String password, String f_name, String l_name, PreferenceDTO preference,
			List<PropertyDTO> savedProperties, String current_state, UserStatus userStatus) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.f_name = f_name;
		this.l_name = l_name;
		this.preference = preference;
		this.savedProperties = savedProperties;
		this.current_state = current_state;
		this.status = userStatus.getStatus();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public PreferenceDTO getPreference() {
		return preference;
	}
	public void setPreference(PreferenceDTO preference) {
		this.preference = preference;
	}
	public List<PropertyDTO> getSavedProperties() {
		return savedProperties;
	}
	public void setSavedProperties(List<PropertyDTO> savedProperties) {
		this.savedProperties = savedProperties;
	}
	public String getCurrent_state() {
		return current_state;
	}
	public void setCurrent_state(String current_state) {
		this.current_state = current_state;
	}
	public String getUserStatus() {
		return status;
	}
	public void setUserStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(current_state, email, f_name, id, l_name, password, preference, savedProperties,
				status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AdaptiveUser)) {
			return false;
		}
		AdaptiveUser other = (AdaptiveUser) obj;
		return Objects.equals(current_state, other.current_state) && Objects.equals(email, other.email)
				&& Objects.equals(f_name, other.f_name) && id == other.id && Objects.equals(l_name, other.l_name)
				&& Objects.equals(password, other.password) && Objects.equals(preference, other.preference)
				&& Objects.equals(savedProperties, other.savedProperties)
				&& Objects.equals(status, other.status);
	}
	@Override
	public String toString() {
		return "AdaptiveUser [id=" + id + ", email=" + email + ", password=" + password + ", f_name=" + f_name
				+ ", l_name=" + l_name + ", preference=" + preference + ", savedProperties=" + savedProperties
				+ ", current_state=" + current_state + ", userStatus=" + status + "]";
	}
	
	
}
