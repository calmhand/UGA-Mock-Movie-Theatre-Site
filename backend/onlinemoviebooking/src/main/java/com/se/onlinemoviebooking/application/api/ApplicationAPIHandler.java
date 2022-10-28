package com.se.onlinemoviebooking.application.api;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.se.onlinemoviebooking.application.database.service.UserService;
import com.se.onlinemoviebooking.application.dto.CustomerDTO;
import com.se.onlinemoviebooking.application.dto.Status;
import com.se.onlinemoviebooking.application.dto.UserDTO;
import com.se.onlinemoviebooking.application.services.EmailServicehelper;
import com.se.onlinemoviebooking.application.utilities.ApplicationStringConstants;

public class ApplicationAPIHandler {

	/* Registration */

	public static JSONObject registerUser(UserService userService, JSONObject payload, PasswordEncoder encoder) {
		// to-do verify details and save
		UserDTO userDTO = UserDTO.getObject(payload);
		userDTO.setPassword(encoder.encode(userDTO.getPassword()));
		userDTO.setStatus(Status.INACTIVE);
		UserDTO saveduser = userService.saveUser(userDTO);
		
		EmailServicehelper.sendRegisterEmailConfirmation(saveduser);
		
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
	
	public static JSONObject getUserProfile(Integer userID, UserService userService, JSONObject payload) {
		
		UserDTO user = userService.getUserDTObyId(userID);
		
		JSONParser parser = new JSONParser();
		JSONObject json;
		try {
			json = (JSONObject) parser.parse(user.toJSONString());
		} catch (ParseException e) {
			json = new JSONObject();
			json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
			return failureResponse(json);
		}
		return successResponse(json);
	}

	public static JSONObject updateUserProfile(Integer userID, UserService userService, JSONObject payload) {
		
		UserDTO user = UserDTO.getObject(payload);
		
		int rec = userService.updateUserDTObyId(userID, user);
		
		JSONObject json = new JSONObject();
		if(rec>0) {
			return successResponse(json);
		}
		
		return failureResponse(json);
	}

	public static JSONObject updateUserPassword(Integer userID, UserService userService, JSONObject payload) {
		// to-do
		return null;
	}

	public static JSONObject addUserPayment(Integer userID, UserService userService, JSONObject payload) {
		// to-do
		return null;
	}

	public static JSONObject forgotPassword(UserService userService, JSONObject payload) {
		// to-do
		return null;
	}
	
	public static JSONObject emailResetPassword(Integer userID,UserService userService, JSONObject payload) {
		// to-do
		return null;
	}
	
	public static JSONObject verifyEmail(Integer userID,UserService userService, JSONObject payload) {
		// to-do
		return null;
	}
	
	
	
	public static JSONObject confirmEmail(Integer userID, UserService userService, JSONObject payload) {
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

	/* update profile */

	/* add payment card */

	/* forgot password */
}
