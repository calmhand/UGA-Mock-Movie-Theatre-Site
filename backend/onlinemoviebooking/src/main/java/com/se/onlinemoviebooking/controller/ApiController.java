package com.se.onlinemoviebooking.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.se.onlinemoviebooking.application.api.ApplicationAPIHandler;
import com.se.onlinemoviebooking.application.database.service.UserService;

@RestController
@RequestMapping("/api/onlinemoviebooking")
public class ApiController {

	@Resource(name = "userService")
	private UserService userService;

	@GetMapping("/")
	@ResponseBody
	public String home() {
		return "working";
	}

	@PreAuthorize("hasRole('GUEST') or hasRole('CUSTOMER') or hasRole('ADMIN')")
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "<center><h1>Hello Jay</h1></center>";
	}

	/*
	 * request parameters email
	 * 
	 * flow frontend send this request with email, backend confirms existence of
	 * user email and send a code to his email
	 * 
	 * response {"process":"success", "userID":123}
	 * 
	 * 
	 * frontend if process success redirects to reset password form with fields
	 * email,code,new password else if process failure something went wrong
	 * 
	 */
	@PostMapping(value = "/forgotpassword")
	public JSONObject forgotPassword(HttpServletRequest request, @RequestBody JSONObject payload) {
		return ApplicationAPIHandler.forgotPassword(userService, payload);
	}

	/*
	 * request parameters email,newPassword,code
	 * 
	 * backend verifies code which it sent in email and resets password to
	 * newPassword
	 * 
	 * response parameters {"process":"success"}
	 * 
	 * front end redirect to login page if process success else something went wrong
	 * 
	 */
	@PostMapping(value = "/emailresetpassword")
	public JSONObject resetPassword(HttpServletRequest request, @RequestBody JSONObject payload) {
		return ApplicationAPIHandler.emailResetPassword(userService, payload);
	}

	// todo

	@GetMapping(value = "/{userid}/emailVerify")
	public JSONObject verifyEmail(HttpServletRequest request, @PathVariable Integer userid,
			@RequestParam("code") String code) {
		return ApplicationAPIHandler.verifyEmail(userid, userService, code);
	}

}
