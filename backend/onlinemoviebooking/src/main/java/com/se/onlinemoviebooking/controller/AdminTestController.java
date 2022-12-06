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
import com.se.onlinemoviebooking.application.api.ApplicationAPIHandler;
import com.se.onlinemoviebooking.application.dto.MovieDTO;
import com.se.onlinemoviebooking.application.dto.PromotionDTO;

@RestController
@RequestMapping("/api/test/admin")
@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "*")
public class AdminTestController {

	@Resource(name = "applicationAPIHandler")
	private ApplicationAPIHandler applicationAPIHandler;
	
	@Resource(name = "adminApiHandler")
	private AdminApiHandler adminApiHandler;

	
	//movies
	
	@GetMapping("/manage-movies")
	public JSONObject getMovies(HttpServletRequest request) {
		return adminApiHandler.getMovies();
	}

	@PostMapping("/manage-movies/addmovie")
	public JSONObject addMovie(HttpServletRequest request, @RequestBody MovieDTO payload) {
		return adminApiHandler.addMovie(payload);
	}

	@PutMapping("/manage-movies/updatemovie/{movieid}")
	public JSONObject updateMovie(HttpServletRequest request, @RequestBody MovieDTO payload,
			@PathVariable Long movieid) {
		return adminApiHandler.updateMovie(movieid, payload);
	}
	
	
	//shows
	
	@GetMapping("/manage-shows")
	public JSONObject getAllShows(HttpServletRequest request) {
		return adminApiHandler.getAllShows();
	}
	
	@PostMapping("/manage-shows/addshow")
	public JSONObject addShow(HttpServletRequest request, @RequestBody JSONObject payload) {
		return adminApiHandler.addShow(payload);
	}
	
	@GetMapping("/manage-shows/{date}") //  manage-shows/2022-11-21
	public JSONObject getShows(HttpServletRequest request, @PathVariable String date) {
		return adminApiHandler.getShows(date);
	}
	
	@GetMapping("/manage-shows/{movieid}/{date}") //   manage-shows/282/2022-11-21
	public JSONObject getShowsOfMovie(HttpServletRequest request,@PathVariable Long movieid, @PathVariable String date) {
		return adminApiHandler.getShowsByMovieDate(movieid, date);
	}
	
	@GetMapping("/manage-shows/available/{date}") //  manage-shows/available/2022-11-21
	public JSONObject getAvailableShows(HttpServletRequest request, @PathVariable String date) {
		return adminApiHandler.getAvailableShows(date);
	}
	
	@GetMapping("/manage-shows/movie/{movieid}")
	public JSONObject getMovieShows(HttpServletRequest request, @PathVariable Long movieid) {
		return adminApiHandler.getShowsForMovie(movieid);
	}
	
	
	//promotions
	
	@GetMapping("/manage-promotions")
	public JSONObject getPromotions(HttpServletRequest request) {
		return adminApiHandler.getPromotions();
	}
	
	@PostMapping("/manage-promotions/addpromotion")
	public JSONObject addPromotion(HttpServletRequest request, @RequestBody PromotionDTO payload) {
		return adminApiHandler.addPromotion( payload);
	}
	
	@PutMapping("/manage-promotions/updatepromotion/{promoid}")
	public JSONObject updatePromotion(HttpServletRequest request, @RequestBody PromotionDTO payload,
			@PathVariable Long promoid) {
		return adminApiHandler.updatePromotion(promoid, payload);
	}
	
	@GetMapping("/manage-promotions/sendpromotion/{promoid}")
	public JSONObject sendPromotion(HttpServletRequest request,@PathVariable Long promoid) {
		return adminApiHandler.sendPromotions(promoid);
	}
	
	//users
	
	@GetMapping("/manage-users")
	public JSONObject getUsers(HttpServletRequest request) {
		return adminApiHandler.getUsers();
	}
	
	@PutMapping("/manage-users/suspenduser/{userid}")
	public JSONObject suspendUser(HttpServletRequest request, @PathVariable Integer userid) {
		return adminApiHandler.suspendUser(userid);
	}
	
	@PutMapping("/manage-users/activateuser/{userid}")
	public JSONObject activateUser(HttpServletRequest request, @PathVariable Integer userid) {
		return adminApiHandler.activateUser(userid);
	}

	
}
