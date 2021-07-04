package com.patterns.decorator;

public class Test {

	public static void main(String[] args) {
		Pizza pizza=new PlainPizza();
		pizza.bake();
		
		Pizza cheesepizza=new CheesePizzaDecorator(new PlainPizza());
		cheesepizza.bake();
		
		Pizza cheeseveggiepizza=new CheesePizzaDecorator(new VeggiePizzaDecorator(new PlainPizza()));
		cheeseveggiepizza.bake();
	}

}
