package com.nnk.springboot.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.nnk.springboot.domain.User;


public class UserPrincipal implements UserDetails{
	
	private String username;
	private String password;
	private List<GrantedAuthority> roles;
	
	public UserPrincipal(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(user.getRole()));
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
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

}