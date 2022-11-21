package com.se.onlinemoviebooking.application.database.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.onlinemoviebooking.application.dao.MovieDAO;
import com.se.onlinemoviebooking.application.database.repository.MovieRepository;
import com.se.onlinemoviebooking.application.dto.MovieCategory;
import com.se.onlinemoviebooking.application.dto.MovieDTO;
import com.se.onlinemoviebooking.application.dto.MovieRating;

@Service("movieService")
public class DefaultMovieService implements MovieService{
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public JSONArray getMovies() {
		List<MovieDAO> movieList = new ArrayList<MovieDAO>();
		movieList = movieRepository.getAllMovies();
		JSONArray movieArray = new JSONArray();
		movieArray.addAll(movieList);	
		return movieArray;
	}
	
	@Override
	public MovieDTO saveMovie(MovieDTO movieDTO) {
		MovieDAO userRow = populateMovieEntity(movieDTO);
		return populateMovieData(movieRepository.save(userRow));
	}

	@Override
	public MovieDTO updateMovieById(Long movieid, MovieDTO payload) {
		MovieDTO movieDTO = new MovieDTO();
		
		
		movieDTO.setMovieID(movieid);
		movieDTO.setTitle(payload.getTitle() );
		movieDTO.setCategory(payload.getCategory());
		movieDTO.setRating(payload.getRating());
		movieDTO.setReleaseDate(payload.getReleaseDate());
		movieDTO.setDirector(payload.getDirector());
		movieDTO.setProducer(payload.getProducer());
		movieDTO.setCast(payload.getCast());
		movieDTO.setSynopsis(payload.getSynopsis());
		movieDTO.setPosterURL(payload.getPosterURL());
		movieDTO.setTrailerURL(payload.getTrailerURL());
		
		int up = movieRepository.updateMovieDAO(movieDTO.getTitle(), movieDTO.getCategory().getName(), movieDTO.getRating().name(), 
				movieDTO.getReleaseDate(),movieDTO.getDirector(), movieDTO.getProducer(), movieDTO.getCast(), 
				movieDTO.getSynopsis(), movieDTO.getPosterURL(), movieDTO.getTrailerURL(), movieid);
		if(up>0) {
			return movieDTO;
		}
		return new MovieDTO();
	}
	
	public static MovieDAO populateMovieEntity(MovieDTO movieDTO) {
		MovieDAO movieDAO = new MovieDAO();
		
		movieDAO.setTitle(movieDTO.getTitle());
		movieDAO.setCategory(movieDTO.getCategory().getName());
		movieDAO.setRating(movieDTO.getRating().getName());
		movieDAO.setReleaseDate(movieDTO.getReleaseDate());
		movieDAO.setDirector(movieDTO.getDirector());
		movieDAO.setProducer(movieDTO.getProducer());
		movieDAO.setCast(movieDTO.getCast());
		movieDAO.setSynopsis(movieDTO.getSynopsis());
		movieDAO.setPosterURL(movieDTO.getPosterURL());
		movieDAO.setTrailerURL(movieDTO.getTrailerURL());
		
		return movieDAO;
	}
	
	public static MovieDTO populateMovieData(MovieDAO movieDAO) {
		MovieDTO movieDTO = new MovieDTO();
		
		movieDTO.setMovieID(movieDAO.getMovieID());
		movieDTO.setTitle(movieDAO.getTitle());
		movieDTO.setCategory(MovieCategory.getMovieCategoryByName(movieDAO.getCategory()));
		movieDTO.setRating(MovieRating.getMovieRatingByName(movieDAO.getRating()));
		movieDTO.setReleaseDate(movieDAO.getReleaseDate());
		movieDTO.setDirector(movieDAO.getDirector());
		movieDTO.setProducer(movieDAO.getProducer());
		movieDTO.setCast(movieDAO.getCast());
		movieDTO.setSynopsis(movieDAO.getSynopsis());
		movieDTO.setPosterURL(movieDAO.getPosterURL());
		movieDTO.setTrailerURL(movieDAO.getTrailerURL());
		
		
		return movieDTO;
	}


}
