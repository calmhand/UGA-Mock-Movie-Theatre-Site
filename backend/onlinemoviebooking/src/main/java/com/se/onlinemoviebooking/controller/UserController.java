package com.se.onlinemoviebooking.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.onlinemoviebooking.application.api.AdminApiHandler;
import com.se.onlinemoviebooking.application.api.ApplicationAPIHandler;
import com.se.onlinemoviebooking.application.dto.PaymentcardDTO;
import com.se.onlinemoviebooking.application.dto.UserDTO;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "*")
public class UserController {

	@Resource(name = "applicationAPIHandler")
	private ApplicationAPIHandler applicationAPIHandler;
	
	@Resource(name = "adminApiHandler")
	private AdminApiHandler adminApiHandler;

	
	
	@GetMapping(value = "/{userid}/getprofile")
	@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
	public JSONObject getUserProfile(HttpServletRequest request, @PathVariable Integer userid) {
		return applicationAPIHandler.getUserProfile(userid);
	}

	@PutMapping(value = "/{userid}/updateprofile")
	@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
	public JSONObject updateUserProfile(HttpServletRequest request, @RequestBody UserDTO payload,
			@PathVariable Integer userid) {
		return applicationAPIHandler.updateUserProfile(userid, payload);
	}

	@PutMapping(value = "/{userid}/resetpassword")
	@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
	public JSONObject updateUserPassword(HttpServletRequest request, @RequestBody JSONObject payload,
			@PathVariable Integer userid) {
		return applicationAPIHandler.updateUserPassword(userid, payload);
	}

	@PostMapping(value = "/{userid}/addpayment")
	@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
	public JSONObject addUserPayment(HttpServletRequest request, @RequestBody JSONObject payload,
			@PathVariable Integer userid) {
		return applicationAPIHandler.addUserPayment(userid, payload);
	}

	@GetMapping(value = "/{userid}/getpaymentCards")
	@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
	public List<PaymentcardDTO> getUserPayments(HttpServletRequest request, @PathVariable Integer userid) {
		return applicationAPIHandler.getUserPayments(userid);
	}

	@PutMapping(value = "/{userid}/editpaymentCard")
	@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
	public JSONObject editUserPayment(HttpServletRequest request, @RequestBody PaymentcardDTO payload,
			@PathVariable Integer userid) {
		return applicationAPIHandler.editUserPayment(userid, payload);
	}

	@DeleteMapping(value = "/{userid}/deletepaymentCard")
	@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
	public JSONObject deleteUserPayment(HttpServletRequest request, @RequestBody PaymentcardDTO payload,
			@PathVariable Integer userid) {
		return applicationAPIHandler.deleteUserPayment(userid, payload);
	}

}
