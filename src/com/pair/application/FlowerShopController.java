package com.pair.application;

import java.util.List;

import javax.swing.JOptionPane;

import com.pair.domain.FlowerShop;
import com.pair.persistence.FlowerShopRepository;

public class FlowerShopController {

	private FlowerShopRepository flowershoprepository = new FlowerShopRepository();
	private FlowerShopRepository repository; 	
	
	public FlowerShopController(FlowerShopRepository repository){ 
		
		this.repository = repository;		
	}
	
	public FlowerShopController() {}

	//Mètode per donar d'alta una nova floristeria
	public void NewFlowerShop () {
		String flowershopname="";
		boolean existsflowershop=false;
		
			flowershopname=inputFlowerShopName(); //Crida al metode per introduir el nom de la floristeria
			if (flowershopname != "") {
				existsflowershop = checkFlowerShopName(flowershopname);
				
				if (!existsflowershop)  FlowerFhopCreated(flowershopname);
				else JOptionPane.showMessageDialog(null, "Floristeria existent !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Operació cancel·lada", "Alerta", JOptionPane.ERROR_MESSAGE);
				
			}		
	}

	//Mètode per afegir una floristeria al repository
	private void FlowerFhopCreated(String flowershopname) {
		try {
			FlowerShop flowershop = new FlowerShop (flowershopname);
			flowershoprepository.add(flowershop);

		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Operació cancel·lada, no s'ha pogut crear la floristeria", "Alerta", JOptionPane.ERROR_MESSAGE);

		}		
	}

	//Mètode per chequear si una floristeria ja está creada
	public boolean checkFlowerShopName(String flowershopname) {
		List<FlowerShop> flowershoprepository = FlowerShopRepository.getAllFlowerShops();
		boolean checkflowershopname=false;
		
		if (flowershoprepository.size()>0) {
			for (FlowerShop l : flowershoprepository) {
				if (l.getName().equals(flowershopname)){
					checkflowershopname=true;
					break;
				}				
			}
		}
		return checkflowershopname;	
	}
	
	//Mètode per entrar el nom de la floristeria
	public String inputFlowerShopName() {
		String flowershopname="";
		
		do {
			flowershopname=	JOptionPane.showInputDialog(null,"Introdueix el nom de la floristeria:","ENTRADA",JOptionPane.QUESTION_MESSAGE);	
			if (flowershopname != null)  flowershopname=flowershopname.trim().toUpperCase();
			else {
				flowershopname="";
				break;
			}
		}while(flowershopname.isBlank() || flowershopname.isEmpty()); //Chequear que s'introdueixi algun caràcter

		return flowershopname;
	}
	
	public String stock () {
		
		List<FlowerShop> flowershoprepository = FlowerShopRepository.getAllFlowerShops();
		StringBuilder output = new StringBuilder();
		
		if (flowershoprepository.size()>0) {
			
			String flowershopname=inputFlowerShopName(); //Crida al mètode per introduïr el nom de la floristeria
			boolean existsflowershop=false;
			if (flowershopname != "") {
				existsflowershop = checkFlowerShopName(flowershopname);
			}
				
			if (existsflowershop) {
				
				for (FlowerShop l : flowershoprepository) {
					if (l.getName().equals(flowershopname)) {
						output.append("Floristeria: " + l.getName() + "." + "\n");
						output.append("ARBRES: " +  l.getTreesString() + "." + "\n");
						output.append("FLORS: " + l.getFlowersString() + "." + "\n");
						output.append("DECORACIÓ: " + l.getDecorationString() + "." + "\n");
					}					
				}
				
			} else {				
				JOptionPane.showMessageDialog(null, "La floristeria que demanes no existeix !!", "Alerta", JOptionPane.ERROR_MESSAGE);
			}
		} else {			
			JOptionPane.showMessageDialog(null, "No hi ha cap floristeria creada !!", "Alerta", JOptionPane.ERROR_MESSAGE);
		}				
		return output.toString();
	}	
}