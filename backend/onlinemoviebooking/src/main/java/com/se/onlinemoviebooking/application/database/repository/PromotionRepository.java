package com.se.onlinemoviebooking.application.database.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.se.onlinemoviebooking.application.dao.PromotionDAO;

public interface PromotionRepository extends JpaRepository<PromotionDAO, Long>{
	
	@Query("select p from PromotionDAO p")
    public List<PromotionDAO> getAllPromotions();
	
	@Query("SELECT p from PromotionDAO p where p.promoID = ?1")
	public PromotionDAO findPromotionById(Long promoid);
	
	@Query("SELECT p from PromotionDAO p where p.promocode = ?1")
	public PromotionDAO findPromotionByCode(String promotionName);
	
	@Transactional
	@Modifying
	@Query("update PromotionDAO p set p.promotionName = ?1, p.promocode = ?2, p.startDate = ?3, p.endDate = ?4, p.discount = ?5 where p.promoID = ?6 and p.isSent = FALSE")
	public int updatePromotionDAO(String promotionName, String promocode, Date startDate,  Date endDate, float discount,
			Long promoID);
	
	@Transactional
	@Modifying
	@Query("update PromotionDAO p set p.isSent = TRUE  where p.promoID = ?1")
	public int updatePromotionAfterSent(Long promoID);

}
