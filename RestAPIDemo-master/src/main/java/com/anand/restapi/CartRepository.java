package com.anand.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int saveCartDetails(CartItem cartItem) {
		System.out.println("@@@@Inside repo");
		return jdbcTemplate.update(
				"insert into carts (id, name, price) values(?,?,?)",
				cartItem.getId(), cartItem.getName(), cartItem.getPrice());
	}
	
	public List<CartItem> findAll(){
		return jdbcTemplate.query("select * from carts", 
				(resultSet, rowNum) -> 
						new CartItem(
								resultSet.getInt("id"), 
								resultSet.getString("name"), 
								resultSet.getInt("price"))
		);
	}

	public int updateCartDetails(CartItem cartItem) {
		return jdbcTemplate.update(
				"update carts set name = ? where id = ?",
				cartItem.getName(), cartItem.getId());
	}

	public int deleteCartItem(int id) {
		return jdbcTemplate.update(
				"delete carts where id = ?", id);
	}
}
