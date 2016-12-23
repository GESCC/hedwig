package com.gescc.hedwig.vo;

/**
* User VO
* 
* @author geine
* @date 2016.12.22
* @version a
*/
public class User {

	private String email;
	private String password;
	private String phoneNumber;
	
	
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", phoneNumber=" + phoneNumber + "]";
	}
}
