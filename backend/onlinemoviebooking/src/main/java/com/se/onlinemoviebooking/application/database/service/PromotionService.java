package com.se.onlinemoviebooking.application.database.service;

import org.json.simple.JSONArray;

import com.se.onlinemoviebooking.application.dto.PromotionDTO;

public interface PromotionService {
	
	public PromotionDTO savePromotion(PromotionDTO promotionDTO);
	
	public PromotionDTO updatePromotionById(Long promotionID, PromotionDTO payload);
	
	public JSONArray getPromotions();

	boolean updatePromotionAfterSent(Long promotionID);

}
