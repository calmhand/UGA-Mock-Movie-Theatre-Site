package com.se.onlinemoviebooking.application.services;

import com.se.onlinemoviebooking.application.cache.SimpleCache;
import com.se.onlinemoviebooking.application.dao.PromotionDAO;
import com.se.onlinemoviebooking.application.dao.UserDAO;
import com.se.onlinemoviebooking.application.dto.UserDTO;
import com.se.onlinemoviebooking.application.utilities.ApplicationUtilities;

public class EmailServicehelper {
	
	
	//EMC_userid , RPW_userid
	public static boolean sendRegisterEmailConfirmation(UserDTO user) {
		String sub ="Email Confirmation";
		String body = "Dear [[name]], \n"+ 
		"Please click the link below to verify your registration:\n"+ 
				"\"[[URL]]\"\n"+ "Thank you,\n"+ "b3onlinemoviebooking";
		
		String verifykey = "EMC_"+user.getUserID();
		String verifyURL = "http://localhost:8084/api/onlinemoviebooking/"
				+user.getUserID() + "/emailVerify?code=" +ApplicationUtilities.generateTokenAndUpdateCache(verifykey);
		
		body = body.replace("[[name]]", user.getLastName());
		body = body.replace("[[URL]]",verifyURL);
		
		System.out.println(SimpleCache.getInstance().getCacheMap());
		
		EmailService.getInstance().sendEmail(sub, body, user.getEmail());
		
		return true;
	}
	
	public static boolean sendPromotionEmail(UserDAO user, PromotionDAO promotion) {
		String sub ="Book a movie now!! Promotion Available For You!!!";
		String body = "Dear [[name]], \n"+ 
		"Promotion.. [[promo]] available for you. Use code [[promocode]] and get [[discount]] discount. Book tickets now.\n"+
				"click here [[URL]]";
		
		
		body = body.replace("[[name]]", user.getLastName());
		body = body.replace("[[promo]]",promotion.getPromotionName());
		body = body.replace("[[promocode]]",promotion.getPromocode());
		body = body.replace("[[discount]]",Float.toString(promotion.getDiscount()));
		body = body.replace("[[URL]]","http://localhost:3000");
		
		EmailService.getInstance().sendEmail(sub, body, user.getEmail());
		
		return true;
	}
	
	public static boolean sendPasswordResetCode(UserDTO user) {
		String sub ="Password Reset Code";
		
		
		String verifykey = "RPW_"+user.getUserID();
		
		String code = ApplicationUtilities.generateTokenAndUpdateCache(verifykey);
		
		String body = "Dear [[name]],\n"+ 
		"Please use the below code for reset password\n"+ 
		code+ "\nThank you,\n"+ "b3onlinemoviebooking";
		
		body = body.replace("[[name]]", user.getLastName());
		
		EmailService.getInstance().sendEmail(sub, body, user.getEmail());
		
		return true;
	}
	
	public static boolean sendAccountUdatedEmail(UserDTO user) {
		String sub ="Security Alert Account Updated";
		
		
		String body = "Dear [[name]] \n"+ 
		"Your Account has been updated \n"+ "Thank you,\n"+ "b3onlinemoviebooking";
		
		body = body.replace("[[name]]", user.getLastName());
		
		EmailService.getInstance().sendEmail(sub, body, user.getEmail());
		
		return true;
	}

}
