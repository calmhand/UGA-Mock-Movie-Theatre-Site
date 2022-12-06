package com.se.onlinemoviebooking.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.se.onlinemoviebooking.application.api.AdminApiHandler;
import com.se.onlinemoviebooking.application.api.ApplicationAPIHandler;

@RestController
@RequestMapping("/api/onlinemoviebooking")
@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "*")
public class ApiController {

	@Resource(name = "applicationAPIHandler")
	private ApplicationAPIHandler applicationAPIHandler;
	
	@Resource(name = "adminApiHandler")
	private AdminApiHandler adminApiHandler;
	
	
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

	@PostMapping(value = "/forgotpassword")
	public JSONObject forgotPassword(HttpServletRequest request, @RequestBody JSONObject payload) {
		return applicationAPIHandler.forgotPassword(payload);
	}

	@PostMapping(value = "/emailresetpassword")
	public JSONObject resetPassword(HttpServletRequest request, @RequestBody JSONObject payload) {
		return applicationAPIHandler.emailResetPassword(payload);
	}

	@GetMapping(value = "/{userid}/emailVerify")
	public JSONObject verifyEmail(HttpServletRequest request, @PathVariable Integer userid,
			@RequestParam("code") String code) {
		return applicationAPIHandler.verifyEmail(userid, code);
	}
	
	@GetMapping(value = "/{userid}/emailVerificationCode")
	public JSONObject sendEmailVerificationCode(HttpServletRequest request, @PathVariable Integer userid) {
		return applicationAPIHandler.sendEmailForVerification(userid);
	}
	
	
	
	@GetMapping("/home")
	public JSONObject homepage(HttpServletRequest request) {
		return applicationAPIHandler.getHomePageData();
	}
	
	@GetMapping("/movies-title/{name}")
	public JSONObject getMoviesByName(HttpServletRequest request, @PathVariable String name) {
		return applicationAPIHandler.getMatchedMoviesByname(name);
	}
	
	@GetMapping("/movies-genre/{genre}")
	public JSONObject getMoviesByGenre(HttpServletRequest request, @PathVariable String genre) {
		return applicationAPIHandler.getMoviesByGenre(genre);
	}
	
	@GetMapping("/movies-genre-title/{genre}/{name}")
	public JSONObject getMoviesByGenreAndName(HttpServletRequest request, @PathVariable String genre, @PathVariable String name) {
		return applicationAPIHandler.getMatchedMoviesBynameAndGenre( name, genre);
	}
	
	@GetMapping("/movie/{movieid}/shows")
	public JSONObject getMovieShows(HttpServletRequest request, @PathVariable Long movieid) {
		return adminApiHandler.getShowsForMovie(movieid);
	}
	

	
	@GetMapping("/shows/{movieid}/{date}") //   shows/282/2022-11-21
	public JSONObject getShowsOfMovie(HttpServletRequest request,@PathVariable Long movieid, @PathVariable String date) {
		return adminApiHandler.getShowsByMovieDate(movieid, date);
	}
	
	@GetMapping("/shows/{date}") //  shows/2022-11-21
	public JSONObject getShows(HttpServletRequest request, @PathVariable String date) {
		return adminApiHandler.getShows( date);
	}
	
	@GetMapping("/show-details/{showid}")
	public JSONObject getShow(HttpServletRequest request, @PathVariable Long showid) {
		return applicationAPIHandler.getShowByID(showid);
	}
	
	
	@GetMapping("/show-seat-details/{showid}") //  show-seat-details/202
	public JSONObject getShowSeatDetails(HttpServletRequest request, @PathVariable Long showid) {
		return applicationAPIHandler.getShowSeatDetails(showid);
	}
	
	@GetMapping("/promotion-details/{promocode}")
	public JSONObject getPromotions(HttpServletRequest request, @PathVariable String promocode) {
		return applicationAPIHandler.getPromotionByCode(promocode);
	}
}
