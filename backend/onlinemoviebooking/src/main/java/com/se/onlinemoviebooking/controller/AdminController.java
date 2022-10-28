package com.se.onlinemoviebooking.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "*")
public class AdminController {

	// admin apis : testing

	@GetMapping("/home")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Welcome Admin.";
	}

}
