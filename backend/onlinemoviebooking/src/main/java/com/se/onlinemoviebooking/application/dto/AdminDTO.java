package com.se.onlinemoviebooking.application.dto;

public class AdminDTO extends UserDTO{
	
	private UserType userType;
	
	public AdminDTO() {
		super();
		this.userType = UserType.ADMIN;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}
