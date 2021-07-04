package com.patterns.factory;

public class PizzaStore {
	
	public Pizza orderPizza(String type) {
		/*Pizza p=null;
		 * if(type.equals("cheese")) { p=new CheesePizza(); }else
		 * if(type.equals("veggie")) { p=new VeggiePizza(); } else
		 * if(type.equals("chicken")) { p=new ChickenPizza(); }
		 */
		Pizza p=PizzaFactory.createPizza(type);
		p.prepare();
		p.bake();
		p.cut();
		return p;
		
	}

}
