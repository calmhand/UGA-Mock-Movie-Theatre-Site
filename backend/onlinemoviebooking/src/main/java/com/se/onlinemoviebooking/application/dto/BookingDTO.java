package com.se.onlinemoviebooking.application.dto;

import java.time.LocalDateTime;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

public class BookingDTO implements SimpleDTO{
	
	private Long bookingID;
	private Long userID;
	private Long movieID;
	private Long showID;
	private TicketDTO tickets;
	private JSONArray bookedSeats;
	private Long promoID;
	private Float total;
	private Long transactionID;
	private LocalDateTime bookingTime;
	
	public BookingDTO() {
		
	}

	public Long getBookingID() {
		return bookingID;
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

	public JSONArray getBookedSeats() {
		return bookedSeats;
	}

	public Long getPromoid() {
		return promoID;
	}

	public Float getTotal() {
		return total;
	}

	public Long getTransactionID() {
		return transactionID;
	}

	public LocalDateTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingID(Long bookingID) {
		this.bookingID = bookingID;
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

	public void setBookedSeats(JSONArray bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public void setPromoid(Long promoid) {
		this.promoID = promoid;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public void setTransactionID(Long transactionID) {
		this.transactionID = transactionID;
	}

	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}
	
	public String toJSONString() {
		try {
			return dtoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	public static BookingDTO getObject(String jsonstr) {
		try {
			return dtoMapper.readValue(jsonstr, BookingDTO.class);
		} catch (JsonProcessingException e) {

			return new BookingDTO();
		}
	}

	public static BookingDTO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}

}
