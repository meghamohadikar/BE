package com.generics;

public class Execution implements Operations {

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int diff(int a, int b) {
		return a-b;
	}

	@Override
	public int prod(int a, int b) {
		return a*b;
	}

	@Override
	public int div(int a, int b) {
		return a/b;
	}

}
