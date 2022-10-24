package com.se.onlinemoviebooking.application.dto;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

public class CustomerDTO extends UserDTO {

	private final UserType userType;

	public CustomerDTO() {
		super();
		this.userType = UserType.CUSTOMER;
	}

	public UserType getUserType() {
		return userType;
	}


	public String toJSONString() {
		try {
			return dtoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	public static CustomerDTO getObject(String jsonstr) {
		try {
			return dtoMapper.readValue(jsonstr, CustomerDTO.class);
		} catch (JsonProcessingException e) {

			return new CustomerDTO();
		}
	}

	public static CustomerDTO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}

}
