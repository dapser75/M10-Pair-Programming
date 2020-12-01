package com.pair.domain;

public class Tree extends FlowerShopObject{

	private int height;
//	private double price;
	
	public Tree (int height, double price) {
		super (price);					
		this.height = height;
		//this.price = price;
	
	}
}