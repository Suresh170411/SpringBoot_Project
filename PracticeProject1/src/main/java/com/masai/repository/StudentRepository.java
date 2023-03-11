package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	Optional<Student> findByRoll(Integer roll);
	Optional<Student> findByEmail(String email);
}
