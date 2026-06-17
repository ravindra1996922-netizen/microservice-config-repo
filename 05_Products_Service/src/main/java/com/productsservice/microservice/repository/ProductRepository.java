package com.productsservice.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productsservice.microservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
