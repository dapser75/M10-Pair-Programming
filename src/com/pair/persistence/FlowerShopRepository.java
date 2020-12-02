package com.pair.persistence;

import java.util.ArrayList;
import java.util.List;

import com.pair.domain.FlowerShop;

public class FlowerShopRepository {
	
	private static List<FlowerShop> flowershoplist= new ArrayList<>();
	
	public void addObject (FlowerShop flowershop) throws Exception{
		if (flowershop == null) throw new Exception();
			
		flowershoplist.add(flowershop);
	}
	
	public FlowerShopRepository () { }
	
	//Mètode per retornar tot el repositori
	public static List<FlowerShop> getAllFlowerShops(){
		return new ArrayList<>(flowershoplist);
	}

	public void add(FlowerShop flowershop) throws Exception {
		if (flowershop == null) throw new Exception();
		flowershoplist.add(flowershop);
		
	}	
}