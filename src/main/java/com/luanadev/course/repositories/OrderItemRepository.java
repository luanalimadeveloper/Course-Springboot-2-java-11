package com.luanadev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luanadev.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
