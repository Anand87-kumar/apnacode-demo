package com.anand.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CartService {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	CartRepository cartRepository;
	
	public List<CartItem> getCartDetails() {
		return cartRepository.findAll();
	}

	public int addCartDetails(CartItem cartItem) {
		return cartRepository.saveCartDetails(cartItem);
	}

	public int updateCartDetails(CartItem cartItem) {
		return cartRepository.updateCartDetails(cartItem);
	}

	public int deleteCartItem(int id) {
		return cartRepository.deleteCartItem(id);
	}

	
	
}
