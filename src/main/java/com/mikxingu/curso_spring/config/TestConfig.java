package com.mikxingu.curso_spring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mikxingu.curso_spring.entities.Category;
import com.mikxingu.curso_spring.entities.Order;
import com.mikxingu.curso_spring.entities.OrderItem;
import com.mikxingu.curso_spring.entities.Payment;
import com.mikxingu.curso_spring.entities.Product;
import com.mikxingu.curso_spring.entities.User;
import com.mikxingu.curso_spring.entities.enums.OrderStatus;
import com.mikxingu.curso_spring.repositories.CategoryRepository;
import com.mikxingu.curso_spring.repositories.OrderItemRepository;
import com.mikxingu.curso_spring.repositories.OrderRepository;
import com.mikxingu.curso_spring.repositories.ProductRepository;
import com.mikxingu.curso_spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria.brown@gmail.com", "8888888888", "1234");
		User u2 = new User(null, "Alex Green", "alex.green@gmail.com", "999999999", "4321");

		Order o1 = new Order(null, Instant.parse("2024-01-01T10:00:10Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2024-01-02T10:00:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2024-01-03T10:00:10Z"), OrderStatus.WAITING_PAYMENT, u1);

		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		Product p1 = new Product(null, "The Lord of the Rings", "a", 1d, "http.blah");
		Product p2 = new Product(null, "Smart TV", "a", 1d, "http.blah");
		Product p3 = new Product(null, "MacBook Pro", "a", 1d, "http.blah");
		Product p4 = new Product(null, "PC Gamer", "a", 1d, "http.blah");
		Product p5 = new Product(null, "Rails for Dummies", "a", 1d, "http.blah");

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().addAll(Arrays.asList(cat1, cat3));
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4,p5));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2024-01-01T12:00:10Z"), o1);
		
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
		
	}
}
