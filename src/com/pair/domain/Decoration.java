package com.pair.domain;

public class Decoration extends FlowerShopObject {

	private String material;
	//private double price;
	
	public Decoration (String material, double price) {
		super(price);
		this.material = material;
		//this.price = price;	
	}
}