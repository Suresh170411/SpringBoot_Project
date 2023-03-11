package com.masai.controller;

import java.util.Optional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Employee;
import com.masai.repository.EmployeeRepo;

@RestController
public class LoginController {

	@Autowired
	private EmployeeRepo empRepo;
	
	@GetMapping("/signIn")
	public ResponseEntity<Employee> getLoggedInCustomerDetailsHandler(Authentication auth){
		
		 Optional<Employee> employee= empRepo.findByEmail(auth.name()); //getName();
		
		 //to get the token in body, pass HttpServletResponse inside this method parameter 
		// System.out.println(response.getHeaders(SecurityConstants.JWT_HEADER));
		 
		 if (employee.isEmpty()) {
			 throw new BadCredentialsException("Invalid Username or password");
		 }
		 
		 return new ResponseEntity<>(employee.get(), HttpStatus.ACCEPTED); 
		
		
	}
}
