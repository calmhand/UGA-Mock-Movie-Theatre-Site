package com.se.onlinemoviebooking.application.dto;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

public class AddressDTO implements SimpleDTO{

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
	
	public String toJSONString() {
		try {
			return dtoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}
	
	public static AddressDTO getObject(String jsonstr) {
		try {
			return dtoMapper.readValue(jsonstr, AddressDTO.class);
		} catch (JsonProcessingException e) {

			return new AddressDTO();
		}
	}

	public static AddressDTO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}


}
