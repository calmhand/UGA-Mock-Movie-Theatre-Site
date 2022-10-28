package com.se.onlinemoviebooking.application.database.service;

import org.json.simple.JSONObject;

import com.se.onlinemoviebooking.application.dto.Status;
import com.se.onlinemoviebooking.application.dto.UserDTO;

public interface UserService {
	
	UserDTO saveUser(UserDTO userDTO);
	
	public UserDTO getUserDTObyId(Integer userid);
	
	public UserDTO getUserDTObyEmail(String email);
	
	public UserDTO updateUserDTObyId(Integer userid, UserDTO userdto);
	
	public int updateUserPassword(Integer userid, JSONObject payload);
	
	public int updateUserStatus(Integer userid, Status st);
	
	public int resetUserPassword( JSONObject payload);

}
