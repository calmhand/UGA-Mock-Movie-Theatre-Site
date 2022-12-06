package com.se.onlinemoviebooking.application.dao;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

@Entity
@Table(name = "seatbooking")
public class SeatBookingDAO implements SimpleDAO {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "seatbookingid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seatbookingID;
	
	@Column(name = "showid")
	private Long showID;
	
	@Column(name = "booked_seats")
	private String bookedSeats;
	
	public SeatBookingDAO() {
		
	}

	public Long getSeatbookingID() {
		return seatbookingID;
	}

	public Long getShowID() {
		return showID;
	}

	public String getBookedSeats() {
		return bookedSeats;
	}

	public void setSeatbookingID(Long seatbookingID) {
		this.seatbookingID = seatbookingID;
	}

	public void setShowID(Long showID) {
		this.showID = showID;
	}

	public void setBookedSeats(String bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
	
	public String toJSONString() {
		try {
			return daoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	public static SeatBookingDAO getObject(String jsonstr) {
		try {
			return daoMapper.readValue(jsonstr, SeatBookingDAO.class);
		} catch (JsonProcessingException e) {

			return new SeatBookingDAO();
		}
	}

	public static SeatBookingDAO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}

}
