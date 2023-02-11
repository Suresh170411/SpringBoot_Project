package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Laptop;
import com.masai.service.LaptopService;

@RestController
public class LaptopController {

	@Autowired
	private LaptopService lServ;
	
	@PostMapping("/laptop/{id}")
	public ResponseEntity<Laptop> addLaptopHandler(@RequestBody Laptop laptop, @PathVariable ("id") Integer student_id){
		return new ResponseEntity<Laptop>(lServ.addLaptop(laptop,student_id),HttpStatus.OK);
	}
}
