package com.se.onlinemoviebooking.application.api;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.se.onlinemoviebooking.application.database.service.UserService;
import com.se.onlinemoviebooking.application.dto.CustomerDTO;
import com.se.onlinemoviebooking.application.dto.UserDTO;
import com.se.onlinemoviebooking.application.utilities.ApplicationStringConstants;

public class ApplicationAPIHandler {
	
	
	/*Registration*/

	public static JSONObject registerUser(UserService userService, JSONObject payload) {
		// to-do verify details and save
		CustomerDTO customerDTO = CustomerDTO.getObject(payload);
		UserDTO saveduser = userService.saveUser(customerDTO);
		JSONParser parser = new JSONParser();
		JSONObject json;
		try {
			json = (JSONObject) parser.parse(saveduser.toJSONString());
		} catch (ParseException e) {
			json = new JSONObject();
			json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
			return failureResponse(json);
		}
		return successResponse(json);
	}

	public static JSONObject updateUserProfile(UserService userService, JSONObject payload) {
		// to-do
		return null;
	}

	public static JSONObject successResponse(JSONObject resp) {
		resp.put(ApplicationStringConstants.PROCESS, ApplicationStringConstants.SUCCESS);
		return resp;
	}

	public static JSONObject failureResponse(JSONObject resp) {
		resp.put(ApplicationStringConstants.PROCESS, ApplicationStringConstants.FAILURE);
		return resp;
	}
	
	
	/*login*/
	
	/*logout*/
	
	/*update profile*/
	
	/*add payment card*/
	
	/*forgot password*/
}
