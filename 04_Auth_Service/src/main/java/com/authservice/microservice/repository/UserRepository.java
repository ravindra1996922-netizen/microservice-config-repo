package com.authservice.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authservice.microservice.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByEmail(String email);
	
	public boolean existsByEmail(String email); 
	

}
