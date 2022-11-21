package com.se.onlinemoviebooking.application.dto;

public enum MovieRating {
	G("G"), PG("PG"), PG13("PG13"), R("R");
	
	private String name;
	
	MovieRating(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public static MovieRating getMovieRatingByName(String status) {
		switch (status.trim().toUpperCase()) {
		case "G":
			return MovieRating.G;
		case "PG":
			return MovieRating.PG;
		case "PG13":
			return MovieRating.PG13;
		case "R":
			return MovieRating.R;
		default:
			return MovieRating.R;
		}
	}

}
