package com.patterns.factory;

public class CheesePizza implements Pizza {

	@Override
	public void prepare() {
		System.out.println("Preparing the CheesePizza");
		
	}

	@Override
	public void bake() {
		System.out.println("Baking the CheesePizza");

		
	}

	@Override
	public void cut() {
		System.out.println("Cutting the CheesePizza");

		
	}

}
