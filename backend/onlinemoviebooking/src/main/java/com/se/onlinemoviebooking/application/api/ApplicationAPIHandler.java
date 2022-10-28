package com.se.onlinemoviebooking.application.api;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.se.onlinemoviebooking.application.cache.SimpleCache;
import com.se.onlinemoviebooking.application.database.service.DefaultPaymentCardService;
import com.se.onlinemoviebooking.application.database.service.UserService;
import com.se.onlinemoviebooking.application.dto.PaymentcardDTO;
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

	public static JSONObject getUserProfile(Integer userID, UserService userService) {

		UserDTO user = userService.getUserDTObyId(userID);
		user.setPassword("");
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

		UserDTO updated = userService.updateUserDTObyId(userID, user);

		JSONObject json = new JSONObject();
		if (updated.getUserID() != null) {
			JSONParser parser = new JSONParser();
			try {
				json = (JSONObject) parser.parse(updated.toJSONString());
			} catch (ParseException e) {
				json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
				return failureResponse(json);
			}

			return successResponse(json);
		}

		return failureResponse(json);
	}

	public static JSONObject updateUserPassword(Integer userID, UserService userService, JSONObject payload) {

		int rec = userService.updateUserPassword(userID, payload);
		if (rec > 0) {
			return successResponse(new JSONObject());
		}

		return failureResponse(new JSONObject());
	}

	public static JSONObject forgotPassword(UserService userService, JSONObject payload) {

		if (payload.get("email") == null || ((String) payload.get("email")).isEmpty()) {
			return failureResponse(new JSONObject());
		}

		UserDTO user = userService.getUserDTObyEmail((String) payload.get("email"));
		if (user == null) {
			return failureResponse(new JSONObject());
		}

		EmailServicehelper.sendPasswordResetCode(user);

		JSONObject resp = new JSONObject();
		resp.put("userID", user.getUserID());
		return successResponse(resp);
	}

	public static JSONObject emailResetPassword(UserService userService, JSONObject payload) {
		int up = userService.resetUserPassword(payload);
		if (up > 0) {
			return successResponse(new JSONObject());
		}
		return failureResponse(new JSONObject());
	}

	public static JSONObject verifyEmail(Integer userID, UserService userService, String code) {
		System.out.println(SimpleCache.getInstance().getCacheMap());
		String key = "EMC_" + userID;
		String val = SimpleCache.getInstance().get(key);
		if (val != null && val.equals(code)) {
			userService.updateUserStatus(userID, Status.ACTIVE);
			return successResponse(new JSONObject());
		}

		JSONObject json = new JSONObject();
		json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.VERIFICATIONFAILED);
		return failureResponse(json);
	}

	public static JSONObject addUserPayment(Integer userID, DefaultPaymentCardService paymentCardService,
			JSONObject payload) {
		PaymentcardDTO paymentcard = PaymentcardDTO.getObject(payload);

		PaymentcardDTO savedCard = paymentCardService.savePaymentCard(paymentcard);

		JSONParser parser = new JSONParser();
		JSONObject json;
		try {
			json = (JSONObject) parser.parse(savedCard.toJSONString());
		} catch (ParseException e) {
			json = new JSONObject();
			json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
			return failureResponse(json);
		}
		return successResponse(json);

	}

	public static List<PaymentcardDTO> getUserPayments(Integer userid, DefaultPaymentCardService paymentCardService) {

		return paymentCardService.getPaymentCards(userid);
	}

	public static JSONObject deleteUserPayment(Integer userid, DefaultPaymentCardService paymentCardService,
			PaymentcardDTO payload) {

		boolean del = paymentCardService.deletePaymentCard(payload.getCardID());
		if (del) {
			return successResponse(new JSONObject());
		}
		return failureResponse(new JSONObject());
	}

	public static JSONObject editUserPayment(Integer userid, DefaultPaymentCardService paymentCardService,
			PaymentcardDTO payload) {

		PaymentcardDTO pcd = paymentCardService.updatePaymentCard(payload, userid);

		JSONObject json = new JSONObject();

		if (pcd.getCardID() == null) {
			return failureResponse(json);
		}

		JSONParser parser = new JSONParser();
		try {
			json = (JSONObject) parser.parse(pcd.toJSONString());
		} catch (ParseException e) {
			json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
			return failureResponse(json);
		}
		return successResponse(json);
	}

	public static JSONObject successResponse(JSONObject resp) {
		resp.put(ApplicationStringConstants.PROCESS, ApplicationStringConstants.SUCCESS);
		return resp;
	}

	public static JSONObject failureResponse(JSONObject resp) {
		resp.put(ApplicationStringConstants.PROCESS, ApplicationStringConstants.FAILURE);
		return resp;
	}

}
