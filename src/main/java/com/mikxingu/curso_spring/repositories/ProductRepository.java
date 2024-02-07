package com.mikxingu.curso_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikxingu.curso_spring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}