package com.se.onlinemoviebooking.application.utilities;

import java.util.Random;

import com.se.onlinemoviebooking.application.cache.SimpleCache;

public class ApplicationUtilities {
	
	public static String generateTokenAndUpdateCache(String key) {
		
		//6digit token
	    String token = String.format("%06d", (new Random()).nextInt(999999));;
	    SimpleCache.getInstance().add(key, token);
	    return token;
		
	}

	public static boolean isNullOrEmpty(String str) {
		return str==null||str.isBlank();
	}
}
