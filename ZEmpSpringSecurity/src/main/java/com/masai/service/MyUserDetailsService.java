package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.model.Employee;
import com.masai.repository.EmployeeRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Employee> opt = empRepo.findByEmail(username);

		if (opt.isPresent()) {
			Employee employee = opt.get();

			List<GrantedAuthority> authorities = new ArrayList<>();

			return new User(employee.getEmail(), employee.getPassword(), authorities);
		} else {
			throw new BadCredentialsException("User Details not found with this username: " + username);
		}
	}

}
