package com.se.onlinemoviebooking.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.onlinemoviebooking.application.api.AdminApiHandler;
import com.se.onlinemoviebooking.application.dto.MovieDTO;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "*")
public class AdminController {

	
	@Resource(name = "adminApiHandler")
	private AdminApiHandler adminApiHandler;

	
	
	@GetMapping("/home")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Welcome home Admin";
	}
	
	@GetMapping("/manage-movies")
	@PreAuthorize("hasRole('ADMIN')")
	public JSONObject getMovies(HttpServletRequest request) {
		return adminApiHandler.getMovies();
	}
	
	@PostMapping("/manage-movies/addmovie")
	@PreAuthorize("hasRole('ADMIN')")
	public JSONObject addMovie(HttpServletRequest request, @RequestBody MovieDTO paylaod) {
		return adminApiHandler.addMovie(paylaod);
	}
	
	@PutMapping("/manage-movies/updatemovie/{movieid}")
	@PreAuthorize("hasRole('ADMIN')")
	public JSONObject updateMovie(HttpServletRequest request, @RequestBody MovieDTO paylaod, @PathVariable Long userid) {
		return adminApiHandler.updateMovie(userid, paylaod);
	}
	
	
	
	@GetMapping("/manage-users")
	@PreAuthorize("hasRole('ADMIN')")
	public String manageUsers() {
		return "Welcome Admin, manage users.";
	}

}
