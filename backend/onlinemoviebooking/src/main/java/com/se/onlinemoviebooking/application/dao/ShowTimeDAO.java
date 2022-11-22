package com.se.onlinemoviebooking.application.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

@Entity
@Table(name="showtime")
public class ShowTimeDAO implements SimpleDAO{

	
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "showid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long showID;
	
	@Column(name = "movieid")
	private long movieID;
	
	@Column(name = "showroomid")
	private Integer showRoom;
	
	@Column(name = "show_date")
	private Date showDate;
	
	@Column(name = "show_timeslot")
	private Integer showTimeSlot;
	
	public ShowTimeDAO() {
	}

	public ShowTimeDAO(long showID, long movieID, Integer showRoom, Date showDate, Integer showTimeSlot) {
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

	public Integer getShowRoom() {
		return showRoom;
	}

	public Date getShowDate() {
		return showDate;
	}

	public Integer getShowTimeSlot() {
		return showTimeSlot;
	}

	public void setShowID(long showID) {
		this.showID = showID;
	}

	public void setMovieID(long movieID) {
		this.movieID = movieID;
	}

	public void setShowRoom(Integer showRoom) {
		this.showRoom = showRoom;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public void setShowTimeSlot(Integer showTimeSlot) {
		this.showTimeSlot = showTimeSlot;
	}
	
	public String toJSONString() {
		try {
			return daoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	public static ShowTimeDAO getObject(String jsonstr) {
		try {
			return daoMapper.readValue(jsonstr, ShowTimeDAO.class);
		} catch (JsonProcessingException e) {

			return new ShowTimeDAO();
		}
	}

	public static ShowTimeDAO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}
	
}
