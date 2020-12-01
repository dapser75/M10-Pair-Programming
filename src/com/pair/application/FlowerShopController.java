package com.pair.application;

import java.util.List;

import javax.swing.JOptionPane;

import com.pair.domain.FlowerShop;
import com.pair.persistence.FlowerShopRepository;


public class FlowerShopController {

	private FlowerShopRepository flowershoprepository = new FlowerShopRepository();

	public FlowerShopRepository repository; 	
	
	public FlowerShopController(FlowerShopRepository repository){  // constructor
		
		this.repository = repository;
		
	}
	
	public FlowerShopController() {}

	//Métode per donar d'alta una nova floristeria
	public void NewFlowerShop () {
		String flowershopname="";
		boolean existsflowershop=false;
		
			flowershopname=InputFlowerShopName(); //Llamada al metode per introduir el nom de la floristeria
			if (flowershopname != "") {
				existsflowershop = checkFlowerShopName(flowershopname);
				
				if (!existsflowershop)  FlowerFhopCreated(flowershopname);
				else JOptionPane.showMessageDialog(null, "Floristeria existent !!!", "Alerta", JOptionPane.ERROR_MESSAGE);
					
			
			}
			else {
				JOptionPane.showMessageDialog(null, "Operació cancel·lada", "Alerta", JOptionPane.ERROR_MESSAGE);
				
			}		
	}//end metode


	//Métode per afegir al una floristeria al repository
	private void FlowerFhopCreated(String flowershopname) {
		try {
			FlowerShop flowershop = new FlowerShop (flowershopname);
			flowershoprepository.add(flowershop);

		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Operació cancel·lada, no s'ha pogut crear la floristeria", "Alerta", JOptionPane.ERROR_MESSAGE);

		}		
	}

	//Métode per chequear si una floristeria ja està creada
	public boolean checkFlowerShopName(String flowershopname) {
		List<FlowerShop> flowershoprepository = FlowerShopRepository.getAllFlowerShops(); //Chequear el casting
		boolean checkflowershopname=false;
		
		if (flowershoprepository.size()>0) {
			for (FlowerShop l : flowershoprepository) {
				if (l.getName().equals(flowershopname)){
					checkflowershopname=true;
					break;
				}
				
			}//end for
		}
		return checkflowershopname;	
	}
	
	//Métode per entrar el nom de la floristeria Cambiar a entrada en modo gráfico
	public String InputFlowerShopName() {
		String flowershopname="";
		do {
			flowershopname=	JOptionPane.showInputDialog(null,"Introdueix el nom de la floristeria:","ENTRADA",JOptionPane.QUESTION_MESSAGE);	
			if (flowershopname != null)  flowershopname=flowershopname.trim().toUpperCase();
			else {
				flowershopname="";
				break;
			}
		}while(flowershopname.isBlank() || flowershopname.isEmpty()); //Chequear que se introdueixi algun caracter

		return flowershopname;
	}
	
	/*@Override
	public String toString () {
		
		StringBuilder output = new StringBuilder();
		output.append("Floristeria: ");
		output.append(repository.getName());
		output.append("P:");
		output.append(getRocket().getRocketCurrentPower() +"\n");
		
		if (getTargetPower() == getRocket().getTotalCurrentPower()) {
			
			output.append(" ---> El coet: " + getRocket().getCode() + " ha arribat a la potència objectiu." + "\n");
		
		} else if ((getTargetPower() > getRocket().getTotalCurrentPower()) && ( getTargetPower() > getRocket().getMaxTotPowerR()) && (getRocket().getTotalCurrentPower() ==  getRocket().getMaxTotPowerR())) {
			
			output.append(" ---> El coet: " + getRocket().getCode() + " ha arribat a la potència màxima, i no podrá assolir l'objectiu." + "\n");
		}
		
		return output.toString();
	}*/		
}