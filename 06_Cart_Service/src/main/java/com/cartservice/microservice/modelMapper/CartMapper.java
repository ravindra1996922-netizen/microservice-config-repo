package com.cartservice.microservice.modelMapper;

import org.modelmapper.ModelMapper;

import com.cartservice.microservice.DTO.CartDTO;
import com.cartservice.microservice.entity.Cart;

import lombok.Data;

@Data
public class CartMapper {
	
	final static ModelMapper modelMapper=new ModelMapper();
	
	
	public CartDTO convertToCartDTO(Cart cart) {
		CartDTO cartDTO = modelMapper.map(cart, CartDTO.class);
		return cartDTO;
	}
	
	
	public Cart convertToCart(CartDTO cartDTO) {
		Cart cart = modelMapper.map(cartDTO, Cart.class);
		return cart;
	}

}
