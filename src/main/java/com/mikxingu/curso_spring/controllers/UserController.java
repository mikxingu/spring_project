package com.mikxingu.curso_spring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mikxingu.curso_spring.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Mike", "michelalvs@gmail.com.br", "11911801748", "1234");
		return ResponseEntity
				.ok()
				.body(u);
	
	}

}
