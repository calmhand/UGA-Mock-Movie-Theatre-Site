package com.se.onlinemoviebooking.application.dto;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

public class TicketPriceDTO implements SimpleDTO{
	
	private float child;
	private float adult;
	private float senior;
	
	public TicketPriceDTO() {}
	
	public float getChild() {
		return child;
	}
	public float getAdult() {
		return adult;
	}
	public float getSenior() {
		return senior;
	}
	public void setChild(float child) {
		this.child = child;
	}
	public void setAdult(float adult) {
		this.adult = adult;
	}
	public void setSenior(float senior) {
		this.senior = senior;
	}
	
	public String toJSONString() {
		try {
			return dtoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}
	
	public static TicketPriceDTO getObject(String jsonstr) {
		try {
			return dtoMapper.readValue(jsonstr, TicketPriceDTO.class);
		} catch (JsonProcessingException e) {

			return new TicketPriceDTO();
		}
	}

	public static TicketPriceDTO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}
	
	

}
