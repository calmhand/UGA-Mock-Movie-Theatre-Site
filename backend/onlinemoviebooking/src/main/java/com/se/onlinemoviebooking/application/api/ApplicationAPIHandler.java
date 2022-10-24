package com.se.onlinemoviebooking.application.api;

import org.json.simple.JSONObject;

import com.se.onlinemoviebooking.application.database.service.UserService;
import com.se.onlinemoviebooking.application.dto.CustomerDTO;
import com.se.onlinemoviebooking.application.dto.UserDTO;
import com.se.onlinemoviebooking.application.utilities.ApplicationStringConstants;

public class ApplicationAPIHandler {

	public static JSONObject registerUser(UserService userService, JSONObject payload) {
		// verify details and save
		UserDTO userDTO = new CustomerDTO();

		userService.saveUser(userDTO);
		return new JSONObject();
	}
	
	public static JSONObject updateUserProfile(UserService userService, JSONObject payload) {
		//to-do
		return null;
	}
	
	public static JSONObject successResponse(JSONObject resp) {
		resp.put(ApplicationStringConstants.TYPE, ApplicationStringConstants.SUCCESS);
		return resp;
	}
	
	public static JSONObject failureResponse(JSONObject resp) {
		resp.put(ApplicationStringConstants.TYPE, ApplicationStringConstants.FAILURE);
		return resp;
	}
}
