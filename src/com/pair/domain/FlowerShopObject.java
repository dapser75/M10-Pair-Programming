package com.pair.domain;

public abstract class FlowerShopObject {
	protected double price;

	private static int COUNTER_OBJECTS = 1;
	
	public FlowerShopObject (double price) {
		
		this.price=price;
		COUNTER_OBJECTS ++;		
	}
	public double getPrice() {
		return price;
	}
}