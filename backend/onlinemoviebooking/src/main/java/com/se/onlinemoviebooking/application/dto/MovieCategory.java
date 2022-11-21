package com.se.onlinemoviebooking.application.dto;

public enum MovieCategory {
	ACTION("ACTION"), ADVENTURE("ADVENTURE"), COMEDY("COMEDY"), DRAMA("DRAMA"),
	HORROR("HORROR"), ROMANCE("ROMANCE"), SCIENCE_FICTION("SCIENCE_FICTION"), THRILLER("THRILLER"),
	CRIME("CRIME"), OTHER("OTHER");
	
	private String name;
	
	MovieCategory(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public static MovieCategory getMovieCategoryByName(String status) {
		switch (status.trim().toUpperCase()) {
		case "ACTION":
			return MovieCategory.ACTION;
		case "ADVENTURE":
			return MovieCategory.ADVENTURE;
		case "COMEDY":
			return MovieCategory.COMEDY;
		case "DRAMA":
			return MovieCategory.DRAMA;
		case "HORROR":
			return MovieCategory.HORROR;
		case "ROMANCE":
			return MovieCategory.ROMANCE;
		case "SCIENCE_FICTION":
			return MovieCategory.SCIENCE_FICTION;
		case "THRILLER":
			return MovieCategory.THRILLER;
		case "CRIME":
			return MovieCategory.CRIME;
		case "OTHER":
			return MovieCategory.OTHER;
		default:
			return MovieCategory.OTHER;
		}
	}

}
