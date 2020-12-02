package com.pair.domain;

public class Decoration extends FlowerShopObject {

	private String material;
	
	public Decoration (String material, double price) {
		super(price);
		this.material = material;	
	}

	public String getMaterial() {
		return material;
	}
}