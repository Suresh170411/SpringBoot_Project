package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Course;
import com.masai.model.Student;
import com.masai.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo studentRepository;

	@Override
	public Student registerStudent(Student student) {
		Course course = new Course();
		course.setCid(1);
		course.setCourseName("DSA");
		
		
		
		
		
		course.getStudent().add(student);
		student.setCourse(course);
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> opt = studentRepository.findById(id);
		return opt.get();
	}

	@Override
	public Student deleteStudentById(Integer id) {
		
		Optional<Student> opt = studentRepository.findById(id);
		
		studentRepository.deleteById(id);
		
		return opt.get();
	}
	
	
}
