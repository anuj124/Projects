package com.greatlearning.employeeManagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.employeeManagement.entity.Employee;
import com.greatlearning.employeeManagement.repository.EmployeeRepository;

@Repository
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public List<Employee> findAll() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	@Transactional
	@Override
	public Employee findById(Long theId) {
		Employee theEmployee = employeeRepository.findById(theId).get();
		return theEmployee;
	}

	@Transactional
	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	@Transactional
	@Override
	public void deleteByID(Long theId) {
		employeeRepository.deleteById(theId);
	}

	@Transactional
	@Override
	public Employee updateEmployee(Employee employee, Long id) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow();

		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setDepartment(employee.getDepartment());

		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

}
