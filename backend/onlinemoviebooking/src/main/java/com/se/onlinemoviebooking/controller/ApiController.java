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
import com.se.onlinemoviebooking.application.database.service.MovieService;
import com.se.onlinemoviebooking.application.database.service.PromotionService;
import com.se.onlinemoviebooking.application.database.service.SeatBookingService;
import com.se.onlinemoviebooking.application.database.service.ShowTimeService;
import com.se.onlinemoviebooking.application.database.service.UserService;

@RestController
@RequestMapping("/api/onlinemoviebooking")
@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "*")
public class ApiController {

	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name = "movieService")
	private MovieService movieService;
	
	@Resource(name = "showTimeService")
	private ShowTimeService showTimeService;
	
	@Resource(name = "seatBookingService")
	private SeatBookingService seatBookingService;
	
	@Resource(name = "promotionService")
	private PromotionService promotionService;

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
		return ApplicationAPIHandler.forgotPassword(userService, payload);
	}

	@PostMapping(value = "/emailresetpassword")
	public JSONObject resetPassword(HttpServletRequest request, @RequestBody JSONObject payload) {
		return ApplicationAPIHandler.emailResetPassword(userService, payload);
	}

	@GetMapping(value = "/{userid}/emailVerify")
	public JSONObject verifyEmail(HttpServletRequest request, @PathVariable Integer userid,
			@RequestParam("code") String code) {
		return ApplicationAPIHandler.verifyEmail(userid, userService, code);
	}
	
	@GetMapping(value = "/{userid}/emailVerificationCode")
	public JSONObject sendEmailVerificationCode(HttpServletRequest request, @PathVariable Integer userid) {
		return ApplicationAPIHandler.sendEmailForVerification(userid, userService);
	}
	
	
	
	@GetMapping("/home")
	public JSONObject homepage(HttpServletRequest request) {
		return ApplicationAPIHandler.getHomePageData(movieService);
	}
	
	@GetMapping("/movies-title/{name}")
	public JSONObject getMoviesByName(HttpServletRequest request, @PathVariable String name) {
		return ApplicationAPIHandler.getMatchedMoviesByname(movieService, name);
	}
	
	@GetMapping("/movies-genre/{genre}")
	public JSONObject getMoviesByGenre(HttpServletRequest request, @PathVariable String genre) {
		return ApplicationAPIHandler.getMoviesByGenre(movieService, genre);
	}
	
	@GetMapping("/movies-genre-title/{genre}/{name}")
	public JSONObject getMoviesByGenreAndName(HttpServletRequest request, @PathVariable String genre, @PathVariable String name) {
		return ApplicationAPIHandler.getMatchedMoviesBynameAndGenre(movieService, name, genre);
	}
	
	@GetMapping("/movie/{movieid}/shows")
	public JSONObject getMovieShows(HttpServletRequest request, @PathVariable Long movieid) {
		return AdminApiHandler.getShowsForMovie(showTimeService, movieid);
	}
	

	
	@GetMapping("/shows/{movieid}/{date}") //   shows/282/2022-11-21
	public JSONObject getShowsOfMovie(HttpServletRequest request,@PathVariable Long movieid, @PathVariable String date) {
		return AdminApiHandler.getShowsByMovieDate(showTimeService, movieid, date);
	}
	
	@GetMapping("/shows/{date}") //  shows/2022-11-21
	public JSONObject getShows(HttpServletRequest request, @PathVariable String date) {
		return AdminApiHandler.getShows(showTimeService, date);
	}
	
	@GetMapping("/show-details/{showid}")
	public JSONObject getShow(HttpServletRequest request, @PathVariable Long showid) {
		return ApplicationAPIHandler.getShowByID(showTimeService, showid);
	}
	
	
	@GetMapping("/show-seat-details/{showid}") //  show-seat-details/202
	public JSONObject getShowSeatDetails(HttpServletRequest request, @PathVariable Long showid) {
		return ApplicationAPIHandler.getShowSeatDetails(seatBookingService, showid);
	}
	
	@GetMapping("/promotion-details/{promocode}")
	public JSONObject getPromotions(HttpServletRequest request, @PathVariable String promocode) {
		return ApplicationAPIHandler.getPromotionByCode(promotionService, promocode);
	}
}
