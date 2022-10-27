package com.se.onlinemoviebooking.application.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.onlinemoviebooking.application.dao.UserDAO;
import com.se.onlinemoviebooking.application.database.repository.UserRepository;
import com.se.onlinemoviebooking.application.dto.AddressDTO;
import com.se.onlinemoviebooking.application.dto.AdminDTO;
import com.se.onlinemoviebooking.application.dto.CustomerDTO;
import com.se.onlinemoviebooking.application.dto.Status;
import com.se.onlinemoviebooking.application.dto.UserDTO;
import com.se.onlinemoviebooking.application.dto.UserType;

@Service("userService")
public class DefaultUserService implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDTO saveUser(UserDTO userDTO) {
		UserDAO userRow = populateUserEntity(userDTO);
		return populateUserData(userRepository.save(userRow));
	}

	public static UserDAO populateUserEntity(UserDTO userDTO) {
		UserDAO userDAO = new UserDAO();
		
		userDAO.setFirstName(userDTO.getFirstName());
		userDAO.setLastName(userDTO.getLastName());
		userDAO.setNumber(userDTO.getNumber());
		userDAO.setEmail(userDTO.getEmail());
		userDAO.setPassword(userDTO.getPassword()); //to-do encryption
		userDAO.setIsSubscribed(userDTO.getIsSubscribed());
		userDAO.setAddress(userDTO.getAddress().toJSONString());
		userDAO.setUserType(userDTO instanceof CustomerDTO ?((CustomerDTO)userDTO).getUserType().name():
			((AdminDTO)userDTO).getUserType().name()); //neeed better sol
		userDAO.setStatusID(userDTO.getStatus().getID());
		
		return userDAO;
	}

	public static UserDTO populateUserData(final UserDAO userDAO) {
		UserDTO userDTO = userDAO.getUserType().equals(UserType.ADMIN.name())? new AdminDTO() : new CustomerDTO();
		
		userDTO.setUserID(userDAO.getUserID());
		userDTO.setFirstName(userDAO.getFirstName());
		userDTO.setLastName(userDAO.getLastName());
		userDTO.setNumber(userDAO.getNumber());
		userDTO.setEmail(userDAO.getEmail());
		userDTO.setPassword(userDAO.getPassword()); //to-do encryption , should we send to front end
		userDTO.setIsSubscribed(userDAO.getIsSubscribed());
		userDTO.setAddress(AddressDTO.getObject(userDAO.getAddress()));
		//usertype already set in constructor
		//userDTO.setUserType(userDTO instanceof CustomerDTO ?((CustomerDTO)userDTO).getUserType().name():((AdminDTO)userDTO).getUserType().name()); 
		userDTO.setStatus(Status.getStatusByID(userDAO.getStatusID()));
		return userDTO;
	}

}
