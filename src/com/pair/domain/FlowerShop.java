package com.pair.domain;

import java.util.ArrayList;

public class FlowerShop {

	private String name;	
	private ArrayList<FlowerShopObject> flowershopobject = new ArrayList<FlowerShopObject>();
		
	private ArrayList<Tree> trees;
	private ArrayList<Flower> flowers;
	private ArrayList<Decoration> decoration;
		
		public FlowerShop (String name, ArrayList<Tree> trees, ArrayList<Flower> flowers, ArrayList<Decoration> decoration) {
								
			this.name = name;
			this.trees = trees;
			this.flowers= flowers;	
			this.decoration = decoration;
		}
		
		public FlowerShop (String name) {
			this.name=name;
		}
		
		public String getName() {
			return name;
		}		
		
		public String getTreesString () {
			
			String treesInfo = "";			
			for (Tree t : trees) {				
				treesInfo += ("[A: " + t.getHeight() + ("cm, PVP: ") + t.getPrice() + "€]");		
				}					
			return treesInfo;				
		}	
		
		public String getFlowersString () {
			
			String flowersInfo = "";			
			for (Flower f : flowers) {				
				flowersInfo += ("[C: " + f.getColour() + (", PVP: ") + f.getPrice() + "€]");		
				}					
			return flowersInfo;				
		}	
		
		public String getDecorationString () {
			
			String decoInfo = "";			
			for (Decoration d : decoration) {				
				decoInfo += ("[M: " + d.getMaterial() + (", PVP: ") + d.getPrice() + "€]");		
				}					
			return decoInfo;				
		}	
		
		public ArrayList<Tree> getTrees() {
			return trees;
		}

		public void setTrees(ArrayList<Tree> trees) {
			this.trees = trees;
		}		

		public ArrayList<Flower> getFlowers() {
			return flowers;
		}

		public void setFlowers(ArrayList<Flower> flowers) {
			this.flowers = flowers;
		}
		
		public ArrayList<Decoration> getDecoration() {
			return decoration;
		}

		public void setDecoration(ArrayList<Decoration> decoration) {
			this.decoration = decoration;
		}	

		public ArrayList<FlowerShopObject> getFlowershopobject() {
			return flowershopobject;
		}

		public void setFlowershopobject(ArrayList<FlowerShopObject> flowershopobject) {
			this.flowershopobject = flowershopobject;
		}				
}