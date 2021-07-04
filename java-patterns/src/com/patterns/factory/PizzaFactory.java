package com.patterns.factory;

public class PizzaFactory { //factory class to create object 
	public static Pizza createPizza(String type) {
		Pizza p=null;
		if(type.equals("cheese")) {
			  p=new CheesePizza(); 
		}else if(type.equals("veggie")) { 
			p=new VeggiePizza(); 
		} else if(type.equals("chicken")) {
				p=new ChickenPizza(); 
		}

		return p;
		
	}

}
