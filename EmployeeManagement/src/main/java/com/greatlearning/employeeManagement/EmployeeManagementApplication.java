package com.greatlearning.employeeManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.greatlearning.employeeManagement.controller","com.greatlearning.employeeManagement.entity","com.greatlearning.employeeManagement.security","com.greatlearning.employeeManagement.service","com.greatlearning.employeeManagement.repository"})
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

}
