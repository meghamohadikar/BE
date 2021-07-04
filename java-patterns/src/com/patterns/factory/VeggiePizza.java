package com.patterns.factory;

public class VeggiePizza implements Pizza {

	@Override
	public void prepare() {
		System.out.println("Preparing the VegiePizza");
		
	}

	@Override
	public void bake() {
		System.out.println("Baking the VegiePizza");

		
	}

	@Override
	public void cut() {
		System.out.println("Cutting the VegiePizza");

		
	}

}
