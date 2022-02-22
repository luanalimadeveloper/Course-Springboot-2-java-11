package com.luanadev.course.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.luanadev.course.entities.User;
import com.luanadev.course.repositories.UserRepository;
import com.luanadev.course.services.exceptions.DatabaseException;
import com.luanadev.course.services.exceptions.ResourceNotFoundException;

@Service /*Resgistra como um componente - Classe do Spring que pode ser injetada automaticamente com Autowired*/
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj =  repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	/*Salvar no banco de dados um usuario - ".save" Retorna usuario salvo*/
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
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
