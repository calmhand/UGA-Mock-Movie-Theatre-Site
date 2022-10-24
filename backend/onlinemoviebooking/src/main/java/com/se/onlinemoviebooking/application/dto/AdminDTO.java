package com.se.onlinemoviebooking.application.dto;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

public class AdminDTO extends UserDTO{
	
	private final UserType userType;
	
	public AdminDTO() {
		super();
		this.userType = UserType.ADMIN;
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

	public static AdminDTO getObject(String jsonstr) {
		try {
			return dtoMapper.readValue(jsonstr, AdminDTO.class);
		} catch (JsonProcessingException e) {

			return new AdminDTO();
		}
	}

	public static AdminDTO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}

}
