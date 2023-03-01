package com.masai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/spring")
	public String getAll() {
		return "Hello welcome";
	}
	
	@GetMapping("/springS")
	public String getAllP() {
		return "Hello welcome to spring security";
	}
}
