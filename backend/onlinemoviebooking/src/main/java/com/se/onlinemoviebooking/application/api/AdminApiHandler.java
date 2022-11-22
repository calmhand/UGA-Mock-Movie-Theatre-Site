package com.se.onlinemoviebooking.application.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.se.onlinemoviebooking.application.dao.UserDAO;
import com.se.onlinemoviebooking.application.database.service.MovieService;
import com.se.onlinemoviebooking.application.database.service.PromotionService;
import com.se.onlinemoviebooking.application.database.service.ShowTimeService;
import com.se.onlinemoviebooking.application.database.service.UserService;
import com.se.onlinemoviebooking.application.dto.MovieDTO;
import com.se.onlinemoviebooking.application.dto.PromotionDTO;
import com.se.onlinemoviebooking.application.dto.ShowRoom;
import com.se.onlinemoviebooking.application.dto.ShowTimeDTO;
import com.se.onlinemoviebooking.application.dto.ShowTimeSlot;
import com.se.onlinemoviebooking.application.utilities.ApplicationStringConstants;

public class AdminApiHandler {
	
	public static JSONObject getAvailableShows(ShowTimeService showTimeService, String date) {
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
	
	public static JSONObject getShows(ShowTimeService showTimeService, String date) {
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
	
	public static JSONObject getShowsForMovie(ShowTimeService showTimeService, Long movieid) {
		JSONObject response = new JSONObject();
		response.put("shows", showTimeService.getShowTimesByMovie(movieid));
		return successResponse(response);
	}
	
	public static JSONObject getAllShows(ShowTimeService showTimeService) {
		JSONObject response = new JSONObject();
		response.put("shows", showTimeService.getShowTimes());
		return successResponse(response);
	}
	
	public static JSONObject getShowsByMovieDate(ShowTimeService showTimeService, Long movieid, String date) {
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
	
	public static JSONObject addShow(ShowTimeService showTimeService, JSONObject payload) {
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
		response = showTimeService.saveShowTime(showTimeDTO);
		return successResponse(response);
	}

	public static JSONObject getMovies(MovieService movieService) {
		JSONObject response = new JSONObject();
		response.put("movies", movieService.getMovies());
		return successResponse(response);
	}

	public static JSONObject addMovie(MovieService movieService, MovieDTO payload) {
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

	public static JSONObject updateMovie(Long movieID, MovieService movieService, MovieDTO payload) {

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
	
	public static JSONObject getPromotions(PromotionService promotionService) {
		JSONObject response = new JSONObject();
		response.put("promotions", promotionService.getPromotions());
		return successResponse(response);
	}
	
	public static JSONObject addPromotion(PromotionService promotionService, PromotionDTO payload) {
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
	
	public static JSONObject updatePromotion(Long promoID, PromotionService promotionService, PromotionDTO payload) {

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
	
	public static JSONObject sendPromotions(UserService userService,PromotionService promotionService, Long promoID) {
		JSONObject response = new JSONObject();
		List<UserDAO> subscribedUsers = userService.getSubscribedUsers();
		for(int i=0; i<subscribedUsers.size();i++) {
			//emails
		}
		boolean updatedPromotion = promotionService.updatePromotionAfterSent(promoID);
		if(updatedPromotion) {
			response.put("totalEmailedUsers", subscribedUsers!=null?subscribedUsers.size():0);
			return successResponse(response);
		}
		
		return failureResponse(response);
	}
	
	public static JSONObject getUsers(UserService userService) {
		JSONObject response = new JSONObject();
		response.put("users", userService.getUsers());
		return successResponse(response);
	}
	
	
	public static JSONObject suspendUser(UserService userService, Integer userID) {
		JSONObject response = new JSONObject();
		
		boolean updated = userService.suspendUser(userID);
		if(updated) {
			return successResponse(response);
		}
		return failureResponse(response);
	}
	
	public static JSONObject activateUser(UserService userService, Integer userID) {
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
