package com.salesken.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salesken.model.Student;
import com.salesken.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository sRepo;
	
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {
		return sRepo.save(student);
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
	 Iterable<Student> itr= sRepo.findAll();
	 
	 List<Student> students= new ArrayList<>();
	 itr.forEach(students::add);
	 
	  return students;
	}
}
