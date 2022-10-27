package com.se.onlinemoviebooking.application.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.se.onlinemoviebooking.application.dto.CustomerDTO;
import com.se.onlinemoviebooking.application.dto.UserDTO;
import com.se.onlinemoviebooking.application.dto.UserType;

public class LoginDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private UserDTO user;

	private Collection<? extends GrantedAuthority> authorities;

	public LoginDetails(UserDTO user) {
		this.user = user;
		this.authorities = getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Integer getId() {
		return user.getUserID();
	}

	public String getEmail() {
		return user.getEmail();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Set<UserType> getRoles() {
		return (this.user instanceof CustomerDTO) ? new HashSet<>(Arrays.asList(UserType.GUEST, UserType.CUSTOMER))
				: new HashSet<>(Arrays.asList(UserType.GUEST, UserType.CUSTOMER, UserType.ADMIN));

	}

	public String getFullName() {
		return user.getFirstName() + " " + user.getLastName();
	}

}
