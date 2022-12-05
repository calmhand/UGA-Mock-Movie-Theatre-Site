package com.se.onlinemoviebooking.application.database.service;

import org.json.simple.JSONObject;

import com.se.onlinemoviebooking.application.dao.SeatBookingDAO;
import com.se.onlinemoviebooking.application.dto.SeatBookingDTO;

public interface SeatBookingService {
	
	public JSONObject getShowSeatDetails(Long showid);
	
	public SeatBookingDAO getSeatBookingDAODetails(Long showid);
	
	public SeatBookingDAO saveShowSeatDetails(SeatBookingDTO sbDTO);

}
