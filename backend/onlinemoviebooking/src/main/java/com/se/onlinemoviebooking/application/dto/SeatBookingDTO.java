package com.se.onlinemoviebooking.application.dto;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

public class SeatBookingDTO implements SimpleDTO{
	
	//private long seatbookingID;
	private Long seatbookingID;
	private Long showID;
	private JSONArray bookedSeats;
	
	public SeatBookingDTO() {
		
	}
	
	
	
	public Long getSeatbookingID() {
		return seatbookingID;
	}

	public void setSeatbookingID(Long seatBookingID) {
		this.seatbookingID = seatBookingID;
	}

	public Long getShowID() {
		return showID;
	}

	public JSONArray getBookedSeats() {
		return bookedSeats;
	}

	public void setShowID(Long showid) {
		this.showID = showid;
	}

	public void setBookedSeats(JSONArray bookedSeats) {
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
