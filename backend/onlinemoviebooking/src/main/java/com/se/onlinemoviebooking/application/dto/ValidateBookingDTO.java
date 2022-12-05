package com.se.onlinemoviebooking.application.dto;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

public class ValidateBookingDTO implements SimpleDTO {

	private Long userID;
	private Long movieID;
	private Long showID;
	private TicketDTO tickets;
	private List<String> bookedSeats;

	public ValidateBookingDTO() {
		this.bookedSeats = new ArrayList<String>();
	}

	public Long getUserID() {
		return userID;
	}

	public Long getMovieID() {
		return movieID;
	}

	public Long getShowID() {
		return showID;
	}

	public TicketDTO getTickets() {
		return tickets;
	}

	public List<String> getBookedSeats() {
		return bookedSeats;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public void setMovieID(Long movieID) {
		this.movieID = movieID;
	}

	public void setShowID(Long showID) {
		this.showID = showID;
	}

	public void setTickets(TicketDTO tickets) {
		this.tickets = tickets;
	}

	public void setBookedSeats(List<String> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public String toJSONString() {
		try {
			return dtoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	public static ValidateBookingDTO getObject(String jsonstr) {
		try {
			return dtoMapper.readValue(jsonstr, ValidateBookingDTO.class);
		} catch (JsonProcessingException e) {

			return new ValidateBookingDTO();
		}
	}

	public static ValidateBookingDTO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}

}
