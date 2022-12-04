package com.se.onlinemoviebooking.application.dto;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

public class SeatBookingDTO implements SimpleDTO{
	
	//private long seatbookingID;
	private long showID;
	private ArrayList<String> bookedSeats;
	
	public SeatBookingDTO() {
		
	}
	
	public long getShowid() {
		return showID;
	}

	public ArrayList<String> getBookedSeats() {
		return bookedSeats;
	}

	public void setShowid(long showid) {
		this.showID = showid;
	}

	public void setBookedSeats(ArrayList<String> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}


	public String toJSONString() {
		try {
			return dtoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	public static SeatBookingDTO getObject(String jsonstr) {
		try {
			return dtoMapper.readValue(jsonstr, SeatBookingDTO.class);
		} catch (JsonProcessingException e) {

			return new SeatBookingDTO();
		}
	}

	public static SeatBookingDTO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}
	

}
