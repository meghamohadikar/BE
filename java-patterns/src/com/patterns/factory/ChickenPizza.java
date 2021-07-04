package com.patterns.factory;

public class ChickenPizza implements Pizza {

	@Override
	public void prepare() {
		System.out.println("Preparing the ChickenPizza");
		
	}

	@Override
	public void bake() {
		System.out.println("Baking the ChickenPizza");

		
	}

	@Override
	public void cut() {
		System.out.println("Cutting the ChickenPizza");

		
	}

}
