package com.anand.restapi;

import io.swagger.annotations.ApiModelProperty;

public class CartItem {

	@ApiModelProperty(notes="item id",name="id",required=true)
	private int id;
	private String name;
	private int price;
	
	public CartItem(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "CartItem [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}
