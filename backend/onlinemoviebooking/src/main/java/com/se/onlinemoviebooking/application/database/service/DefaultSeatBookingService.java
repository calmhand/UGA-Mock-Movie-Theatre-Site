package com.se.onlinemoviebooking.application.database.service;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.onlinemoviebooking.application.dao.MovieDAO;
import com.se.onlinemoviebooking.application.dao.SeatBookingDAO;
import com.se.onlinemoviebooking.application.database.repository.SeatBookingRepository;
import com.se.onlinemoviebooking.application.dto.PromotionDTO;
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
	public SeatBookingDTO updateSeatBookingById(Long seatBookingID, SeatBookingDAO payload) {
		
		int up = seatBookingRepository.updateSeatBooking(payload.getBookedSeats(), seatBookingID);
		System.out.println(up);
		if(up>0) {
			return populateSeatBookingData(payload);
		}
		return new SeatBookingDTO();
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
			
			
			JSONParser parser = new JSONParser();
			JSONArray jsonarr;
			try {
				jsonarr = (JSONArray) parser.parse(sbd.getBookedSeats());
			} catch (ParseException e) {
				jsonarr = new JSONArray();
			}
			details.put("availableSeats", 40 -jsonarr.size() );
			
			
			for (String seat: ShowRoom.getSeatIdsAsList()) {
				if(jsonarr.contains(seat)) {
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
	public SeatBookingDTO saveShowSeatDetails(SeatBookingDTO sbDTO) {
		SeatBookingDAO row = populateSeatBookingEntity(sbDTO);
		return populateSeatBookingData(seatBookingRepository.save(row));
	}

	public static SeatBookingDAO populateSeatBookingEntity(SeatBookingDTO seatBooking) {
		SeatBookingDAO sbd = new SeatBookingDAO();
		sbd.setSeatbookingID(seatBooking.getSeatbookingID());
		sbd.setShowID(seatBooking.getShowID());
		sbd.setBookedSeats(seatBooking.getBookedSeats().toJSONString());	
		return sbd;
	}
	
	public static SeatBookingDTO populateSeatBookingData(SeatBookingDAO seatBooking) {
		SeatBookingDTO sbd = new SeatBookingDTO();
		sbd.setSeatbookingID(seatBooking.getSeatbookingID());
		sbd.setShowID(seatBooking.getShowID());
		
		JSONParser parser = new JSONParser();
		JSONArray jsonarr;
		try {
			jsonarr = (JSONArray) parser.parse(seatBooking.getBookedSeats());
		} catch (ParseException e) {
			jsonarr = new JSONArray();
		}
		
		sbd.setBookedSeats(jsonarr);
		return sbd;
	}
	
	
	

}
