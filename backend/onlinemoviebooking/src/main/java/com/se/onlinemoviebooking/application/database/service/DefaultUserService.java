package com.se.onlinemoviebooking.application.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.onlinemoviebooking.application.dao.UserDAO;
import com.se.onlinemoviebooking.application.database.repository.UserRepository;
import com.se.onlinemoviebooking.application.dto.AdminDTO;
import com.se.onlinemoviebooking.application.dto.CustomerDTO;
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

	private UserDAO populateUserEntity(UserDTO userDTO) {
		UserDAO userDAO = new UserDAO();

		return userDAO;
	}

	private UserDTO populateUserData(final UserDAO userDAO) {
		UserDTO userDTO = UserType.getUserTypeByName(userDAO.getUserType()) ==UserType.ADMIN? new AdminDTO() : new CustomerDTO();

		return userDTO;
	}

}
