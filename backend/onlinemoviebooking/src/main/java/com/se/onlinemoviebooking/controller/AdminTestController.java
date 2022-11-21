package com.se.onlinemoviebooking.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.onlinemoviebooking.application.api.AdminApiHandler;
import com.se.onlinemoviebooking.application.database.service.MovieService;
import com.se.onlinemoviebooking.application.dto.MovieDTO;

@RestController
@RequestMapping("/api/test/admin")
@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "*")
public class AdminTestController {

	@Resource(name = "movieService")
	private MovieService movieService;

	@GetMapping("/manage-movies")
	public JSONObject getMovies(HttpServletRequest request) {
		return AdminApiHandler.getMovies(movieService);
	}

	@PostMapping("/manage-movies/addmovie")
	public JSONObject addMovie(HttpServletRequest request, @RequestBody MovieDTO paylaod) {
		return AdminApiHandler.addMovie(movieService, paylaod);
	}

	@PutMapping("/manage-movies/updatemovie/{movieid}")
	public JSONObject updateMovie(HttpServletRequest request, @RequestBody MovieDTO paylaod,
			@PathVariable Long movieid) {
		return AdminApiHandler.updateMovie(movieid, movieService, paylaod);
	}

}
