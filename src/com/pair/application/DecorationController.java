package com.pair.application;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import com.pair.domain.Decoration;
import com.pair.domain.FlowerShop;
import com.pair.persistence.FlowerShopRepository;

public class DecorationController {
	
	private FlowerShopController flowershopcontroller = new FlowerShopController();

	public DecorationController() { }
	
	public void addDeco() {
		
		List<FlowerShop> flowershoprepository = FlowerShopRepository.getAllFlowerShops();
		
		//Chequear si s'ha creat alguna floristeria previament.
		if (flowershoprepository.isEmpty()) JOptionPane.showMessageDialog(null, "No hi cap floristeria creada !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
			
		else {
				
			String flowershopname = flowershopcontroller.inputFlowerShopName();
				
			//Chequear que la floristeria existeix
			if (!flowershopcontroller.checkFlowerShopName(flowershopname)) 
				JOptionPane.showMessageDialog(null, "Floristeria inexistent !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
			else {
						
				String material="";
				double price = 0;
						
				do {
					material = JOptionPane.showInputDialog(null,"Introdueix el material de la decoració:","ENTRADA",JOptionPane.QUESTION_MESSAGE);
					price = Double.parseDouble(JOptionPane.showInputDialog(null,"Introdueix el preu de la decoració:","ENTRADA",JOptionPane.QUESTION_MESSAGE));
				
				}while(material.isBlank() || material.isEmpty()); //Chequear que s'introdueixi algun caràcter
					
				for (FlowerShop l : flowershoprepository) {
					if (l.getName().equals(flowershopname)){
						Decoration decoration = new Decoration (material,price);
						
						if (l.getDecoration() == null) {  //Si floristeria no té cap decoració
							ArrayList<Decoration> decoList = new ArrayList<Decoration>();
							decoList.add(decoration);
							l.setDecoration(decoList);
						}
						else {
							l.getDecoration().add(decoration);
						}
						break;
					}					
				}
			}				
		}			
	}		
}