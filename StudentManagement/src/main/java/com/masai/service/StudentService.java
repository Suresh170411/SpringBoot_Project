package com.masai.service;

import com.masai.model.Student;

public interface StudentService {
	
	public Student registerStudent(Student student);
	public Student getStudentById(Integer id);
	public Student deleteStudentById(Integer id);
}
