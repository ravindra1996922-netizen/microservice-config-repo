package com.cartservice.microservice.DTO;

import lombok.Data;

@Data
public class CartDTO {

	private Integer cartId;
	private Integer productId;
	private Integer userId;
	private Integer quantity;
}
