package com.se.onlinemoviebooking.application.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

@Entity
@Table(name = "booking")
public class BookingDAO implements SimpleDAO {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "bookingid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingID;

	@Column(name = "userid")
	private Long userID;

	@Column(name = "movieid")
	private Long movieID;

	@Column(name = "showid")
	private Long showID;

	@Column(name = "tickets")
	private String tickets;

	@Column(name = "booked_seats")
	private String bookedSeats;

	@Column(name = "promoid")
	private Long promoID;

	@Column(name = "total")
	private Float total;

	@Column(name = "transactionid")
	private Long transactionID;

	@Column(name = "booking_time")
	private LocalDateTime bookingTime;

	public BookingDAO() {
		
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

	public String getTickets() {
		return tickets;
	}

	public String getBookedSeats() {
		return bookedSeats;
	}

	public Long getPromoID() {
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

	public void setTickets(String tickets) {
		this.tickets = tickets;
	}

	public void setBookedSeats(String bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public void setPromoID(Long promoID) {
		this.promoID = promoID;
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
			return daoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	public static BookingDAO getObject(String jsonstr) {
		try {
			return daoMapper.readValue(jsonstr, BookingDAO.class);
		} catch (JsonProcessingException e) {

			return new BookingDAO();
		}
	}

	public static BookingDAO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}

}
