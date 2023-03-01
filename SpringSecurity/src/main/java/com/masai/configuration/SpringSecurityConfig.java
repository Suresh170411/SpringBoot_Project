package com.masai.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

	@Bean
	public SecurityFilterChain customSecurityFilter(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((auth) -> auth
				.requestMatchers("/springS").authenticated()
				.requestMatchers("/spring").permitAll()
				).httpBasic();
		
		return http.build();
	}
	
	
}
