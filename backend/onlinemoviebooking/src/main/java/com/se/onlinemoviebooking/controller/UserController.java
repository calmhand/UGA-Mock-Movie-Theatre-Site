package com.se.onlinemoviebooking.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.onlinemoviebooking.application.api.ApplicationAPIHandler;
import com.se.onlinemoviebooking.application.database.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Bean
	public PasswordEncoder passwordEncoder1() {
		return new BCryptPasswordEncoder();
	}

	@Resource(name = "userService")
	private UserService userService;

	@PostMapping(value = "/auth/register")
	public JSONObject registerUser(HttpServletRequest request, @RequestBody JSONObject payload) {
		return ApplicationAPIHandler.registerUser(userService, payload, passwordEncoder1());
	}

	@PutMapping(value = "/{userid}/updateprofile")
	public JSONObject updateUserProfile(HttpServletRequest request, @RequestBody JSONObject payload,
			@PathVariable Integer userid) {
		// to-do
		return ApplicationAPIHandler.updateUserProfile(userService, payload);
	}

}
