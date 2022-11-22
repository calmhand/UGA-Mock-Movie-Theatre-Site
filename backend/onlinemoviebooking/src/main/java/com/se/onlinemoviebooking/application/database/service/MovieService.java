package com.se.onlinemoviebooking.application.database.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.se.onlinemoviebooking.application.dto.MovieDTO;

public interface MovieService {

	public MovieDTO saveMovie(MovieDTO movieDTO);
	
	public MovieDTO updateMovieById(Long movieid, MovieDTO payload);
	
	public JSONArray getMovies();
	
	public JSONObject getHomePageMovies();
	
	public JSONArray getMatchedMovies(String name);
	
	public JSONArray getMoviesByGenre(String genre);
	
	public JSONArray getMatchedMoviesByGenre(String name, String genre);

}
