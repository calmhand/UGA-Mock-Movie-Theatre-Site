package com.se.onlinemoviebooking.application.database.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.se.onlinemoviebooking.application.dto.ShowTimeDTO;

public interface ShowTimeService {
	
	public JSONObject saveShowTime(ShowTimeDTO showTimeDTO);
	
	public JSONArray getShowTimes();
	
	public JSONArray getShowTimesByDate(Date date);
	
	public JSONArray getShowTimesByDateAndMovie(Date date, Long movieid);
	
	public JSONArray getShowTimesByMovie(Long movieid);
	
	public Map<String, List<String>> getAvailableShowTimesOnDate(Date date);

}
