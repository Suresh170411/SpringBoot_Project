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

import com.masai.model.Student;
import com.masai.repository.StudentRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private StudentRepository studentRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		Optional<Student> opt= studentRepo.findByEmail(username);

		if(opt.isPresent()) {
			
			Student student = opt.get();
			
			List<GrantedAuthority> authorities= new ArrayList<>();
			//authorities.add(new SimpleGrantedAuthority(customer.getRole()));
			
			
			return new User(student.getEmail(), student.getPassword(), authorities);
			
			
			
		}else
			throw new BadCredentialsException("Student Details not found with this username: "+username);
		
		
		
		
		
	}

}
