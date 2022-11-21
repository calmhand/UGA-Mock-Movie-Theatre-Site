package com.se.onlinemoviebooking.application.database.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.onlinemoviebooking.application.dao.ShowTimeDAO;
import com.se.onlinemoviebooking.application.database.repository.ShowTimeRepository;
import com.se.onlinemoviebooking.application.dto.ShowRoom;
import com.se.onlinemoviebooking.application.dto.ShowTimeDTO;
import com.se.onlinemoviebooking.application.dto.ShowTimeSlot;

@Service("showTimeService")
public class DefaultShowTimeService implements ShowTimeService{
	
	@Autowired
	private ShowTimeRepository showTimeRepository;
	
	@Override
	public ShowTimeDTO saveShowTime(ShowTimeDTO showTimeDTO) {
		
		return null;
	}

	@Override
	public JSONArray getShowTimesByDate(Date date) {
		List<ShowTimeDAO> showTimesList = new ArrayList<ShowTimeDAO>();
		showTimesList = showTimeRepository.getShowTimesByDate(date);
		JSONArray showTimesArray = new JSONArray();
		showTimesArray.addAll(showTimesList);	
		return showTimesArray;
	}

	@Override
	public JSONArray getShowTimesByDateAndMovie(Date date, Long movieid) {
		List<ShowTimeDAO> showTimesList = new ArrayList<ShowTimeDAO>();
		showTimesList = showTimeRepository.getShowTimesByDateAndMovie(movieid, date);
		JSONArray showTimesArray = new JSONArray();
		showTimesArray.addAll(showTimesList);	
		return showTimesArray;
	}

	@Override
	public JSONArray getShowTimesByMovie(Long movieid) {
		List<ShowTimeDAO> showTimesList = new ArrayList<ShowTimeDAO>();
		showTimesList = showTimeRepository.getShowTimesByMovie(movieid);
		JSONArray showTimesArray = new JSONArray();
		showTimesArray.addAll(showTimesList);	
		return showTimesArray;
	}

	@Override
	public Map<String, List<String>> getAvailableShowTimesOnDate(Date date) {
		Map<String, List<String>> availableShowsMap = populateAllHallsWithSlots();
		List<ShowTimeDAO> showTimesList = new ArrayList<ShowTimeDAO>();
		showTimesList = showTimeRepository.getShowTimesByDate(date);
		
		if(!showTimesList.isEmpty()) {
			for(ShowTimeDAO sdao: showTimesList) {
				availableShowsMap.get(ShowRoom.getShowRoomByID(sdao.getShowRoom()).getName())
				.remove(ShowTimeSlot.getShowRoomByID(sdao.getShowTimeSlot()).getName());
			}
		}
		
		return availableShowsMap;
	}
	
	public static Map<String, List<String>>  populateAllHallsWithSlots() {
		Map<String, List<String>>  availableShowsMap = new HashMap<String, List<String>> ();
		for(ShowRoom showRoom:ShowRoom.values()) {
			availableShowsMap.put(showRoom.getName(), getAllSlots());
		}
		 return availableShowsMap;
	}
	
	public static List<String> getAllSlots(){
		List<String> allSlots = new ArrayList<String>();
		for (ShowTimeSlot slot : ShowTimeSlot.values()) { 
			allSlots.add(slot.getName());
		}
		return allSlots;
	}
	
	public static ShowTimeDAO populateShowTimeEntity(ShowTimeDTO showTimeDTO) {
		ShowTimeDAO showTimeDAO = new ShowTimeDAO();
		
		showTimeDAO.setMovieID(showTimeDTO.getMovieID());
		showTimeDAO.setShowRoom(showTimeDTO.getShowRoom().getId());
		showTimeDAO.setShowDate(showTimeDTO.getShowDate());
		showTimeDAO.setShowTimeSlot(showTimeDTO.getShowTimeSlot().getId());
		
		
		return showTimeDAO;
	}
	
	
	public static ShowTimeDTO populateShowTimeData(ShowTimeDAO showTimeDAO) {
		ShowTimeDTO showTimeDTO = new ShowTimeDTO();
		
		showTimeDTO.setMovieID(showTimeDAO.getMovieID());
		showTimeDTO.setShowRoom(ShowRoom.getShowRoomByID(showTimeDAO.getShowRoom()));
		showTimeDTO.setShowDate(showTimeDTO.getShowDate());
		showTimeDTO.setShowTimeSlot(ShowTimeSlot.getShowRoomByID(showTimeDAO.getShowTimeSlot()));
		
		return showTimeDTO;
	}
	
	


}
