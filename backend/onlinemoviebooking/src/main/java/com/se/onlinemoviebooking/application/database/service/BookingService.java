package com.se.onlinemoviebooking.application.database.service;

import org.json.simple.JSONArray;

import com.se.onlinemoviebooking.application.dto.BookingDTO;

public interface BookingService {
	
	public BookingDTO saveBooking(BookingDTO bookingDTO);
	
	public JSONArray getBookingsOfuser(Long userID);

}
