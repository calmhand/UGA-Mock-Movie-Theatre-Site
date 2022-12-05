package com.se.onlinemoviebooking.application.dto;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

public class TicketDTO implements SimpleDTO{
	
	private Integer child;
	private Integer adult;
	private Integer senior;
	
	public TicketDTO() {}

	public Integer getChild() {
		return child;
	}

	public Integer getAdult() {
		return adult;
	}

	public Integer getSenior() {
		return senior;
	}

	public void setChild(Integer child) {
		this.child = child;
	}

	public void setAdult(Integer adult) {
		this.adult = adult;
	}

	public void setSenior(Integer senior) {
		this.senior = senior;
	}
	
	public String toJSONString() {
		try {
			return dtoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	public static TicketDTO getObject(String jsonstr) {
		try {
			return dtoMapper.readValue(jsonstr, TicketDTO.class);
		} catch (JsonProcessingException e) {

			return new TicketDTO();
		}
	}

	public static TicketDTO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}

}
