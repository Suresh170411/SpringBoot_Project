package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Student;
import com.masai.repository.StudentRepository;

@RestController
public class LoginController {

	@Autowired
	private StudentRepository studentRepo;
	
	@GetMapping("/signIn")
	public ResponseEntity<Student> getLoggedInCustomerDetailsHandler(Authentication auth){
		
		
		Student student = studentRepo.findByEmail(auth.getName()).orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
		
		 //to get the token in body, pass HttpServletResponse inside this method parameter 
		// System.out.println(response.getHeaders(SecurityConstants.JWT_HEADER));
		 
		 
		 return new ResponseEntity<>(student, HttpStatus.ACCEPTED);
		
		
	}
}
