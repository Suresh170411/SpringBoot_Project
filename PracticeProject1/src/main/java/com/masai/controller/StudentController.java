package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Student;
import com.masai.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentServ;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/student")
	public ResponseEntity<Student> registerStudentHandler(@RequestBody Student student){
		
		student.setPassword(passwordEncoder.encode(student.getPassword()));
		
		return new ResponseEntity<>(studentServ.addStudent(student),HttpStatus.OK);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentHandler(){
		return new ResponseEntity<List<Student>>(studentServ.getAllStudents(),HttpStatus.OK);
	}
	
	@GetMapping("/student/{roll}")
	public ResponseEntity<Student> getStudentByRollHandler(@PathVariable ("roll") Integer roll){
		return new ResponseEntity<Student>(studentServ.getStudentByRoll(roll),HttpStatus.ACCEPTED);
	}
}
