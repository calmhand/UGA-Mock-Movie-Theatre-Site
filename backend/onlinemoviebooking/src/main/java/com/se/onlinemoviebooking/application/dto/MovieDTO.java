package com.se.onlinemoviebooking.application.dto;



import java.util.Date;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

public class MovieDTO implements SimpleDTO {

	private Long movieID;
	private String title;
	private MovieCategory category;
	private MovieRating rating;
	private Date releaseDate;
	private String director;
	private String producer;
	private String cast; //for now lets keep as string
	private String synopsis;
	private String posterURL;
	private String trailerURL;

	public MovieDTO() {
	}

	public String getTitle() {
		return title;
	}

	public MovieCategory getCategory() {
		return category;
	}

	public MovieRating getRating() {
		return rating;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public String getDirector() {
		return director;
	}

	public String getProducer() {
		return producer;
	}

	public String getCast() {
		return cast;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public String getPosterURL() {
		return posterURL;
	}

	public String getTrailerURL() {
		return trailerURL;
	}

	public Long getMovieID() {
		return movieID;
	}

	public void setMovieID(Long movieID) {
		this.movieID = movieID;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(MovieCategory category) {
		this.category = category;
	}

	public void setRating(MovieRating rating) {
		this.rating = rating;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public void setPosterURL(String posterURL) {
		this.posterURL = posterURL;
	}

	public void setTrailerURL(String trailerURL) {
		this.trailerURL = trailerURL;
	}
	
	public String toJSONString() {
		try {
			return dtoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	public static MovieDTO getObject(String jsonstr) {
		try {
			return dtoMapper.readValue(jsonstr, MovieDTO.class);
		} catch (JsonProcessingException e) {

			return new MovieDTO();
		}
	}

	public static MovieDTO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}

}
