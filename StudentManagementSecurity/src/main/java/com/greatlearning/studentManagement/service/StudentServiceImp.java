package com.greatlearning.studentManagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.studentManagement.entity.Student;
import com.greatlearning.studentManagement.repository.StudentRepository;

@Repository
public class StudentServiceImp implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	@Transactional
	public List<Student> findAll() {
		List<Student> students = studentRepository.findAll();
		return students;
	}

	@Override
	@Transactional
	public Student findById(int theId) {
		Student theStudent = studentRepository.findById(theId).get();
		return theStudent;
	}

	@Override
	@Transactional
	public void save(Student theStudent) {
		studentRepository.save(theStudent);
	}

	@Override
	@Transactional
	public void deleteByID(int theId) {
		studentRepository.deleteById(theId);

	}

}
