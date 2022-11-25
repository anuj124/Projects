package com.greatlearning.studentManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.studentManagement.entity.Student;
import com.greatlearning.studentManagement.entity.User;
import com.greatlearning.studentManagement.repository.UserRepository;
import com.greatlearning.studentManagement.security.MyUserDetails;

public class UserDetailsServiceImp implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.getUserByUsername(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("Can't Find User By Username "+username);
		}
		return new MyUserDetails(user);
	}

	
	
}
