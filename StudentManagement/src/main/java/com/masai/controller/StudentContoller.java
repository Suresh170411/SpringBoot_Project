package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Student;
import com.masai.service.StudentService;

@RestController
public class StudentContoller {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/student")
	public ResponseEntity<Student> registerStudentHandler(@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.registerStudent(student),HttpStatus.OK);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentByIdHandler(@PathVariable ("id") Integer id){
		return new ResponseEntity<Student>(studentService.getStudentById(id),HttpStatus.OK);
	}
	
	
}
