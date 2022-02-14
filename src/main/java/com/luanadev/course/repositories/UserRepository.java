package com.luanadev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luanadev.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
