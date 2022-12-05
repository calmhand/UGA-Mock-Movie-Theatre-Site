package com.se.onlinemoviebooking.application.database.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.onlinemoviebooking.application.dao.BookingDAO;
import com.se.onlinemoviebooking.application.dao.PromotionDAO;
import com.se.onlinemoviebooking.application.database.repository.BookingRepository;
import com.se.onlinemoviebooking.application.dto.BookingDTO;
import com.se.onlinemoviebooking.application.dto.MovieDTO;
import com.se.onlinemoviebooking.application.dto.TicketDTO;
import com.se.onlinemoviebooking.application.dto.TransactionDTO;

@Service("bookingService")
public class DefaultBookingService implements BookingService{
	
	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public BookingDTO saveBooking(BookingDTO bookingDTO) {
		BookingDAO bookingRow = populateBookingEntity(bookingDTO);
		return populateBookingData(bookingRepository.save(bookingRow));
	}

	@Override
	public JSONArray getBookingsOfuser(Long userID) {
		List<BookingDAO> bookings = new ArrayList<BookingDAO>();
		bookings = bookingRepository.getBookingsByuser(userID);
		DefaultMovieService mService = new DefaultMovieService();
		DefaultShowTimeService sService = new DefaultShowTimeService();
		DefaultPromotionService pService = new DefaultPromotionService();
		DefaultTransactionService tService = new DefaultTransactionService();
		
		JSONArray bookingArray = new JSONArray();
		for(BookingDAO each:bookings) {
			bookingArray.add(getRequiredJsonFromBooking(each, mService, sService, pService, tService));
		}	
		return bookingArray;
	}
	
	public static JSONObject getRequiredJsonFromBooking(BookingDAO booking,DefaultMovieService mService,DefaultShowTimeService sService,
			DefaultPromotionService pService, DefaultTransactionService tService) {
		JSONObject obj = new JSONObject();
		JSONParser parser = new JSONParser();
		try {
			obj = (JSONObject) parser.parse(booking.toJSONString());
		} catch (ParseException e) {
			
		}
		MovieDTO mDAO= mService.getMovieById(booking.getMovieID());
		String movieName = mDAO.getTitle();
		obj.remove("movieID");
		obj.put("movie", movieName);
		
		JSONObject show = sService.getShowTimeById(booking.getShowID());
		obj.remove("showID");
		obj.put("show", show);
		
		
		obj.remove("promoID");
		if(booking.getPromoID()!=null) {
			PromotionDAO promo = pService.getPromotionById(booking.getPromoID());
			obj.put("promotion", promo.toJSONString());
		}else {
			obj.put("promotion", "");
		}
		
		TransactionDTO tr = tService.getTransactionById(booking.getTransactionID());
		obj.remove("transactionID");
		obj.put("transaction", tr);
		
		
		
		return obj;
		
	}
	
	public static BookingDTO populateBookingData(BookingDAO booking) {
		BookingDTO bookingDTO = new BookingDTO();

		bookingDTO.setBookingID(booking.getBookingID());
		bookingDTO.setUserID(booking.getUserID());
		bookingDTO.setMovieID(booking.getMovieID());
		bookingDTO.setShowID(booking.getShowID());
		bookingDTO.setTickets(TicketDTO.getObject(booking.getTickets()));
		bookingDTO.setBookedSeats(booking.getBookedSeats());
		bookingDTO.setPromoid(booking.getPromoID());
		bookingDTO.setTotal(booking.getTotal());
		bookingDTO.setTransactionID(booking.getTransactionID());
		bookingDTO.setBookingTime(booking.getBookingTime());
		
		return bookingDTO;
	}
	
	public static BookingDAO populateBookingEntity(BookingDTO booking) {
		BookingDAO bookingDAO = new BookingDAO();
		
		bookingDAO.setBookingID(booking.getBookingID());
		bookingDAO.setUserID(booking.getUserID());
		bookingDAO.setMovieID(booking.getMovieID());
		bookingDAO.setShowID(booking.getShowID());
		bookingDAO.setTickets(booking.getTickets().toJSONString());
		bookingDAO.setBookedSeats(booking.getBookedSeats());
		bookingDAO.setPromoID(booking.getPromoid());
		bookingDAO.setTotal(booking.getTotal());
		bookingDAO.setTransactionID(booking.getTransactionID());
		bookingDAO.setBookingTime(booking.getBookingTime());
		
		return bookingDAO;
	}

}
