package com.masai.controller;

import java.util.Optional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.repository.CustomerRepo;

@RestController
public class LoginController {

	@Autowired
	private CustomerRepo customerRepository;
	
	@GetMapping("/signIn") 
	public ResponseEntity<Customer> getLoggedInCustomerDetailsHandler(Authentication auth){
		
		
		 Optional<Customer> customer= customerRepository.findByEmail(auth.name()); //getName();
		
		 //to get the token in body, pass HttpServletResponse inside this method parameter 
		// System.out.println(response.getHeaders(SecurityConstants.JWT_HEADER));
		 
		 if (customer.isEmpty()) {
			 throw new BadCredentialsException("Invalid Username or password");
		 }
		 
		 return new ResponseEntity<>(customer.get(), HttpStatus.ACCEPTED);
		
		
	}
}
