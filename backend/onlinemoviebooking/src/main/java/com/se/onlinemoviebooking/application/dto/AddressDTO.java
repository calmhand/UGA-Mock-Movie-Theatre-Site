package com.se.onlinemoviebooking.application.dto;

public class AddressDTO {

	private String street;
	private String apt;
	private String city;
	private String state;
	private String zipcode;

	public AddressDTO() {
	}

	public String getStreet() {
		return street;
	}

	public String getApt() {
		return apt;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setApt(String apt) {
		this.apt = apt;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
