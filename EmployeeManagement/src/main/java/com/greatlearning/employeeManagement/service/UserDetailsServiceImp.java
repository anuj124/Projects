package com.greatlearning.employeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.employeeManagement.entity.User;
import com.greatlearning.employeeManagement.repository.UserRepository;
import com.greatlearning.employeeManagement.security.MyUserDetails;

public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		if (user == null) {
			System.out.println("Could not find user..." + username);
			throw new UsernameNotFoundException("Can't Find User By Username " + username);
		}
		return new MyUserDetails(user);
	}

}
