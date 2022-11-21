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
	
	@Resource(name = "promotionService")
	private PromotionService promotionService;
	
	@Resource(name = "userService")
	private UserService userService;

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

	
}
