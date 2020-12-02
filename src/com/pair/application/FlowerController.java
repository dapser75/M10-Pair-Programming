package com.pair.application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.pair.domain.Flower;
import com.pair.domain.FlowerShop;
import com.pair.persistence.FlowerShopRepository;

public class FlowerController {	
	
	private FlowerShopController flowershopcontroller = new FlowerShopController();

	public FlowerController() {}
	
	//Mètode principal del controlador
	public void addFlower() {
		
		List<FlowerShop> flowershoprepository = FlowerShopRepository.getAllFlowerShops();
		
		//Chequear si s'ha creat alguna floristeria previament.
		if (flowershoprepository.isEmpty()) JOptionPane.showMessageDialog(null, "No hi cap floristeria creada !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
		
		else {			
			String flowershopname = flowershopcontroller.inputFlowerShopName();
			
			//Chequear que la floristeria existeix
			if (!flowershopcontroller.checkFlowerShopName(flowershopname)) 
				JOptionPane.showMessageDialog(null, "Floristeria inexistent !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
			else {
					
				String colour="";
				double price = 0;
					
				do {
				colour = JOptionPane.showInputDialog(null,"Introdueix el color de la flor:","ENTRADA",JOptionPane.QUESTION_MESSAGE);
				price = Double.parseDouble(JOptionPane.showInputDialog(null,"Introdueix el preu de la flor:","ENTRADA",JOptionPane.QUESTION_MESSAGE));
				if (colour != null)  flowershopname=flowershopname.trim().toUpperCase();
				else {
					flowershopname="";
					break;
				}				
				}while(colour.isBlank() || colour.isEmpty()); //Chequear que s'introdueixi algun caràcter
				
				for (FlowerShop l : flowershoprepository) {
					if (l.getName().equals(flowershopname)){
						Flower flower = new Flower (colour,price);
						
						if (l.getFlowers()== null) {
							ArrayList<Flower> flowers = new ArrayList<Flower>();
							flowers.add(flower);
							l.setFlowers(flowers);
						}
						else {
							l.getFlowers().add(flower);
						}
						break;
					}
					
				}
				
			}				
		}			
	}	
}