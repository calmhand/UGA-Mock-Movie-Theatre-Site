package com.se.onlinemoviebooking.application.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.onlinemoviebooking.application.dao.PromotionDAO;
import com.se.onlinemoviebooking.application.dao.UserDAO;
import com.se.onlinemoviebooking.application.database.service.BookingService;
import com.se.onlinemoviebooking.application.database.service.DefaultPaymentCardService;
import com.se.onlinemoviebooking.application.database.service.MovieService;
import com.se.onlinemoviebooking.application.database.service.PromotionService;
import com.se.onlinemoviebooking.application.database.service.SeatBookingService;
import com.se.onlinemoviebooking.application.database.service.ShowTimeService;
import com.se.onlinemoviebooking.application.database.service.TransactionService;
import com.se.onlinemoviebooking.application.database.service.UserService;
import com.se.onlinemoviebooking.application.dto.MovieDTO;
import com.se.onlinemoviebooking.application.dto.PromotionDTO;
import com.se.onlinemoviebooking.application.dto.ShowRoom;
import com.se.onlinemoviebooking.application.dto.ShowTimeDTO;
import com.se.onlinemoviebooking.application.dto.ShowTimeSlot;
import com.se.onlinemoviebooking.application.dto.TicketPriceDTO;
import com.se.onlinemoviebooking.application.services.EmailServicehelper;
import com.se.onlinemoviebooking.application.utilities.ApplicationStringConstants;

@Service("adminApiHandler")
public class AdminApiHandler {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private ShowTimeService showTimeService;
	
	@Autowired
	private PromotionService promotionService;
	
