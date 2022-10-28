package com.se.onlinemoviebooking.application.database.service;

import com.se.onlinemoviebooking.application.dto.UserDTO;

public interface UserService {
	
	UserDTO saveUser(UserDTO userDTO);
	
	public UserDTO getUserDTObyId(Integer userid);
	
	public int updateUserDTObyId(Integer userid, UserDTO userdto);
	
	public int updateUserPassword(Integer userid, String password);

}
