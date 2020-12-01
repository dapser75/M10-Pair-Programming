package com.pair.view;

import javax.swing.JFrame;

import com.pair.application.FlowerShopController;
import com.pair.persistence.FlowerShopRepository;

public class Main {

	//private FlowerShopRepository shopsList = new FlowerShopRepository();
	//private FlowerShopController controller = new FlowerShopController(shopsList);
	
	public static void main (String[] args) {
	
		FrameShop myFrame = new FrameShop();		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);

	}
}