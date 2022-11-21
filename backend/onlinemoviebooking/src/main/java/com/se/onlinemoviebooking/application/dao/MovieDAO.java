package com.se.onlinemoviebooking.application.dao;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;

@Entity
@Table(name = "movie")
public class MovieDAO implements SimpleDAO {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "movieid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long movieID;

	@Column(name = "title")
	private String title;

	@Column(name = "category")
	private String category;

	@Column(name = "rating")
	private String rating;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "release_date")
	private Date releaseDate;

	@Column(name = "director")
	private String director;

	@Column(name = "producer")
	private String producer;

	@Column(name = "cast")
	private String cast;

	@Column(name = "synopsis")
	private String synopsis;

	@Column(name = "poster_url")
	private String posterURL;

	@Column(name = "trailer_url")
	private String trailerURL;

	public MovieDAO() {
	}

	public MovieDAO(Long movieID, String title, String category, String rating, Date releaseDate, String director,
			String producer, String cast, String synopsis, String posterURL, String trailerURL) {
		super();
		this.movieID = movieID;
		this.title = title;
		this.category = category;
		this.rating = rating;
		this.releaseDate = releaseDate;
		this.director = director;
		this.producer = producer;
		this.cast = cast;
		this.synopsis = synopsis;
		this.posterURL = posterURL;
		this.trailerURL = trailerURL;
	}

	public Long getMovieID() {
		return movieID;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public String getRating() {
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

	public void setMovieID(Long movieID) {
		this.movieID = movieID;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setRating(String rating) {
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
			return daoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	public static MovieDAO getObject(String jsonstr) {
		try {
			return daoMapper.readValue(jsonstr, MovieDAO.class);
		} catch (JsonProcessingException e) {

			return new MovieDAO();
		}
	}

	public static MovieDAO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}

}
