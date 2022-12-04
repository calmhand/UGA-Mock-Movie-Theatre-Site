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
import com.se.onlinemoviebooking.application.database.service.PromotionService;
import com.se.onlinemoviebooking.application.database.service.ShowTimeService;
import com.se.onlinemoviebooking.application.database.service.UserService;
import com.se.onlinemoviebooking.application.dto.MovieDTO;
import com.se.onlinemoviebooking.application.dto.PromotionDTO;

@RestController
@RequestMapping("/api/test/admin")
@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "*")
public class AdminTestController {

	@Resource(name = "movieService")
	private MovieService movieService;
	
	@Resource(name = "showTimeService")
	private ShowTimeService showTimeService;
	
	@Resource(name = "promotionService")
	private PromotionService promotionService;
	
	@Resource(name = "userService")
	private UserService userService;

	
	//movies
	
	@GetMapping("/manage-movies")
	public JSONObject getMovies(HttpServletRequest request) {
		return AdminApiHandler.getMovies(movieService);
	}

	@PostMapping("/manage-movies/addmovie")
	public JSONObject addMovie(HttpServletRequest request, @RequestBody MovieDTO payload) {
		return AdminApiHandler.addMovie(movieService, payload);
	}

	@PutMapping("/manage-movies/updatemovie/{movieid}")
	public JSONObject updateMovie(HttpServletRequest request, @RequestBody MovieDTO payload,
			@PathVariable Long movieid) {
		return AdminApiHandler.updateMovie(movieid, movieService, payload);
	}
	
	
	//shows
	
	@GetMapping("/manage-shows")
	public JSONObject getAllShows(HttpServletRequest request) {
		return AdminApiHandler.getAllShows(showTimeService);
	}
	
	@PostMapping("/manage-shows/addshow")
	public JSONObject addShow(HttpServletRequest request, @RequestBody JSONObject payload) {
		return AdminApiHandler.addShow(showTimeService, payload);
	}
	
	@GetMapping("/manage-shows/{date}") //  manage-shows/2022-11-21
	public JSONObject getShows(HttpServletRequest request, @PathVariable String date) {
		return AdminApiHandler.getShows(showTimeService, date);
	}
	
	@GetMapping("/manage-shows/{movieid}/{date}") //   manage-shows/282/2022-11-21
	public JSONObject getShowsOfMovie(HttpServletRequest request,@PathVariable Long movieid, @PathVariable String date) {
		return AdminApiHandler.getShowsByMovieDate(showTimeService, movieid, date);
	}
	
	@GetMapping("/manage-shows/available/{date}") //  manage-shows/available/2022-11-21
	public JSONObject getAvailableShows(HttpServletRequest request, @PathVariable String date) {
		return AdminApiHandler.getAvailableShows(showTimeService, date);
	}
	
	@GetMapping("/manage-shows/movie/{movieid}")
	public JSONObject getMovieShows(HttpServletRequest request, @PathVariable Long movieid) {
		return AdminApiHandler.getShowsForMovie(showTimeService, movieid);
	}
	
	
	//promotions
	
	@GetMapping("/manage-promotions")
	public JSONObject getPromotions(HttpServletRequest request) {
		return AdminApiHandler.getPromotions(promotionService);
	}
	
	@PostMapping("/manage-promotions/addpromotion")
	public JSONObject addMovie(HttpServletRequest request, @RequestBody PromotionDTO payload) {
		return AdminApiHandler.addPromotion(promotionService, payload);
	}
	
	@PutMapping("/manage-promotions/updatepromotion/{promoid}")
	public JSONObject updatePromotion(HttpServletRequest request, @RequestBody PromotionDTO payload,
			@PathVariable Long promoid) {
		return AdminApiHandler.updatePromotion(promoid, promotionService, payload);
	}
	
	@GetMapping("/manage-promotions/sendpromotion/{promoid}")
	public JSONObject sendPromotion(HttpServletRequest request,@PathVariable Long promoid) {
		return AdminApiHandler.sendPromotions(userService, promotionService, promoid);
	}
	
	//users
	
	@GetMapping("/manage-users")
	public JSONObject getUsers(HttpServletRequest request) {
		return AdminApiHandler.getUsers(userService);
	}
	
	@PutMapping("/manage-users/suspenduser/{userid}")
	public JSONObject suspendUser(HttpServletRequest request, @PathVariable Integer userid) {
		return AdminApiHandler.suspendUser(userService, userid);
	}
	
	@PutMapping("/manage-users/activateuser/{userid}")
	public JSONObject activateUser(HttpServletRequest request, @PathVariable Integer userid) {
		return AdminApiHandler.activateUser(userService, userid);
	}

	
}
