package com.luanadev.course.resources;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luanadev.course.entities.User;
import com.luanadev.course.services.UserService;


@RestController /* recurso web implementado por um controlador rest */
@RequestMapping(value = "/users")  /* nome/caminho do recurso */
public class UserResource {
	
	@Autowired
	private UserService service;
	
	/* Metodo endponint para acessar usuarios*/
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	/* Metodo endponint para buscar usuarios por id*/
	@GetMapping(value = "/{id}") /*Minha requisicao aceita id dentro da URL*/
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);	
	}
	
}
