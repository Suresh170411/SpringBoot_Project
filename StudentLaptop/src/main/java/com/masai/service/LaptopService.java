package com.masai.service;

import com.masai.model.Laptop;

public interface LaptopService {

	Laptop addLaptop (Laptop laptop,Integer id);
	String deleteLaptop (Integer id);
}
