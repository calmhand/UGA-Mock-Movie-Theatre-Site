package com.se.onlinemoviebooking.application.api;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.se.onlinemoviebooking.application.cache.SimpleCache;
import com.se.onlinemoviebooking.application.dao.PromotionDAO;
import com.se.onlinemoviebooking.application.dao.SeatBookingDAO;
import com.se.onlinemoviebooking.application.database.service.BookingService;
import com.se.onlinemoviebooking.application.database.service.DefaultPaymentCardService;
import com.se.onlinemoviebooking.application.database.service.DefaultShowTimeService;
import com.se.onlinemoviebooking.application.database.service.MovieService;
import com.se.onlinemoviebooking.application.database.service.PromotionService;
import com.se.onlinemoviebooking.application.database.service.SeatBookingService;
import com.se.onlinemoviebooking.application.database.service.ShowTimeService;
import com.se.onlinemoviebooking.application.database.service.TransactionService;
import com.se.onlinemoviebooking.application.database.service.UserService;
import com.se.onlinemoviebooking.application.dto.BookingDTO;
import com.se.onlinemoviebooking.application.dto.ConfirmBookingDTO;
import com.se.onlinemoviebooking.application.dto.MovieDTO;
import com.se.onlinemoviebooking.application.dto.PaymentcardDTO;
import com.se.onlinemoviebooking.application.dto.SeatBookingDTO;
import com.se.onlinemoviebooking.application.dto.ShowTimeDTO;
import com.se.onlinemoviebooking.application.dto.Status;
import com.se.onlinemoviebooking.application.dto.TicketDTO;
import com.se.onlinemoviebooking.application.dto.TransactionDTO;
import com.se.onlinemoviebooking.application.dto.TransactionDetails;
import com.se.onlinemoviebooking.application.dto.TransactionType;
import com.se.onlinemoviebooking.application.dto.UserDTO;
import com.se.onlinemoviebooking.application.dto.ValidateBookingDTO;
import com.se.onlinemoviebooking.application.services.EmailServicehelper;
import com.se.onlinemoviebooking.application.utilities.ApplicationStringConstants;
import com.se.onlinemoviebooking.application.utilities.ApplicationUtilities;

@Service("applicationAPIHandler")
public class ApplicationAPIHandler {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private ShowTimeService showTimeService;
	
	@Autowired
	private SeatBookingService seatBookingService;
	
	@Autowired
	private PromotionService promotionService;

	@Autowired
	private DefaultPaymentCardService paymentCardService;
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private TransactionService transactionService;

	/* Registration */

	public JSONObject registerUser(JSONObject payload, PasswordEncoder encoder) {
		// to-do verify details and save
		UserDTO userDTO = UserDTO.getObject(payload);
		userDTO.setPassword(encoder.encode(userDTO.getPassword()));
		userDTO.setStatus(Status.INACTIVE);
		UserDTO saveduser = userService.saveUser(userDTO);

		EmailServicehelper.sendRegisterEmailConfirmation(saveduser);

		JSONParser parser = new JSONParser();
		JSONObject json;
		try {
			json = (JSONObject) parser.parse(saveduser.toJSONString());
		} catch (ParseException e) {
			json = new JSONObject();
			json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
			return failureResponse(json);
		}
		return successResponse(json);
	}
	
