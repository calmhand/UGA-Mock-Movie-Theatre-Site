package com.se.onlinemoviebooking.application.dto;

import java.util.Date;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

public class ShowTimeDTO implements SimpleDTO{
	
	private long showID;
	private long movieID;
	private ShowRoom showRoom;
	private Date showDate;
	private ShowTimeSlot showTimeSlot;
	
	public ShowTimeDTO() {
	}
	
	public ShowTimeDTO(long showID, long movieID, ShowRoom showRoom, Date showDate, ShowTimeSlot showTimeSlot) {
		super();
		this.showID = showID;
		this.movieID = movieID;
		this.showRoom = showRoom;
		this.showDate = showDate;
		this.showTimeSlot = showTimeSlot;
	}
	
	public long getShowID() {
		return showID;
	}
	public long getMovieID() {
		return movieID;
	}
	public ShowRoom getShowRoom() {
		return showRoom;
	}
	public Date getShowDate() {
		return showDate;
	}
	public ShowTimeSlot getShowTimeSlot() {
		return showTimeSlot;
	}
	public void setShowID(long showID) {
		this.showID = showID;
	}
	public void setMovieID(long movieID) {
		this.movieID = movieID;
	}
	public void setShowRoom(ShowRoom showRoom) {
		this.showRoom = showRoom;
	}
	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}
	public void setShowTimeSlot(ShowTimeSlot showTimeSlot) {
		this.showTimeSlot = showTimeSlot;
	}
	
	public String toJSONString() {
		try {
			return dtoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	public static ShowTimeDTO getObject(String jsonstr) {
		try {
			return dtoMapper.readValue(jsonstr, ShowTimeDTO.class);
		} catch (JsonProcessingException e) {

			return new ShowTimeDTO();
		}
	}

	public static ShowTimeDTO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}

}
