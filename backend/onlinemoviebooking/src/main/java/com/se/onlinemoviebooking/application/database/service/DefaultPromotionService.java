package com.se.onlinemoviebooking.application.database.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.onlinemoviebooking.application.dao.PromotionDAO;
import com.se.onlinemoviebooking.application.database.repository.PromotionRepository;
import com.se.onlinemoviebooking.application.dto.PromotionDTO;


@Service("promotionService")
public class DefaultPromotionService implements PromotionService{
	
	@Autowired
	private PromotionRepository promotionRepository;
	
	@Override
	public JSONArray getPromotions() {
		List<PromotionDAO> promoList = new ArrayList<PromotionDAO>();
		promoList = promotionRepository.getAllPromotions();
		JSONArray promoArray = new JSONArray();
		promoArray.addAll(promoList);	
		return promoArray;
	}
	
	@Override
	public PromotionDAO getPromotionById(Long promoid) {
		return promotionRepository.findPromotionById(promoid);
	}
	
	@Override
	public PromotionDAO getPromotionByCode(String promo) {
		return promotionRepository.findPromotionByCode(promo);
	}

	@Override
	public PromotionDTO savePromotion(PromotionDTO promotionDTO) {
		PromotionDAO promoRow = populatePromotionEntity(promotionDTO);
		return populatePromotionData(promotionRepository.save(promoRow));
	}

	@Override
	public PromotionDTO updatePromotionById(Long promotionID, PromotionDTO payload) {
		PromotionDTO promotionDTO = new PromotionDTO();
		
		promotionDTO.setPromoID(promotionID);
		promotionDTO.setPromotionName(payload.getPromotionName());
		promotionDTO.setPromocode(payload.getPromocode());
		promotionDTO.setStartDate(payload.getStartDate());
		promotionDTO.setEndDate(payload.getEndDate());
		promotionDTO.setIsSent(payload.getIsSent());
		promotionDTO.setDiscount(payload.getDiscount());
		
		int up = promotionRepository.updatePromotionDAO(promotionDTO.getPromotionName(), promotionDTO.getPromocode(), 
				promotionDTO.getStartDate(), promotionDTO.getEndDate(), promotionDTO.getDiscount(), promotionID);
		System.out.println(up);
		if(up>0) {
			return promotionDTO;
		}
		
		return new PromotionDTO();
	}
	
	@Override
	public boolean updatePromotionAfterSent(Long promotionID) {
		int up = promotionRepository.updatePromotionAfterSent(promotionID);
		if(up>0) {
			return true;
		}
		return false;
	}

	public static PromotionDAO populatePromotionEntity(PromotionDTO promotionDTO) {
		PromotionDAO promotionDAO = new PromotionDAO();
		
		promotionDAO.setPromotionName(promotionDTO.getPromotionName());
		promotionDAO.setPromocode(promotionDTO.getPromocode());
		promotionDAO.setStartDate(promotionDTO.getStartDate());
		promotionDAO.setEndDate(promotionDTO.getEndDate());
		promotionDAO.setIsSent(promotionDTO.getIsSent());
		promotionDAO.setDiscount(promotionDTO.getDiscount());
		
		return promotionDAO;
	}
	
	public static PromotionDTO populatePromotionData(PromotionDAO promotionDAO) {
		PromotionDTO promotionDTO = new PromotionDTO();
		
		promotionDTO.setPromoID(promotionDAO.getPromoID());
		promotionDTO.setPromotionName(promotionDAO.getPromotionName());
		promotionDTO.setPromocode(promotionDAO.getPromocode());
		promotionDTO.setStartDate(promotionDAO.getStartDate());
		promotionDTO.setEndDate(promotionDAO.getEndDate());
		promotionDTO.setIsSent(promotionDAO.getIsSent());
		promotionDTO.setDiscount(promotionDAO.getDiscount());
		
		return promotionDTO;
	}
	

}
