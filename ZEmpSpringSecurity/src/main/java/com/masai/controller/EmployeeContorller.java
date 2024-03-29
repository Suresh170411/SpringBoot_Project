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

import com.masai.model.Employee;
import com.masai.service.EmployeeService;

@RestController
public class EmployeeContorller {

	@Autowired
	private EmployeeService empServ;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/hello")
	public String testHandler() {
		return "Welcome to Spring Security";
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveCustomerHandler(@RequestBody Employee employee){

		
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		
		Employee registeredCustomer= empServ.registerEmployee(employee);
		
		return new ResponseEntity<>(registeredCustomer,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/employees/{email}")
	public ResponseEntity<Employee> getCustomerByEmailHandler(@PathVariable("email") String email){
		
		
		Employee employee = empServ.getByEmail(email);
		
		return new ResponseEntity<>(employee,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllCustomerHandler(){
		
		
		List<Employee> employee = empServ.getAllEmployee();
		
		return new ResponseEntity<>(employee,HttpStatus.ACCEPTED);
		
	}
	
}
