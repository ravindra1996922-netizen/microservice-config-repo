package com.authservice.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authservice.microservice.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
