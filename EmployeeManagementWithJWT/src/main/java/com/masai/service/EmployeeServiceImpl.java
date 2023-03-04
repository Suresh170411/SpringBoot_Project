package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exception.EmployeeException;
import com.masai.model.Authority;
import com.masai.model.Employee;
import com.masai.repository.EmployeeRepo;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public Employee registerEmployee(Employee employee) {

		List<Authority> authorities = employee.getAuthorities();

		for (Authority authority : authorities) {
			authority.setEmployee(employee);
		}

		return empRepo.save(employee);
	}

	@Override
	public Employee getEmployeeByEmail(String email) throws EmployeeException {

		return empRepo.findByEmail(email)
				.orElseThrow(() -> new EmployeeException("Employee Not found with Email: " + email));
	}

	@Override
	public List<Employee> getAllEmployeeDetails() throws EmployeeException {

		List<Employee> employee = empRepo.findAll();

		if (employee.isEmpty())
			throw new EmployeeException("No Employee found");

		return employee;
	}

}
