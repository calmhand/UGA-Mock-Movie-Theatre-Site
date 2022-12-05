package com.se.onlinemoviebooking.application.dto;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

public class ConfirmBookingDTO implements SimpleDTO{
	
	private Long userID;
	private Long movieID;
	private Long showID;
	private TicketDTO tickets;
	private ArrayList<String> bookedSeats;
	private String promocode;
	private Float total;
	private PayingCardDTO payment;
	
	public ConfirmBookingDTO() {
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



	public ArrayList<String> getBookedSeats() {
		return bookedSeats;
	}



	public String getPromocode() {
		return promocode;
	}



	public Float getTotal() {
		return total;
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



	public void setBookedSeats(ArrayList<String> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}



	public void setPromocode(String promocode) {
		this.promocode = promocode;
	}



	public void setTotal(Float total) {
		this.total = total;
	}



	public PayingCardDTO getPayment() {
		return payment;
	}



	public void setPayment(PayingCardDTO payment) {
		this.payment = payment;
	}



	public String toJSONString() {
		try {
			return dtoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	public static ConfirmBookingDTO getObject(String jsonstr) {
		try {
			return dtoMapper.readValue(jsonstr, ConfirmBookingDTO.class);
		} catch (JsonProcessingException e) {

			return new ConfirmBookingDTO();
		}
	}

	public static ConfirmBookingDTO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}
}
