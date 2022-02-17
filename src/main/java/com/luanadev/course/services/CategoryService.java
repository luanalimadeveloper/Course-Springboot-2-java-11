package com.luanadev.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luanadev.course.entities.Category;
import com.luanadev.course.repositories.CategoryRepository;

@Service /*Resgistra como um componente - Classe do Spring que pode ser injetada automaticamente com Autowired*/
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj =  repository.findById(id);
		return obj.get();
	}

}
