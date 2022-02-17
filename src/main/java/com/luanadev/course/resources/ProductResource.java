package com.luanadev.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luanadev.course.entities.Product;
import com.luanadev.course.services.ProductService;


@RestController /* recurso web implementado por um controlador rest */
@RequestMapping(value = "/products")  /* nome/caminho do recurso */
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	/* Metodo endponint para acessar usuarios*/
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	/* Metodo endponint para buscar usuarios por id*/
	@GetMapping(value = "/{id}") /*Minha requisicao aceita id dentro da URL*/
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);	
	}
	
}
