package com.patterns.decorator;

public class CheesePizzaDecorator extends PizzaDecorator {

	public CheesePizzaDecorator(Pizza pizza) {
		super(pizza);
	}
	
	public void bake() {
		super.bake();
		System.out.println("adding cheese toppings");
	}

}
