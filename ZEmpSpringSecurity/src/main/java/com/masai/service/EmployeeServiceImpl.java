package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public Employee registerEmployee(Employee employee) {
		return empRepo.save(employee);
	}

	@Override
	public Employee getByEmail(String email) throws EmployeeException {
		Optional<Employee> employee = empRepo.findByEmail(email);
		
		if (employee.isEmpty()) {
			throw new EmployeeException("No Employee Present with this email");
		}else {
			return employee.get();
		}
	}

	@Override
	public List<Employee> getAllEmployee() throws EmployeeException {
		List<Employee> employees =  empRepo.findAll();
		
		if (employees.size() == 0) {
			throw new EmployeeException("No employee found");
		}else {
			return employees;
		}
	}
	
	
}
