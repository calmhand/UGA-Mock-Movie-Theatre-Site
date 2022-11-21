package com.se.onlinemoviebooking.application.database.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;

import com.se.onlinemoviebooking.application.dto.MovieDTO;
import com.se.onlinemoviebooking.application.dto.ShowTimeDTO;

public interface ShowTimeService {
	
	public ShowTimeDTO saveShowTime(ShowTimeDTO showTimeDTO);
	
	public JSONArray getShowTimesByDate(Date date);
	
	public JSONArray getShowTimesByDateAndMovie(Date date, Long movieid);
	
	public JSONArray getShowTimesByMovie(Long movieid);
	
	public Map<String, List<String>> getAvailableShowTimesOnDate(Date date);

}
