package com.mikxingu.curso_spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mikxingu.curso_spring.entities.Product;
import com.mikxingu.curso_spring.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> productList = productService.findAll();
		return ResponseEntity
				.ok()
				.body(productList	);
	
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product product = productService.findById(id);
		return ResponseEntity
				.ok()
				.body(product);
	}
	

}
