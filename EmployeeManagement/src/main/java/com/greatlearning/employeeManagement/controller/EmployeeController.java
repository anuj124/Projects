package com.greatlearning.employeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeeManagement.entity.Employee;
import com.greatlearning.employeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/list")
	public List<Employee> getAllEmployee() {
		return employeeService.findAll();
	}

	@GetMapping("/list/{id}") // getById
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId) {
		return new ResponseEntity<Employee>(employeeService.findById(employeeId), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}

	@PutMapping("/update/{id}") // update
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}

	@DeleteMapping("delete/{id}") // delete
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
		employeeService.deleteByID(id);
		return new ResponseEntity<String>("Employee deleted successfully!!!", HttpStatus.OK);
	}

}
