package com.cartservice.microservice.service;

import java.util.List;

import com.cartservice.microservice.DTO.CartDTO;

public interface CartService {
	
	public CartDTO addToCart (CartDTO cartDto) ;

	public CartDTO updateCartQuantityById(CartDTO cartDto) ;

	public List<CartDTO> getCartByUserId(Integer userId);

	public void deleteCartById(Integer cartId);

}
