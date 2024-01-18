package com.mikxingu.curso_spring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mikxingu.curso_spring.entities.Order;
import com.mikxingu.curso_spring.entities.User;
import com.mikxingu.curso_spring.repositories.OrderRepository;
import com.mikxingu.curso_spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria.brown@gmail.com", "8888888888", "1234");
		User u2 = new User(null, "Alex Green", "alex.green@gmail.com", "999999999", "4321");
		
	
		Order o1 = new Order(null, Instant.parse("2024-01-01T10:00:10Z"), u1);
		Order o2 = new Order(null, Instant.parse("2024-01-02T10:00:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2024-01-03T10:00:10Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

	}
}
