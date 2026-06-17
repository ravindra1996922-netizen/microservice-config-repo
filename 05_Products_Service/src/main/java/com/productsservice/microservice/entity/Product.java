package com.productsservice.microservice.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	private String name;
	private String desc;
	private Double price;
	private Integer stock;
	private String image;
	private Integer discount;
	private Double priceBeforeDiscount;
	
	@ManyToOne
	@JoinColumn(name = "category_id",nullable = false)
	private Category category;
	@CreationTimestamp
	@Column(name = "Created_Date" ,updatable = false)
	private LocalDate createdDate;
	
	@CreationTimestamp
	@Column(name = "Updated_Date" ,insertable = false)
	private LocalDate updatedDate; 

}
