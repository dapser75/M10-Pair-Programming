package com.pair.view;

import javax.swing.JFrame;

public class FrameShop extends JFrame {
	
	public FrameShop () {
		
		setTitle("Floristeria API");
		setBounds(400,200,750,400);		
		FlowerSheet mySheet = new FlowerSheet();
		add(mySheet);
		
	}	
}