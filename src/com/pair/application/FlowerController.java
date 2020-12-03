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
	
	//MÃ¨tode principal del controlador
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
								
				String colour = inputcolour();
				double price = inputprice();
					
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
	
	//Métode per controlar l'entrada del color
	private String inputcolour() {
		String colour="";
		do {
			colour = JOptionPane.showInputDialog(null,"Introdueix el color de la flor:","ENTRADA",JOptionPane.QUESTION_MESSAGE);
			
			if (colour.isBlank() || colour.isEmpty()) JOptionPane.showMessageDialog(null, "El color no pot esgtar buit !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
			
			
		}while(colour.isBlank() || colour.isEmpty());
		colour=colour.trim().toUpperCase();
		return colour;
	}// end metode

	//Métode per introudir el color
	
	
	
	//Métode per introudir el preu
	private double inputprice() {
		double price=-1;
		do {
			try {
				price = Double.parseDouble(JOptionPane.showInputDialog(null,"Introdueix el preu de la flor:","ENTRADA",JOptionPane.QUESTION_MESSAGE));
				if (price <= 0) JOptionPane.showMessageDialog(null, "El preu te que ser major que 0 !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
			
			}catch(Exception e) {

				JOptionPane.showMessageDialog(null, "El preu te que ser un numero!!!", "Alerta", JOptionPane.ERROR_MESSAGE);
				price=-1;
			}
			
		}while (price <= 0);
		
		return price;
	}	//end metode
}