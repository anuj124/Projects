package com.greatlearning.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employeeManagement.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	
}
