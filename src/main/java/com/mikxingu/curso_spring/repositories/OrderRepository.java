package com.mikxingu.curso_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikxingu.curso_spring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}