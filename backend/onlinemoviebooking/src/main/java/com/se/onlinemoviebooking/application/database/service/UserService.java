package com.se.onlinemoviebooking.application.database.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.se.onlinemoviebooking.application.dao.UserDAO;
import com.se.onlinemoviebooking.application.dto.Status;
import com.se.onlinemoviebooking.application.dto.UserDTO;

public interface UserService {
	
	public UserDTO saveUser(UserDTO userDTO);
	
	public UserDTO getUserDTObyId(Integer userid);
	
	public UserDTO getUserDTObyEmail(String email);
	
	public List<UserDAO> getSubscribedUsers();
	
	public UserDTO updateUserDTObyId(Integer userid, UserDTO payload);
	
	public int updateUserPassword(Integer userid, JSONObject payload);
	
	public int updateUserStatus(Integer userid, Status st);
	
	public int resetUserPassword( JSONObject payload);

	boolean suspendUser(Integer userId);

	boolean activateUser(Integer userId);

	JSONArray getUsers();

}
