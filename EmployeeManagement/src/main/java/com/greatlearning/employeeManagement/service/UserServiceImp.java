package com.greatlearning.employeeManagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.greatlearning.employeeManagement.entity.User;
import com.greatlearning.employeeManagement.repository.UserRepository;
@Repository
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository userRepository;
	@Override
	@Transactional
	public List<User> findAll() {
		List<User> users = userRepository.findAll();
		return users;
	}

	@Transactional
	@Override
	public User findById(Long theId) {
		User theUser = userRepository.findById(theId).get();
		return theUser;
	}

	@Transactional
	@Override
	public void save(User theUser) {
		userRepository.save(theUser);

	}

	@Transactional
	@Override
	public void deleteByID(Long theId) {
		userRepository.deleteById(theId);
	}
}
