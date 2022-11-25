package com.greatlearning.employeeManagement.service;

import java.util.List;

import com.greatlearning.employeeManagement.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(Long theId);

	public void save(Employee theEmployee);

	public void deleteByID(Long theId);

	public Employee updateEmployee(Employee employee, Long id);
}
