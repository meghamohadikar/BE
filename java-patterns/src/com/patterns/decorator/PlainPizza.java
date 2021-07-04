package com.patterns.decorator;

public class PlainPizza implements Pizza{

	@Override
	public void bake() {
		System.err.println("baking plain pizza");
	}

}
