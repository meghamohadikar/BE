package com.lambda;

@FunctionalInterface //
public interface ValidFunInterface2 {
	public void method1(); //by default,abstract

	// Default Method
	default void method2() {

	}

	// Static Method
	static void method3() {

	}
}
