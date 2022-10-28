package com.se.onlinemoviebooking.application.database.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.onlinemoviebooking.application.dao.PaymentcardDAO;
import com.se.onlinemoviebooking.application.database.repository.PaymentCardRepository;
import com.se.onlinemoviebooking.application.dto.AddressDTO;
import com.se.onlinemoviebooking.application.dto.PaymentcardDTO;
import com.se.onlinemoviebooking.application.services.EncryptionService;

@Service("paymentCardService")
public class DefaultPaymentCardService {

	@Autowired
	private PaymentCardRepository paymentCardRepository;
	
	public PaymentcardDTO savePaymentCard(PaymentcardDTO pc) {
		
		PaymentcardDAO pcd = populatePaymentDAO(pc);
		
		return populatePaymentCardDTO(paymentCardRepository.save(pcd));
	}
	
	public List<PaymentcardDTO> getPaymentCards( Integer userID) {
		
		Collection<PaymentcardDAO> list = paymentCardRepository.getAllUserCards(userID);
		
		List<PaymentcardDTO> dtoList = new ArrayList<PaymentcardDTO>();
		
		for (Iterator<PaymentcardDAO> name = list.iterator();name.hasNext();) {
			dtoList.add(populatePaymentCardDTO(name.next()));
		}
		
		return dtoList;
	}
	
	public PaymentcardDTO updatePaymentCard(PaymentcardDTO card, Integer cardID) {
		
		EncryptionService es = EncryptionService.getInstance();
		
		System.out.println("updates"+cardID);
		int up = paymentCardRepository.updateCard(es.convertToDatabaseColumn(card.getCardNumber()), 
				es.convertToDatabaseColumn(card.getCardExpiry()), 
				card.getBillingAddress().toJSONString(), cardID);
		System.out.println("updates"+up);
		if(up>0) {
			return card;
		}
		return new PaymentcardDTO();
	}
	
	public boolean deletePaymentCard(Integer cardID) {
		
		int up = paymentCardRepository.deleteBycardID(cardID);
		if(up>0) {
			return true;
		}
		return false;
	}
	
	
	
	public PaymentcardDAO populatePaymentDAO(PaymentcardDTO pc) {
		
		EncryptionService es = EncryptionService.getInstance();
		PaymentcardDAO pcd = new PaymentcardDAO();
		
		pcd.setCardID(pc.getCardID());
		pcd.setUserID(pc.getUserID());
		pcd.setCardNumber(es.convertToDatabaseColumn(pc.getCardNumber()));
		pcd.setCardExpiry(es.convertToDatabaseColumn(pc.getCardExpiry()));
		pcd.setBillingAddress(pc.getBillingAddress().toJSONString());
		
		return pcd;
	}
	
	public PaymentcardDTO populatePaymentCardDTO(PaymentcardDAO pcd) {
		
		EncryptionService es = EncryptionService.getInstance();
		
		PaymentcardDTO pc = new PaymentcardDTO();
		pc.setCardID(pcd.getCardID());
		pc.setUserID(pcd.getUserID());
		pc.setCardNumber( es.convertToEntityAttribute(pcd.getCardNumber()));
		pc.setCardExpiry(es.convertToEntityAttribute(pcd.getCardExpiry()));
		pc.setBillingAddress(AddressDTO.getObject(pcd.getBillingAddress()));
		return pc;
	}


}
