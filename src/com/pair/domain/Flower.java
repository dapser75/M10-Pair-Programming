package com.pair.domain;

public class Flower extends FlowerShopObject{

	private String colour;
	
	public Flower (String colour, double price) {
		super (price);					
		this.colour = colour;
	}

	public String getColour() {
		return colour;
	}
}