	public JSONObject sendEmailForVerification(Integer userID) {
		JSONObject json = new JSONObject();
		UserDTO user = userService.getUserDTObyId(userID);
		if(user==null || user.getStatus().getID()==3) {
			json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SUSPENDEDUSER);
			return failureResponse(json);
		}
		if(user.getStatus().getID()==1) {
			json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.ALREADYVERIFIED);
			return failureResponse(json);
		}
		EmailServicehelper.sendRegisterEmailConfirmation(user);
		
		return successResponse(json);
	}
	

	public JSONObject getUserProfile(Integer userID) {

		UserDTO user = userService.getUserDTObyId(userID);
		user.setPassword("");
		JSONParser parser = new JSONParser();
		JSONObject json;
		try {
			json = (JSONObject) parser.parse(user.toJSONString());
		} catch (ParseException e) {
			json = new JSONObject();
			json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
			return failureResponse(json);
		}
		return successResponse(json);
	}

	public JSONObject updateUserProfile(Integer userID, UserDTO payload) {

		UserDTO updated = userService.updateUserDTObyId(userID, payload);

		JSONObject json = new JSONObject();
		if (updated.getUserID() != null) {
			JSONParser parser = new JSONParser();
			try {
				json = (JSONObject) parser.parse(updated.toJSONString());
			} catch (ParseException e) {
				json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
				return failureResponse(json);
			}
			EmailServicehelper.sendAccountUdatedEmail(updated);
			return successResponse(json);
		}

		return failureResponse(json);
	}

	public JSONObject updateUserPassword(Integer userID, JSONObject payload) {

		int rec = userService.updateUserPassword(userID, payload);
		if (rec > 0) {
			return successResponse(new JSONObject());
		}

		return failureResponse(new JSONObject());
	}

	public JSONObject forgotPassword( JSONObject payload) {

		if (payload.get("email") == null || ((String) payload.get("email")).isEmpty()) {
			return failureResponse(new JSONObject());
		}

		UserDTO user = userService.getUserDTObyEmail((String) payload.get("email"));
		if (user == null) {
			return failureResponse(new JSONObject());
		}

		EmailServicehelper.sendPasswordResetCode(user);

		JSONObject resp = new JSONObject();
		resp.put("userID", user.getUserID());
		return successResponse(resp);
	}

	public JSONObject emailResetPassword( JSONObject payload) {
		int up = userService.resetUserPassword(payload);
		if (up > 0) {
			return successResponse(new JSONObject());
		}
		return failureResponse(new JSONObject());
	}

	public JSONObject verifyEmail(Integer userID,String code) {
		System.out.println(SimpleCache.getInstance().getCacheMap());
		String key = "EMC_" + userID;
		String val = SimpleCache.getInstance().get(key);
		if (val != null && val.equals(code)) {
			userService.updateUserStatus(userID, Status.ACTIVE);
			return successResponse(new JSONObject());
		}

		JSONObject json = new JSONObject();
		json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.VERIFICATIONFAILED);
		return failureResponse(json);
	}

	public JSONObject addUserPayment(Integer userID, JSONObject payload) {
		PaymentcardDTO paymentcard = PaymentcardDTO.getObject(payload);

		PaymentcardDTO savedCard = paymentCardService.savePaymentCard(paymentcard);

		JSONParser parser = new JSONParser();
		JSONObject json;
		try {
			json = (JSONObject) parser.parse(savedCard.toJSONString());
		} catch (ParseException e) {
			json = new JSONObject();
			json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
			return failureResponse(json);
		}
		return successResponse(json);

	}

	public List<PaymentcardDTO> getUserPayments(Integer userid) {

		return paymentCardService.getPaymentCards(userid);
	}

	public JSONObject deleteUserPayment(Integer userid, PaymentcardDTO payload) {

		boolean del = paymentCardService.deletePaymentCard(payload.getCardID());
		if (del) {
			return successResponse(new JSONObject());
		}
		return failureResponse(new JSONObject());
	}

	public JSONObject editUserPayment(Integer userid, PaymentcardDTO payload) {

		PaymentcardDTO pcd = paymentCardService.updatePaymentCard(payload, payload.getCardID());

		JSONObject json = new JSONObject();

		if (pcd.getCardID() == null) {
			return failureResponse(json);
		}

		JSONParser parser = new JSONParser();
		try {
			json = (JSONObject) parser.parse(pcd.toJSONString());
		} catch (ParseException e) {
			json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
			return failureResponse(json);
		}
		return successResponse(json);
	}

	public JSONObject getHomePageData() {
		JSONObject json = movieService.getHomePageMovies();
		return successResponse(json);
	}

	public JSONObject getMatchedMoviesByname(String name) {
		JSONObject json = new JSONObject();
		json.put("movies", movieService.getMatchedMovies(name));
		return successResponse(json);
	}

	public JSONObject getMoviesByGenre(String genre) {
		JSONObject json = new JSONObject();
		json.put("movies", movieService.getMoviesByGenre(genre));
		return successResponse(json);
	}

	public JSONObject getMatchedMoviesBynameAndGenre(String name, String genre) {
		JSONObject json = new JSONObject();
		json.put("movies", movieService.getMatchedMoviesByGenre(name, genre));
		return successResponse(json);
	}

	public JSONObject getShowByID(Long showid) {
		JSONObject response = showTimeService.getShowTimeById(showid);
		return successResponse(response);
	}

	public JSONObject getShowSeatDetails(Long showid) {
		JSONObject json = seatBookingService.getShowSeatDetails(showid);
		if (json == null) {
			json = new JSONObject();
			json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
			return failureResponse(json);
		}
		return successResponse(json);
	}

	public JSONObject getPromotionByCode(String code) {
		PromotionDAO promotion = promotionService.getPromotionByCode(code.toUpperCase());

		JSONParser parser = new JSONParser();
		JSONObject json;
		if (promotion == null) {
			json = new JSONObject();
			json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.PROMOTIONNOTAVAILABLE);
			return failureResponse(json);
		}
		try {
			json = (JSONObject) parser.parse(promotion.toJSONString());
		} catch (ParseException e) {
			json = new JSONObject();
			json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.PROMOTIONNOTAVAILABLE);
			return failureResponse(json);
		}
		return successResponse(json);
	}

	public JSONObject validateBooking(ValidateBookingDTO payload) {
		JSONObject json = new JSONObject();

		ShowTimeDTO show = showTimeService.getShowTimeDTOById(payload.getShowID());
		if (show == null) {
			json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
			return failureResponse(json);
		}

		SeatBookingDAO sbDetails = seatBookingService.getSeatBookingDAODetails(payload.getShowID());
		if (sbDetails != null) {
			for (String each : payload.getBookedSeats()) {

				JSONParser parser = new JSONParser();
				JSONArray jsonarr;
				try {
					jsonarr = (JSONArray) parser.parse(sbDetails.getBookedSeats());
				} catch (ParseException e) {
					jsonarr = new JSONArray();
				}

				if (jsonarr.contains(each)) {
					json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SEATSBOOKED);
					return failureResponse(json);
				}
			}
		}

		TicketDTO td = payload.getTickets();
		float total = 0.0f;
		total += td.getChild() * show.getTicketPrices().getChild() + td.getAdult() * show.getTicketPrices().getAdult()
				+ td.getSenior() * show.getTicketPrices().getSenior();

		json.put("show",
				DefaultShowTimeService.getJsonFromShowTimeDAO(DefaultShowTimeService.populateShowTimeEntity(show)));
		json.put("tickets", td);

		JSONArray bSeats = new JSONArray();
		bSeats.addAll(payload.getBookedSeats());

		json.put("bookedSeats", bSeats);
		json.put("totalWithoutTax", total);
		json.put("taxPercentage", 5);
		float totalWithTax = total + total * 0.05f;
		json.put("total", totalWithTax);
		return successResponse(json);

	}

	public JSONObject ConfirmBooking(ConfirmBookingDTO payload) {
		JSONObject json = new JSONObject();

		UserDTO userdto = userService.getUserDTObyId(payload.getUserID().intValue());
		if (userdto == null || userdto.getStatus().getID() > 1) {
			json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SUSPENDEDUSER);
			return failureResponse(json);
		}

		MovieDTO mv = movieService.getMovieById(payload.getMovieID());

		ShowTimeDTO show = showTimeService.getShowTimeDTOById(payload.getShowID());
		if (show == null) {
			json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
			return failureResponse(json);
		}

		SeatBookingDAO sbDetails = seatBookingService.getSeatBookingDAODetails(payload.getShowID());
		if (sbDetails != null) {
			for (String each : payload.getBookedSeats()) {
				if (sbDetails.getBookedSeats().contains(each)) {
					json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SEATSBOOKED);
					return failureResponse(json);
				}
			}
		}

		TicketDTO td = payload.getTickets();
		int noTickets = td.getAdult() + td.getChild() + td.getSenior();
		if (noTickets != payload.getBookedSeats().size()) {
			json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
			return failureResponse(json);
		}
		Float discount = 0.0f;
		PromotionDAO promotion = ApplicationUtilities.isNullOrEmpty(payload.getPromocode()) ? null
				: promotionService.getPromotionByCode(payload.getPromocode());

		if (promotion != null) {
			discount = promotion.getDiscount();
		}

		float total = 0.0f;
		total += td.getChild() * show.getTicketPrices().getChild() + td.getAdult() * show.getTicketPrices().getAdult()
				+ td.getSenior() * show.getTicketPrices().getSenior();
		float discountedTotal = total - ((discount / 100) * total);
		float totalwithTax = discountedTotal + discountedTotal * 0.05f;
		JSONArray bSeats = new JSONArray();
		bSeats.addAll(payload.getBookedSeats());

		json.put("show",
				DefaultShowTimeService.getJsonFromShowTimeDAO(DefaultShowTimeService.populateShowTimeEntity(show)));
		json.put("tickets", td);
		json.put("bookedSeats", bSeats);
		json.put("totalWithoutTax", total);
		json.put("discountedTotalWithoutTax", discountedTotal);
		json.put("taxPercentage", 5);
		json.put("total", totalwithTax);

		// seatbooking
		if (sbDetails == null) {
			SeatBookingDTO sbd = new SeatBookingDTO();
			sbd.setShowID(payload.getShowID());
			JSONArray payloadBookedSeats = new JSONArray();
			payloadBookedSeats.addAll(payload.getBookedSeats());
			sbd.setBookedSeats(payloadBookedSeats);
			SeatBookingDTO savedsbd = seatBookingService.saveShowSeatDetails(sbd);
			if (savedsbd == null) {
				json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
				return failureResponse(json);
			}

		} else {

			JSONParser parser = new JSONParser();
			JSONArray jsonarr;
			try {
				jsonarr = (JSONArray) parser.parse(sbDetails.getBookedSeats());
			} catch (ParseException e) {
				jsonarr = new JSONArray();
			}
			jsonarr.addAll(payload.getBookedSeats());
			sbDetails.setBookedSeats(jsonarr.toJSONString());
			SeatBookingDTO updatedsb = seatBookingService.updateSeatBookingById(sbDetails.getSeatbookingID(), sbDetails);
			if (updatedsb == null || updatedsb.getSeatbookingID() == null) {
				json.put(ApplicationStringConstants.ERROR, ApplicationStringConstants.SOMETHINGWENTWRONG);
				return failureResponse(json);
			}
		}

		// transaction
		TransactionDTO tr = new TransactionDTO();
		tr.setTransactionType(TransactionType.CARD);

		String cardNum = payload.getPayment().getCardNumber();
		TransactionDetails transactionDetails = TransactionDetails.generateTransaction();
		transactionDetails.setCardNumber("XXXX" + cardNum.substring(cardNum.length() - 4));
		tr.setTransactionDetails(transactionDetails);

		tr.setTrasactionAmount(totalwithTax);
		tr.setBillingAddress(payload.getPayment().getBillingAddress());

		LocalDateTime now = LocalDateTime.now();
		tr.setTransactionTime(now);

		TransactionDTO savedTransaction = transactionService.saveTransaction(tr);

		// booking
		BookingDTO bookingdto = new BookingDTO();
		bookingdto.setUserID(payload.getUserID());

		bookingdto.setMovieID(payload.getMovieID());

		bookingdto.setShowID(payload.getShowID());
		bookingdto.setTickets(td);
		bookingdto.setPromoid(promotion != null ? promotion.getPromoID() : null);

		bookingdto.setBookedSeats(bSeats);
		bookingdto.setTotal(totalwithTax);
		bookingdto.setTransactionID(savedTransaction.getTransactionID());
		bookingdto.setBookingTime(now);

		BookingDTO savedBooking = bookingService.saveBooking(bookingdto);

		if (savedBooking != null) {
			json.put("bookingID", savedBooking.getBookingID());
		}

		try {
			EmailServicehelper.sendBookingConfirmation(userdto, savedBooking, show, mv);
		} catch (Exception e) {
			//log
		}
		return successResponse(json);
	}

	public JSONObject getUserBookings(Long userID) {

		JSONArray arr = bookingService.getBookingsOfuser(userID);

		JSONObject json = new JSONObject();
		json.put("bookings", arr);
		return successResponse(json);
	}

	public static JSONObject successResponse(JSONObject resp) {
		resp.put(ApplicationStringConstants.PROCESS, ApplicationStringConstants.SUCCESS);
		return resp;
	}

	public static JSONObject failureResponse(JSONObject resp) {
		resp.put(ApplicationStringConstants.PROCESS, ApplicationStringConstants.FAILURE);
		return resp;
	}

}
