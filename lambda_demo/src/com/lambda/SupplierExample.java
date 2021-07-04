package com.lambda;

import java.util.function.Supplier;

public class SupplierExample {
	public static void main(String[] args) {
		Supplier<String> s = () -> "Supplying string and consuming nothing";
		System.out.println(s.get());
		
	}

}
