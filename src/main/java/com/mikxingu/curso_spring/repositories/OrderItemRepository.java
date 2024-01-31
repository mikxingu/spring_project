package com.mikxingu.curso_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikxingu.curso_spring.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}