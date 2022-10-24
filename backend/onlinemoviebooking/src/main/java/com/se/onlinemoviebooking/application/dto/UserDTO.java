package com.se.onlinemoviebooking.application.dto;

import org.json.simple.JSONObject;

public class UserDTO implements SimpleDTO {
	
	private Integer userID;
    private String firstName;
    private String lastName;
    private String number;
    private String email;
    private String password;
    private Boolean isSubscribed;
    private AddressDTO address;
    private Status status;
    
    public UserDTO() {
    }
    
    public UserDTO(JSONObject json) {
    	
    }

	public Integer getUserID() {
		return userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNumber() {
		return number;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Boolean getIsSubscribed() {
		return isSubscribed;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public Status getStatus() {
		return status;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setIsSubscribed(Boolean isSubscribed) {
		this.isSubscribed = isSubscribed;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
    

}
