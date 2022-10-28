package com.se.onlinemoviebooking.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.onlinemoviebooking.application.api.ApplicationAPIHandler;
import com.se.onlinemoviebooking.application.database.service.DefaultPaymentCardService;
import com.se.onlinemoviebooking.application.database.service.UserService;
import com.se.onlinemoviebooking.application.dto.PaymentcardDTO;
import com.se.onlinemoviebooking.application.dto.UserDTO;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "*")
public class UserTestController {

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "paymentCardService")
	private DefaultPaymentCardService paymentCardService;

	@GetMapping(value = "/{userid}/getprofile")
	public JSONObject getUserProfile(HttpServletRequest request,
			@PathVariable Integer userid) {
		return ApplicationAPIHandler.getUserProfile(userid, userService);
	}

	/*
	 * same parameters as register except password,userid,email(field should be
	 * blocked by frontend also ), even sent this wont update
	 * 
	 * response is UserDTO parameters with no password and "process": "success"
	 */

	@PutMapping(value = "/{userid}/updateprofile")
	public JSONObject updateUserProfile(HttpServletRequest request, @RequestBody UserDTO payload,
			@PathVariable Integer userid) {
		return ApplicationAPIHandler.updateUserProfile(userid, userService, payload);
	}

	/* email,password,newPassword */
	/* response is UserDTO parameters with no password and "process": "success" */
	@PostMapping(value = "/{userid}/resetpassword")
	public JSONObject updateUserPassword(HttpServletRequest request, @RequestBody JSONObject payload,
			@PathVariable Integer userid) {
		return ApplicationAPIHandler.updateUserPassword(userid, userService, payload);
	}

	/* paraments are same as in PaymentcardDTO except cardId */
	/*
	 * response is json with "process": "success", PaymentcardDTO fields, no cardId
	 */
	@PostMapping(value = "/{userid}/addpayment")
	public JSONObject addUserPayment(HttpServletRequest request, @RequestBody JSONObject payload,
			@PathVariable Integer userid) {
		return ApplicationAPIHandler.addUserPayment(userid, paymentCardService, payload);
	}

	@GetMapping(value = "/{userid}/getpaymentCards")
	public List<PaymentcardDTO> getUserPayments(HttpServletRequest request, @PathVariable Integer userid) {
		return ApplicationAPIHandler.getUserPayments(userid, paymentCardService);
	}

	@PutMapping(value = "/{userid}/editpaymentCard")
	public JSONObject editUserPayment(HttpServletRequest request, @RequestBody PaymentcardDTO payload,
			@PathVariable Integer userid) {
		return ApplicationAPIHandler.editUserPayment(userid, paymentCardService, payload);
	}

	@DeleteMapping(value = "/{userid}/deletepaymentCard")
	public JSONObject deleteUserPayment(HttpServletRequest request, @RequestBody PaymentcardDTO payload,
			@PathVariable Integer userid) {
		return ApplicationAPIHandler.deleteUserPayment(userid, paymentCardService, payload);
	}

}
