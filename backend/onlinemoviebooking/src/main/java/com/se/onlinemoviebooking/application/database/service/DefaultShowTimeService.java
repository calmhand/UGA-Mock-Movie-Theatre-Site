package com.se.onlinemoviebooking.application.database.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.onlinemoviebooking.application.dao.MovieDAO;
import com.se.onlinemoviebooking.application.dao.ShowTimeDAO;
import com.se.onlinemoviebooking.application.database.repository.ShowTimeRepository;
import com.se.onlinemoviebooking.application.dto.ShowRoom;
import com.se.onlinemoviebooking.application.dto.ShowTimeDTO;
import com.se.onlinemoviebooking.application.dto.ShowTimeSlot;
import com.se.onlinemoviebooking.application.dto.TicketPriceDTO;

@Service("showTimeService")
public class DefaultShowTimeService implements ShowTimeService{
	
	@Autowired
	private ShowTimeRepository showTimeRepository;
	
	@Override
	public JSONObject saveShowTime(ShowTimeDTO showTimeDTO) {
		ShowTimeDAO showTimeDAO = populateShowTimeEntity(showTimeDTO); 
		return getJsonFromShowTimeDAO(showTimeRepository.save(showTimeDAO));
	}
	
	@Override
	public JSONObject getShowTimeById(Long showID) {
		ShowTimeDAO show = showTimeRepository.getShowTimeById(showID);
		return getJsonFromShowTimeDAO(show);
	}
	
	@Override
	public ShowTimeDTO getShowTimeDTOById(Long showID) {
		ShowTimeDAO show = showTimeRepository.getShowTimeById(showID);
		return populateShowTimeData(show);
	}
	
	@Override
	public JSONArray getShowTimes() {
		List<ShowTimeDAO> showTimesList = new ArrayList<ShowTimeDAO>();
		showTimesList = showTimeRepository.getAllShowTimes();
		JSONArray showTimesArray = new JSONArray();
		for(ShowTimeDAO std : showTimesList) {
			showTimesArray.add(getJsonFromShowTimeDAO(std));
		}		
		return showTimesArray;
	}

	@Override
	public JSONArray getShowTimesByDate(Date date) {
		List<ShowTimeDAO> showTimesList = new ArrayList<ShowTimeDAO>();
		showTimesList = showTimeRepository.getShowTimesByDate(date);
		JSONArray showTimesArray = new JSONArray();
		for(ShowTimeDAO std : showTimesList) {
			showTimesArray.add(getJsonFromShowTimeDAO(std));
		}		
		return showTimesArray;
	}

	@Override
	public JSONArray getShowTimesByDateAndMovie(Date date, Long movieid) {
		List<ShowTimeDAO> showTimesList = new ArrayList<ShowTimeDAO>();
		showTimesList = showTimeRepository.getShowTimesByDateAndMovie(movieid, date);
		JSONArray showTimesArray = new JSONArray();
		for(ShowTimeDAO std : showTimesList) {
			showTimesArray.add(getJsonFromShowTimeDAO(std));
		}		
		return showTimesArray;
	}

	@Override
	public JSONArray getShowTimesByMovie(Long movieid) {
		List<ShowTimeDAO> showTimesList = new ArrayList<ShowTimeDAO>();
		showTimesList = showTimeRepository.getShowTimesByMovie(movieid);
		JSONArray showTimesArray = new JSONArray();
		for(ShowTimeDAO std : showTimesList) {
			showTimesArray.add(getJsonFromShowTimeDAO(std));
		}		
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
				.remove(ShowTimeSlot.getShowTimeSlotByID(sdao.getShowTimeSlot()).getName());
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
		showTimeDAO.setTicketPrices(showTimeDTO.getTicketPrices().toJSONString());
		return showTimeDAO;
	}
	
	
	public static ShowTimeDTO populateShowTimeData(ShowTimeDAO showTimeDAO) {
		
		ShowTimeDTO showTimeDTO = new ShowTimeDTO();
		showTimeDTO.setShowID(showTimeDAO.getShowID());
		showTimeDTO.setMovieID(showTimeDAO.getMovieID());
		showTimeDTO.setShowRoom(ShowRoom.getShowRoomByID(showTimeDAO.getShowRoom()));
		showTimeDTO.setShowDate(showTimeDAO.getShowDate());
		showTimeDTO.setShowTimeSlot(ShowTimeSlot.getShowTimeSlotByID(showTimeDAO.getShowTimeSlot()));
		showTimeDTO.setTicketPrices(TicketPriceDTO.getObject(showTimeDAO.getTicketPrices()));
		return showTimeDTO;
	}
	
	public static JSONObject getJsonFromShowTimeDAO(ShowTimeDAO showTimeDAO) {
		
		
		//{"showID":1,"movieID":3,"showRoom":"MAX-RELAX","showDate":2022-11-12,"showTimeSlot":"09:00"}
		
		JSONObject showTimeJson = new JSONObject();
		showTimeJson.put("showID", showTimeDAO.getShowID());
		showTimeJson.put("movieID", showTimeDAO.getMovieID());
		showTimeJson.put("showRoom", ShowRoom.getShowRoomByID(showTimeDAO.getShowRoom()).getName());
		showTimeJson.put("showDate", new SimpleDateFormat("yyyy-MM-dd").format(showTimeDAO.getShowDate()));
		showTimeJson.put("showTimeSlot", ShowTimeSlot.getShowTimeSlotByID(showTimeDAO.getShowTimeSlot()).getName());
		JSONParser parser = new JSONParser();
		JSONObject ticketprices;
		try {
			ticketprices = (JSONObject) parser.parse(showTimeDAO.getTicketPrices());
			showTimeJson.put("ticketPrices",ticketprices);
		} catch (ParseException e) {
			showTimeJson.put("ticketPrices",new JSONObject());
		}
		return showTimeJson;
	}
	
}
