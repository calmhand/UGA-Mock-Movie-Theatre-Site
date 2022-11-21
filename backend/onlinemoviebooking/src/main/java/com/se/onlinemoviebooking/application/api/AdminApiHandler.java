package com.se.onlinemoviebooking.application.api;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.se.onlinemoviebooking.application.dao.UserDAO;
import com.se.onlinemoviebooking.application.database.service.MovieService;
import com.se.onlinemoviebooking.application.database.service.PromotionService;
import com.se.onlinemoviebooking.application.database.service.UserService;
import com.se.onlinemoviebooking.application.dto.MovieDTO;
import com.se.onlinemoviebooking.application.dto.PromotionDTO;
import com.se.onlinemoviebooking.application.utilities.ApplicationStringConstants;

public class AdminApiHandler {

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
		System.out.println(updated);
		System.out.println((updated.getPromoID()));
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

	public static JSONObject successResponse(JSONObject resp) {
		resp.put(ApplicationStringConstants.PROCESS, ApplicationStringConstants.SUCCESS);
		return resp;
	}

	public static JSONObject failureResponse(JSONObject resp) {
		resp.put(ApplicationStringConstants.PROCESS, ApplicationStringConstants.FAILURE);
		return resp;
	}

}
