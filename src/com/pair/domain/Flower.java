package com.pair.domain;

public class Flower extends FlowerShopObject{

	private String colour;
//	private double price;
	
	public Flower (String colour, double price) {
		super (price);					
		this.colour = colour;
	//	this.price = price;	
	}
}