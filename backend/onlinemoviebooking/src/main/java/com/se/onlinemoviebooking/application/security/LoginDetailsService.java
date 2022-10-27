package com.se.onlinemoviebooking.application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.se.onlinemoviebooking.application.dao.UserDAO;
import com.se.onlinemoviebooking.application.database.repository.UserRepository;
import com.se.onlinemoviebooking.application.database.service.DefaultUserService;
import com.se.onlinemoviebooking.application.dto.UserDTO;

@Service
public class LoginDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDAO user = userRepo.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		UserDTO userbyemail= DefaultUserService.populateUserData(user);
		return new LoginDetails(userbyemail);
	}

}
