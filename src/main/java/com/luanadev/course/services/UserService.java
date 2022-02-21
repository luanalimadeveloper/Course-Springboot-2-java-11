package com.luanadev.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luanadev.course.entities.User;
import com.luanadev.course.repositories.UserRepository;

@Service /*Resgistra como um componente - Classe do Spring que pode ser injetada automaticamente com Autowired*/
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj =  repository.findById(id);
		return obj.get();
	}
	
	/*Salvar no banco de dados um usuario - ".save" Retorna usuario salvo*/
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	/*Atualizar*/
	/*id  para saber quem atualizar e obj para atualizar os dados*/
	@SuppressWarnings("deprecation")
	public User update(Long id, User obj) {
		User entity = repository.getOne(id);
		updateDate(entity, obj);
		return repository.save(entity);
	}

	private void updateDate(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
	
}
