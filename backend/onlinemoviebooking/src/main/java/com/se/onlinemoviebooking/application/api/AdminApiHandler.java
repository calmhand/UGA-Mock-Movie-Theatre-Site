package com.se.onlinemoviebooking.application.api;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.se.onlinemoviebooking.application.database.service.MovieService;
import com.se.onlinemoviebooking.application.dto.MovieDTO;
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

	public static JSONObject successResponse(JSONObject resp) {
		resp.put(ApplicationStringConstants.PROCESS, ApplicationStringConstants.SUCCESS);
		return resp;
	}

	public static JSONObject failureResponse(JSONObject resp) {
		resp.put(ApplicationStringConstants.PROCESS, ApplicationStringConstants.FAILURE);
		return resp;
	}

}
