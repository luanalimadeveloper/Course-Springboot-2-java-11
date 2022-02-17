package com.luanadev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luanadev.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
