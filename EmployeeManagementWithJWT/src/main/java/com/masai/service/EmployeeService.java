package com.masai.service;

import java.util.List;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;

public interface EmployeeService {

	public Employee registerEmployee(Employee employee);
	
	public Employee getEmployeeByEmail(String email) throws EmployeeException;
	
	public List<Employee> getAllEmployeeDetails() throws EmployeeException;
}
