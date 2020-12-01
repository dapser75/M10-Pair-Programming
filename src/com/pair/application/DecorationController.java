package com.pair.application;

import java.util.List;

import javax.swing.JOptionPane;

import com.pair.domain.FlowerShop;
import com.pair.persistence.FlowerShopRepository;

public class DecorationController {
	
	
	private FlowerShopRepository flowershoprepository = new FlowerShopRepository();
	
	private List <FlowerShop> flowershoplist= FlowerShopRepository.getAllFlowerShops();
	
	private FlowerShopController flowershopcontroller = new FlowerShopController();


	public DecorationController() {

	}
	
	//Metode principal del controlador
	public void DecorationMain() {
	
		//Chequear si s'ha creat alguna floristeria previament.
		if (flowershoplist.isEmpty()) JOptionPane.showMessageDialog(null, "No hi cap floristeria creada !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
		
		else {
			String flowershopname = flowershopcontroller.InputFlowerShopName();
			//Chequear que la floristeria existeix
			if (!flowershopcontroller.checkFlowerShopName(flowershopname)) 
				JOptionPane.showMessageDialog(null, "Floristeria inexistent !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
			else {
				
			}
			
		}
		
	}
	
	
}