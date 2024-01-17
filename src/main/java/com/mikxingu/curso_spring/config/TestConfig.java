package com.mikxingu.curso_spring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mikxingu.curso_spring.entities.User;
import com.mikxingu.curso_spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria.brown@gmail.com", "8888888888", "1234");
		User u2 = new User(null, "Alex Green", "alex.green@gmail.com", "999999999", "4321");
		
		
		userRepository.saveAll(Arrays.asList(u1, u2));

	}
	
	
	

}
