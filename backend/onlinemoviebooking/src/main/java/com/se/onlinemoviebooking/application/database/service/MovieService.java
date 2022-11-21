package com.se.onlinemoviebooking.application.database.service;

import org.json.simple.JSONArray;

import com.se.onlinemoviebooking.application.dto.MovieDTO;

public interface MovieService {

	public MovieDTO saveMovie(MovieDTO movieDTO);
	
	public MovieDTO updateMovieById(Long movieid, MovieDTO payload);
	
	public JSONArray getMovies();

}
