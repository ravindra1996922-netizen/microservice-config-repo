package com.cartservice.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cartservice.microservice.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
