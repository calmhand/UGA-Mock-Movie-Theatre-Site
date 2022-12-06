package com.se.onlinemoviebooking.application.database.service;

import java.time.format.DateTimeFormatter;
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
	
	@Autowired
	private MovieService mService;
	
	@Autowired
	private ShowTimeService sService;
	
	@Autowired
	private PromotionService pService;
	
	@Autowired
	private TransactionService tService;

	@Override
	public BookingDTO saveBooking(BookingDTO bookingDTO) {
		BookingDAO bookingRow = populateBookingEntity(bookingDTO);
		System.out.println(bookingRow.toJSONString());
		return populateBookingData(bookingRepository.save(bookingRow));
	}

	@Override
	public JSONArray getBookingsOfuser(Long userID) {
		List<BookingDAO> bookings = new ArrayList<BookingDAO>();
		bookings = bookingRepository.getBookingsByuser(userID);
		
		
		JSONArray bookingArray = new JSONArray();
		for(BookingDAO each:bookings) {
			bookingArray.add(getRequiredJsonFromBooking(each, mService, sService, pService, tService));
		}	
		return bookingArray;
	}
	
	public static JSONObject getRequiredJsonFromBooking(BookingDAO booking,MovieService mService,ShowTimeService sService,
			PromotionService pService, TransactionService tService) {
		JSONObject obj = new JSONObject();
		JSONParser parser = new JSONParser();
		try {
			obj = (JSONObject) parser.parse(booking.toJSONString());
		} catch (ParseException e) {
			
		}
		BookingDTO bdto = populateBookingData(booking);
		
		obj.put("total", bdto.getTotal());
		obj.put("userID", bdto.getUserID());
		obj.put("bookingID", booking.getBookingID());
		obj.put("bookedSeats", bdto.getBookedSeats());
		obj.put("tickets", bdto.getTickets());
		
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		obj.put("bookingTime", bdto.getBookingTime().format(myFormatObj));
		
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
			obj.put("promotion", promo);
		}else {
			obj.put("promotion", "");
		}
		
		TransactionDTO tr = tService.getTransactionById(booking.getTransactionID());
		JSONObject trans = new JSONObject();
		trans.put("transactionID", tr.getTransactionID());
		trans.put("transactionTime", tr.getTransactionTime().format(myFormatObj));
		trans.put("transactionType", tr.getTransactionType().getName());
		trans.put("transactionDetails", tr.getTransactionDetails());
		trans.put("transactionAmount", tr.getTrasactionAmount());
		trans.put("billingAddress", tr.getBillingAddress());
		
		obj.remove("transactionID");
		obj.put("transaction", trans);
		
		
		return obj;
		
	}
	
	public static BookingDTO populateBookingData(BookingDAO booking) {
		BookingDTO bookingDTO = new BookingDTO();

		bookingDTO.setBookingID(booking.getBookingID());
		bookingDTO.setUserID(booking.getUserID());
		bookingDTO.setMovieID(booking.getMovieID());
		bookingDTO.setShowID(booking.getShowID());
		bookingDTO.setTickets(TicketDTO.getObject(booking.getTickets()));
		
		JSONParser parser = new JSONParser();
		JSONArray jsonarr;
		try {
			jsonarr = (JSONArray) parser.parse(booking.getBookedSeats());
		} catch (ParseException e) {
			jsonarr = new JSONArray();
		}
		
		
		bookingDTO.setBookedSeats(jsonarr);
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
		bookingDAO.setBookedSeats(booking.getBookedSeats().toJSONString());
		bookingDAO.setPromoID(booking.getPromoid());
		bookingDAO.setTotal(booking.getTotal());
		bookingDAO.setTransactionID(booking.getTransactionID());
		bookingDAO.setBookingTime(booking.getBookingTime());
		
		return bookingDAO;
	}

}
