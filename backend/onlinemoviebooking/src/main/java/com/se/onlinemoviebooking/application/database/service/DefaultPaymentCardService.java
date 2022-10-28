package com.se.onlinemoviebooking.application.database.service;

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
	
	public static PaymentcardDAO populatePaymentDAO(PaymentcardDTO pc) {
		
		EncryptionService es = EncryptionService.getInstance();
		PaymentcardDAO pcd = new PaymentcardDAO();
		
		pcd.setCardID(pc.getCardID());
		pcd.setUserID(pc.getUserID());
		pcd.setCardNumber(es.convertToDatabaseColumn(pc.getCardNumber()));
		pcd.setCardExpiry(es.convertToDatabaseColumn(pc.getCardExpiry()));
		pcd.setBillingAddress(pc.getBillingAddress().toJSONString());
		
		return pcd;
	}
	
	public static PaymentcardDTO populatePaymentCardDTO(PaymentcardDAO pcd) {
		
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
