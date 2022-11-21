package com.se.onlinemoviebooking.application.dto;

import java.util.Date;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

public class PromotionDTO implements SimpleDTO{
	
	private Long promoID;
	private String promotionName;
	private String promocode;
	private Date startDate;
	private Date endDate;
	private Boolean isSent;
	private Float discount;
	
	public PromotionDTO() {
	}
	
	public PromotionDTO(Long promoID, String promotionName, String promocode, Date startDate, Date endDate,
			Boolean isSent, Float discount) {
		super();
		this.promoID = promoID;
		this.promotionName = promotionName;
		this.promocode = promocode;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isSent = isSent;
		this.discount = discount;
	}

	public Long getPromoID() {
		return promoID;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public String getPromocode() {
		return promocode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Boolean getIsSent() {
		return isSent;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setPromoID(Long promoID) {
		this.promoID = promoID;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public void setPromocode(String promocode) {
		this.promocode = promocode;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setIsSent(Boolean isSent) {
		this.isSent = isSent;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}
	
	public String toJSONString() {
		try {
			return dtoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	public static PromotionDTO getObject(String jsonstr) {
		try {
			return dtoMapper.readValue(jsonstr, PromotionDTO.class);
		} catch (JsonProcessingException e) {

			return new PromotionDTO();
		}
	}

	public static PromotionDTO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}
	
	

}
