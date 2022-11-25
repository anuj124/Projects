package com.greatlearning.employeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeeManagement.entity.User;
import com.greatlearning.employeeManagement.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/list")
	public List<User> getAllUser() {
		return userService.findAll();
	}

	@GetMapping("/list/{id}") // getById
	public ResponseEntity<User> getUserById(@PathVariable("id") Long employeeId) {
		return new ResponseEntity<User>(userService.findById(employeeId), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		userService.save(user);
		return new ResponseEntity<User>(HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}") // delete
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
		userService.deleteByID(id);
		return new ResponseEntity<String>("Employee deleted successfully!!!", HttpStatus.OK);
	}

}
