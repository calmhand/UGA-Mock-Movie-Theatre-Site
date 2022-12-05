package com.se.onlinemoviebooking.application.database.service;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.onlinemoviebooking.application.dao.SeatBookingDAO;
import com.se.onlinemoviebooking.application.database.repository.SeatBookingRepository;
import com.se.onlinemoviebooking.application.dto.SeatBookingDTO;
import com.se.onlinemoviebooking.application.dto.ShowRoom;
import com.se.onlinemoviebooking.application.dto.ShowTimeDTO;
import com.se.onlinemoviebooking.application.utilities.ApplicationStringConstants;

@Service("seatBookingService")
public class DefaultSeatBookingService implements SeatBookingService{
	
	@Autowired
	private SeatBookingRepository seatBookingRepository;
	
	@Autowired
	private ShowTimeService showTimeService;
	
	@Override
	public SeatBookingDAO getSeatBookingDAODetails(Long showid) {
		SeatBookingDAO sb = seatBookingRepository.getSeatBookingDetailByShowId(showid);
		return sb;
	}

	@Override
	public JSONObject getShowSeatDetails(Long showid) {
		
		
		ShowTimeDTO show = showTimeService.getShowTimeDTOById(showid);
		if(show == null) {
			return null;
		}
		
		JSONObject details = new JSONObject();
		SeatBookingDAO sbd = seatBookingRepository.getSeatBookingDetailByShowId(showid);
		String layout = ApplicationStringConstants.SEATLAYOUT;
		layout = layout.replace("\\"+"\"","");
		if(sbd == null) {
			details.put("availableSeats", 40);
			for (String seat: ShowRoom.getSeatIdsAsList()) {
				layout = layout.replace("["+seat+"]", "seat");
			}
			details.put("seatLayout",layout );
		}else {
			details.put("availableSeats", 40 -sbd.getBookedSeats().size() );
			ArrayList<String> booked = sbd.getBookedSeats();
			for (String seat: ShowRoom.getSeatIdsAsList()) {
				if(booked.contains(seat)) {
					layout = layout.replace("["+seat+"]", "seat-sold");
				}else {
					layout = layout.replace("["+seat+"]", "seat");
				}
			}
			details.put("seatLayout",layout );
		}
		
		return details;
	}

	@Override
	public SeatBookingDAO saveShowSeatDetails(SeatBookingDTO sbDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public static SeatBookingDAO populateSeatBookingEntity(SeatBookingDTO seatBooking) {
		SeatBookingDAO sbd = new SeatBookingDAO();
		sbd.setSeatbookingID(seatBooking.getSeatbookingID());
		sbd.setShowID(seatBooking.getShowID());
		sbd.setBookedSeats(seatBooking.getBookedSeats());	
		return sbd;
	}
	
	public static SeatBookingDTO populateSeatBookingEntity(SeatBookingDAO seatBooking) {
		SeatBookingDTO sbd = new SeatBookingDTO();
		sbd.setSeatbookingID(seatBooking.getSeatbookingID());
		sbd.setShowID(seatBooking.getShowID());
		sbd.setBookedSeats(seatBooking.getBookedSeats());	
		return sbd;
	}
	
	
	

}
