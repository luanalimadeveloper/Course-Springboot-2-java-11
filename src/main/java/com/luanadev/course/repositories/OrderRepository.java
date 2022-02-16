package com.luanadev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luanadev.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
