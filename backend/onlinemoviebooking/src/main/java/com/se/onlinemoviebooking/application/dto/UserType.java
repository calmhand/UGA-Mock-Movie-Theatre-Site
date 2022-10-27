package com.se.onlinemoviebooking.application.dto;

public enum UserType {

	CUSTOMER(1,"CUSTOMER"),ADMIN(2,"ADMIN"),GUEST(3,"GUEST");
	
	private int id;
	private String name;

	UserType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getID() {
		return this.id;
	}
	
	public static UserType getUserTypeByName(String status) {
		switch (status.trim().toUpperCase()) {
		case "CUSTOMER":
			return UserType.CUSTOMER;
		case "ADMIN":
			return UserType.ADMIN;
		case "GUEST":
			return UserType.GUEST;
		default:
			return UserType.GUEST;
		}
	}

	public static UserType getUserTypeByID(int ID) {
		switch (ID) {
		case 1:
			return UserType.CUSTOMER;
		case 2:
			return UserType.ADMIN;
		case 3:
			return UserType.GUEST;
		default:
			return UserType.GUEST;
		}
	}
}
