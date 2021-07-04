package com.generics;

public class UseBoxs {
	public static void main(String[] args) {

		//Box<String> b = new Box<String>("");		Bound Mismatch
		Boxs<Integer> b = new Boxs<Integer>(10);
		//Boxs<Number> b = new Boxs<Number>(10);
		int x = b.getSize();
		System.out.println("Size: "+x);
				
	}

}
