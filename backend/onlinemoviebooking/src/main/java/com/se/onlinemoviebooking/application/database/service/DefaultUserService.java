package com.se.onlinemoviebooking.application.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.se.onlinemoviebooking.application.dao.UserDAO;
import com.se.onlinemoviebooking.application.database.repository.UserRepository;
import com.se.onlinemoviebooking.application.dto.AddressDTO;
import com.se.onlinemoviebooking.application.dto.Status;
import com.se.onlinemoviebooking.application.dto.UserDTO;
import com.se.onlinemoviebooking.application.dto.UserType;

@Service("userService")
public class DefaultUserService implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;

	@Override
	public UserDTO saveUser(UserDTO userDTO) {
		UserDAO userRow = populateUserEntity(userDTO);
		return populateUserData(userRepository.save(userRow));
	}
	
	@Override
	public UserDTO getUserDTObyId(Integer userid) {
		UserDAO userRow = userRepository.findByuserid(userid);
		return populateUserData(userRow);
	}
	
	@Override
	public int updateUserPassword(Integer userid, String password) {
		
		return userRepository.updatePassword(encoder.encode(password),userid);
	}
	
	
	
	@Override
	public int updateUserDTObyId(Integer userid, UserDTO userdto) {
		UserDAO userRow = userRepository.findByuserid(userid);
		
		UserDTO userDTO = new UserDTO();
		//userDTO.setUserID(userdto.getUserID());
		userDTO.setFirstName(userdto.getFirstName()==null?userRow.getFirstName():userdto.getFirstName());
		userDTO.setLastName(userdto.getLastName()==null?userRow.getLastName():userdto.getLastName());
		userDTO.setNumber(userdto.getNumber()==null?userRow.getNumber():userdto.getNumber());
		//userDTO.setEmail(userdto.getEmail());
		//userDTO.setPassword(userDAO.getPassword()); //to-do encryption , should we send to front end
		userDTO.setIsSubscribed(userdto.getIsSubscribed()==null?userRow.getIsSubscribed():userdto.getIsSubscribed());
		userDTO.setAddress(userdto.getAddress()==null?AddressDTO.getObject(userRow.getAddress()):userdto.getAddress());
		userDTO.setUserType(userdto.getUserType()==null?UserType.getUserTypeByName(userRow.getUserType()):userdto.getUserType()); 
		userDTO.setStatus(userdto.getStatus()==null?Status.getStatusByID(userRow.getStatusID()):userdto.getStatus());
		
		
		
		return userRepository.updateUserDAO(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getNumber(),
				userDTO.getIsSubscribed(), userDTO.toJSONString(), userDTO.getUserType().getName(), 
				userDTO.getStatus().getID(), userid);
		
		
	}

	public static UserDAO populateUserEntity(UserDTO userDTO) {
		UserDAO userDAO = new UserDAO();
		
		userDAO.setFirstName(userDTO.getFirstName());
		userDAO.setLastName(userDTO.getLastName());
		userDAO.setNumber(userDTO.getNumber());
		userDAO.setEmail(userDTO.getEmail());
		userDAO.setPassword(userDTO.getPassword());
		userDAO.setIsSubscribed(userDTO.getIsSubscribed());
		userDAO.setAddress(userDTO.getAddress().toJSONString());
		userDAO.setUserType(userDTO.getUserType().name());
		userDAO.setStatusID(userDTO.getStatus().getID());
		
		return userDAO;
	}

	public static UserDTO populateUserData(final UserDAO userDAO) {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserID(userDAO.getUserID());
		userDTO.setFirstName(userDAO.getFirstName());
		userDTO.setLastName(userDAO.getLastName());
		userDTO.setNumber(userDAO.getNumber());
		userDTO.setEmail(userDAO.getEmail());
		userDTO.setPassword(userDAO.getPassword()); //to-do encryption , should we send to front end
		userDTO.setIsSubscribed(userDAO.getIsSubscribed());
		userDTO.setAddress(AddressDTO.getObject(userDAO.getAddress()));
		userDTO.setUserType(UserType.getUserTypeByName(userDAO.getUserType())); 
		userDTO.setStatus(Status.getStatusByID(userDAO.getStatusID()));
		
		return userDTO;
	}

}