	public JSONObject getAvailableShows( String date) {
		JSONObject response = new JSONObject();
		Date dateParam;
		try {
			dateParam = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (java.text.ParseException e) {
			response.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
			return failureResponse(response);
		}
		response.put("availableShows", showTimeService.getAvailableShowTimesOnDate(dateParam));
		return successResponse(response);
	}
	
	public JSONObject getShows(String date) {
		JSONObject response = new JSONObject();
		Date dateParam;
		try {
			dateParam = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (java.text.ParseException e) {
			response.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
			return failureResponse(response);
		}
		response.put("shows", showTimeService.getShowTimesByDate(dateParam));
		return successResponse(response);
	}
	
	public JSONObject getShowsForMovie(Long movieid) {
		JSONObject response = new JSONObject();
		response.put("shows", showTimeService.getShowTimesByMovie(movieid));
		return successResponse(response);
	}
	
	public JSONObject getAllShows() {
		JSONObject response = new JSONObject();
		response.put("shows", showTimeService.getShowTimes());
		return successResponse(response);
	}
	
	public JSONObject getShowsByMovieDate(Long movieid, String date) {
		JSONObject response = new JSONObject();
		Date dateParam;
		try {
			dateParam = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (java.text.ParseException e) {
			response.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
			return failureResponse(response);
		}
		response.put("shows", showTimeService.getShowTimesByDateAndMovie(dateParam, movieid));
		return successResponse(response);
	}
	
	public JSONObject addShow(JSONObject payload) {
		JSONObject response = new JSONObject();
		
		//{"showID":1,"movieID":3,"showRoom":"MAX-RELAX","showDate":2022-11-12,"showTimeSlot":"09:00"}
		
		ShowTimeDTO showTimeDTO = new ShowTimeDTO();
		showTimeDTO.setMovieID(new Long((int)payload.get("movieID")));
		showTimeDTO.setShowRoom(ShowRoom.getShowRoomByName((String) payload.get("showRoom")));
		String date = (String) payload.get("showDate");
		try {
			showTimeDTO.setShowDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
		} catch (java.text.ParseException e) {
			response.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
			return failureResponse(response);
		}
		showTimeDTO.setShowTimeSlot(ShowTimeSlot.getShowTimeSlotByName((String) payload.get("showTimeSlot")));
		JSONObject priceObj =  new JSONObject((Map) payload.get("ticketPrices"));
		showTimeDTO.setTicketPrices(TicketPriceDTO.getObject(priceObj.toJSONString()));
		response = showTimeService.saveShowTime(showTimeDTO);
		return successResponse(response);
	}

	public JSONObject getMovies() {
		JSONObject response = new JSONObject();
		response.put("movies", movieService.getMovies());
		return successResponse(response);
	}

	public JSONObject addMovie(MovieDTO payload) {
		MovieDTO savedMovie = movieService.saveMovie(payload);

		JSONParser parser = new JSONParser();
		JSONObject response;
		try {
			response = (JSONObject) parser.parse(savedMovie.toJSONString());
		} catch (ParseException e) {
			response = new JSONObject();
			response.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
			return failureResponse(response);
		}
		return successResponse(response);
	}

	public JSONObject updateMovie(Long movieID,MovieDTO payload) {

		MovieDTO updated = movieService.updateMovieById(movieID, payload);

		JSONParser parser = new JSONParser();
		JSONObject response;
		try {
			response = (JSONObject) parser.parse(updated.toJSONString());
		} catch (ParseException e) {
			response = new JSONObject();
			response.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
			return failureResponse(response);
		}
		return successResponse(response);
	}
	
	public JSONObject getPromotions() {
		JSONObject response = new JSONObject();
		response.put("promotions", promotionService.getPromotions());
		return successResponse(response);
	}
	
	public JSONObject addPromotion( PromotionDTO payload) {
		PromotionDTO savedPromo = promotionService.savePromotion(payload);

		JSONParser parser = new JSONParser();
		JSONObject response;
		try {
			response = (JSONObject) parser.parse(savedPromo.toJSONString());
		} catch (ParseException e) {
			response = new JSONObject();
			response.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
			return failureResponse(response);
		}
		return successResponse(response);
	}
	
	public JSONObject updatePromotion(Long promoID, PromotionDTO payload) {

		PromotionDTO updated = promotionService.updatePromotionById(promoID, payload);

		JSONParser parser = new JSONParser();
		JSONObject response;
		if(updated.getPromoID() ==null || updated.getPromoID()<1) {
			response = new JSONObject();
			response.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.UPDATEFORBIDDEN);
			return failureResponse(response);
		}
		
		try {
			response = (JSONObject) parser.parse(updated.toJSONString());
		} catch (ParseException e) {
			response = new JSONObject();
			response.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
			return failureResponse(response);
		}
		return successResponse(response);
	}
	
	public JSONObject sendPromotions(Long promoID) {
		PromotionDAO promotion = promotionService.getPromotionById(promoID);
		JSONObject response = new JSONObject();
		List<UserDAO> subscribedUsers = userService.getSubscribedUsers();
		for(UserDAO user:subscribedUsers) {
			EmailServicehelper.sendPromotionEmail(user, promotion); //add seperate thread later
		}
		boolean updatedPromotion = promotionService.updatePromotionAfterSent(promoID);
		if(updatedPromotion) {
			response.put("totalEmailedUsers", subscribedUsers!=null?subscribedUsers.size():0);
			return successResponse(response);
		}
		
		return failureResponse(response);
	}
	
	public JSONObject getUsers() {
		JSONObject response = new JSONObject();
		response.put("users", userService.getUsers());
		return successResponse(response);
	}
	
	
	public JSONObject suspendUser(Integer userID) {
		JSONObject response = new JSONObject();
		
		boolean updated = userService.suspendUser(userID);
		if(updated) {
			return successResponse(response);
		}
		return failureResponse(response);
	}
	
	public JSONObject activateUser(Integer userID) {
		JSONObject response = new JSONObject();
		
		boolean updated = userService.activateUser(userID);
		if(updated) {
			return successResponse(response);
		}
		return failureResponse(response);
	}

	public static JSONObject successResponse(JSONObject resp) {
		resp.put(ApplicationStringConstants.PROCESS, ApplicationStringConstants.SUCCESS);
		return resp;
	}

	public static JSONObject failureResponse(JSONObject resp) {
		resp.put(ApplicationStringConstants.PROCESS, ApplicationStringConstants.FAILURE);
		return resp;
	}

}
