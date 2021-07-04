package com.generics;

public class MyClass {

	public static void main(String[] args) {
		//Calculator class is bounded to have only Operations and its implementation-class' parameter.
				Operations e = new Execution();
				Calculator<Operations> cal = new Calculator<Operations>(e);
				
				
				int addition = cal.getObj().add(10, 20);
				//similar to int addition = e.add(10, 20);
				System.out.println(addition);
	}

}
