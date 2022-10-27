package com.se.onlinemoviebooking.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.onlinemoviebooking.application.api.ApplicationAPIHandler;
import com.se.onlinemoviebooking.application.database.repository.UserRepository;
import com.se.onlinemoviebooking.application.database.service.UserService;
import com.se.onlinemoviebooking.application.dto.JwtResponse;
import com.se.onlinemoviebooking.application.dto.LoginRequest;
import com.se.onlinemoviebooking.application.security.LoginDetails;
import com.se.onlinemoviebooking.application.security.jwt.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	// to-do confirm email in registration,logout
	
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	PasswordEncoder encoder;

	@Resource(name = "userService")
	private UserService userService;

	@PostMapping(value = "/register")
	public JSONObject registerUser(HttpServletRequest request, @RequestBody JSONObject payload) {
		return ApplicationAPIHandler.registerUser(userService, payload, encoder);
	}

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		System.out.println(loginRequest.getPassword());
		System.out.println(loginRequest.getUsername());
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		LoginDetails userDetails = (LoginDetails) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getEmail(), roles));
	}
}
