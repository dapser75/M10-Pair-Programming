package com.pair.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.pair.application.FlowerController;
import com.pair.application.FlowerShopController; //////////////
import com.pair.application.TreeController;


public class FlowerSheet extends JPanel {
	
	private JPanel mySheet2;
	private JButton screen;
	//private boolean principio;
	//private double resultado;
	//private String ultimaOperacion;
	
	private FlowerShopController flowershopcontroller = new FlowerShopController();
	private TreeController treeController = new TreeController();
	private FlowerController flowerController = new FlowerController();
	
	public FlowerSheet () {
	
		//principio = true;
		setLayout(new BorderLayout ());
		screen = new JButton("");
		screen.setEnabled(false);
		//setBounds(500,300,750,200);
		add(screen,BorderLayout.NORTH); 
		mySheet2 = new JPanel();

		
		ActionListener insertar = new InstertOrder ();

		//mySheet2.setLayout(new GridLayout(4,4));

		//ActionListener orden = new AccionOrden();
		
		ponerBoton("Crear Floristeria", insertar);
		ponerBoton("Afegir Arbre", insertar);
		ponerBoton("Afegir Flor", insertar);
		//ponerBoton("/", orden);

		ponerBoton("Afegir Decoració", insertar);

		ponerBoton("Stock", insertar);
		//ponerBoton("*", orden);
						
		add(mySheet2, BorderLayout.SOUTH);
		
		//ultimaOperacion = "=";
	}
 
	private void ponerBoton(String tittle, ActionListener listener) {
		
		JButton button = new JButton (tittle);
		button.addActionListener(listener);
		mySheet2.add(button);
	}	
	
	private class InstertOrder implements ActionListener {


		@Override
		public void actionPerformed(ActionEvent e) {
			
			String entrada = e.getActionCommand();	
			
			screen.setText(entrada);			
		//		screen.setText(screen.getText() + entrada);
			
			//@dapser75 REVISAR el metodo de llamada
			if (entrada.equals("Crear Floristeria")) flowershopcontroller.NewFlowerShop();
			if (entrada.equals("Afegir Arbre")) treeController.addTree();
			if (entrada.equals("Afegir Flor")) flowerController.addFlower();
			if (entrada.equals("Stock")) flowerController.toString();	

		}	
	}
}