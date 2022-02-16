package com.luanadev.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luanadev.course.entities.Order;
import com.luanadev.course.repositories.OrderRepository;

@Service /*Resgistra como um componente - Classe do Spring que pode ser injetada automaticamente com Autowired*/
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj =  repository.findById(id);
		return obj.get();
	}

}
