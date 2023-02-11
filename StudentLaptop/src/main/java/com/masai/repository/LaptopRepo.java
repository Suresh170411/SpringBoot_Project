package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Laptop;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop, Integer>{

}
