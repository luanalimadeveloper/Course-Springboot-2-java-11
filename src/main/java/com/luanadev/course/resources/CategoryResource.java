package com.luanadev.course.resources;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luanadev.course.entities.Category;
import com.luanadev.course.services.CategoryService;


@RestController /* recurso web implementado por um controlador rest */
@RequestMapping(value = "/categories")  /* nome/caminho do recurso */
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	/* Metodo endponint para acessar usuarios*/
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	/* Metodo endponint para buscar usuarios por id*/
	@GetMapping(value = "/{id}") /*Minha requisicao aceita id dentro da URL*/
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);	
	}
	
}
