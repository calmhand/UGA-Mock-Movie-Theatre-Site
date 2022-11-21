package com.se.onlinemoviebooking.application.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

@Entity
@Table(name = "promotion")
public class PromotionDAO implements SimpleDAO {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "promoid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long promoID;

	@Column(name = "promotion_name")
	private String promotionName;

	@Column(name = "promocode")
	private String promocode;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "is_sent")
	private Boolean isSent;

	@Column(name = "discount")
	private Float discount;

	public PromotionDAO() {
	}

	public PromotionDAO(Long promoID, String promotionName, String promocode, Date startDate, Date endDate,
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
			return daoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	public static PromotionDAO getObject(String jsonstr) {
		try {
			return daoMapper.readValue(jsonstr, PromotionDAO.class);
		} catch (JsonProcessingException e) {

			return new PromotionDAO();
		}
	}

	public static PromotionDAO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}

}
