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
import com.se.onlinemoviebooking.application.dto.ConfirmBookingDTO;
import com.se.onlinemoviebooking.application.dto.PaymentcardDTO;
import com.se.onlinemoviebooking.application.dto.UserDTO;
import com.se.onlinemoviebooking.application.dto.ValidateBookingDTO;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "*")
public class UserTestController {

	@Resource(name = "applicationAPIHandler")
	private ApplicationAPIHandler applicationAPIHandler;

	
	//profile
	@GetMapping(value = "/{userid}/getprofile")
	public JSONObject getUserProfile(HttpServletRequest request,
			@PathVariable Integer userid) {
		return applicationAPIHandler.getUserProfile(userid);
	}

	@PutMapping(value = "/{userid}/updateprofile")
	public JSONObject updateUserProfile(HttpServletRequest request, @RequestBody UserDTO payload,
			@PathVariable Integer userid) {
		return applicationAPIHandler.updateUserProfile(userid, payload);
	}

	@PutMapping(value = "/{userid}/resetpassword")
	public JSONObject updateUserPassword(HttpServletRequest request, @RequestBody JSONObject payload,
			@PathVariable Integer userid) {
		return applicationAPIHandler.updateUserPassword(userid, payload);
	}

	
	//paymentcards
	@PostMapping(value = "/{userid}/addpayment")
	public JSONObject addUserPayment(HttpServletRequest request, @RequestBody JSONObject payload,
			@PathVariable Integer userid) {
		return applicationAPIHandler.addUserPayment(userid, payload);
	}

	@GetMapping(value = "/{userid}/getpaymentCards")
	public List<PaymentcardDTO> getUserPayments(HttpServletRequest request, @PathVariable Integer userid) {
		return applicationAPIHandler.getUserPayments(userid);
	}

	@PutMapping(value = "/{userid}/editpaymentCard")
	public JSONObject editUserPayment(HttpServletRequest request, @RequestBody PaymentcardDTO payload,
			@PathVariable Integer userid) {
		return applicationAPIHandler.editUserPayment(userid, payload);
	}

	@DeleteMapping(value = "/{userid}/deletepaymentCard")
	public JSONObject deleteUserPayment(HttpServletRequest request, @RequestBody PaymentcardDTO payload,
			@PathVariable Integer userid) {
		return applicationAPIHandler.deleteUserPayment(userid, payload);
	}
	
	
	//Booking
	@PostMapping(value = "/{userid}/validatebooking")
	public JSONObject validateUserBooking(HttpServletRequest request, @RequestBody ValidateBookingDTO payload,
			@PathVariable Integer userid) {
		return applicationAPIHandler.validateBooking(payload);
	}
	
	@PostMapping(value = "/{userid}/confirmbooking")
	public JSONObject confirmUserBooking(HttpServletRequest request, @RequestBody ConfirmBookingDTO payload,
			@PathVariable Long userid) {
		return applicationAPIHandler.ConfirmBooking(payload);
	}
	
	@GetMapping(value = "/{userid}/getBookings")
	public JSONObject getUserBookings(HttpServletRequest request, @PathVariable Long userid) {
		return applicationAPIHandler.getUserBookings(userid);
	}

}
