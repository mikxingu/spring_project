package com.mikxingu.curso_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikxingu.curso_spring.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}