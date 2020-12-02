package com.pair.application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.pair.domain.FlowerShop;
import com.pair.domain.Tree;
import com.pair.persistence.FlowerShopRepository;

public class TreeController {	
	
	private FlowerShopController flowershopcontroller = new FlowerShopController();

	public TreeController() {}
	
	//Mètode principal del controlador
	public void addTree() {
		
		List<FlowerShop> flowershoprepository = FlowerShopRepository.getAllFlowerShops();
		
		//Chequear si s'ha creat alguna floristeria previament.
		if (flowershoprepository.isEmpty()) JOptionPane.showMessageDialog(null, "No hi cap floristeria creada !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
		
		else {
			
			String flowershopname = flowershopcontroller.inputFlowerShopName();
			
			//Chequear que la floristeria existeix
			if (!flowershopcontroller.checkFlowerShopName(flowershopname)) 
				JOptionPane.showMessageDialog(null, "Floristeria inexistent !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
			else {
					
				int height=0;
				double price = 0;
					
				//do {
				height = Integer.parseInt(JOptionPane.showInputDialog(null,"Introdueix l'alçada de l'arbre:","ENTRADA",JOptionPane.QUESTION_MESSAGE));
				price = Double.parseDouble(JOptionPane.showInputDialog(null,"Introdueix el preu de l'arbre:","ENTRADA",JOptionPane.QUESTION_MESSAGE));
						//if (height != null)  flowershopname=flowershopname.trim().toUpperCase();
						//else {
						//	flowershopname="";
						//	break;
						//}
				//}while(height.isBlank() || height.isEmpty()); //Chequear que se introdueixi algun caracter
				
				for (FlowerShop l : flowershoprepository) {
					if (l.getName().equals(flowershopname)){
						Tree tree = new Tree (height,price);
						
						if (l.getTrees()== null) {
							ArrayList<Tree> trees = new ArrayList<Tree>();
							trees.add(tree);
							l.setTrees(trees);
						}
						else {
							l.getTrees().add(tree);
						}
						break;
					}					
				}				
			}				
		}			
	}		
}