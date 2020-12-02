package com.pair.domain;

public class Tree extends FlowerShopObject{

	private int height;
	
	public Tree (int height, double price) {
		super (price);					
		this.height = height;	
	}
	
	public int getHeight() {
		return height;
	}
}