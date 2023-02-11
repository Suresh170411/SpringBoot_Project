package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Laptop;
import com.masai.model.Student;
import com.masai.repository.LaptopRepo;
import com.masai.repository.StudentRepo;

@Service
public class LaptopServiceImpl implements LaptopService{

	@Autowired
	private LaptopRepo lRepo;
	
	@Autowired
	private StudentRepo sRepo;
	
	@Override
	public Laptop addLaptop(Laptop laptop,Integer id) {
		Optional<Student> optStudent = sRepo.findById(id);
		laptop.setStudent(optStudent.get());
		return lRepo.save(laptop);
	}

	@Override
	public String deleteLaptop(Integer id) {
		lRepo.deleteById(id);
		
		return "Laptop Deleted Successfully !";
	}

}
