package com.luanadev.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luanadev.course.entities.User;


@RestController /* recurso web implementado por um controlador rest */
@RequestMapping(value = "/users")  /* nome/caminho do recurso */
public class UserResource {
	
	/* Metodo endponint para acessar usuarios*/
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "5564999999999", "123456");
		return ResponseEntity.ok().body(u);
	}
}
