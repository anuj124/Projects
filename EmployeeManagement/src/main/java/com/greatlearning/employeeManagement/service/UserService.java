package com.greatlearning.employeeManagement.service;

import java.util.List;

import com.greatlearning.employeeManagement.entity.User;

public interface UserService {

	public List<User> findAll();

	public User findById(Long theId);

	public void save(User theUser);

	public void deleteByID(Long theId);
}
