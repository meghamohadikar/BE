package com.lambda;

public class LambdaExample {
	public static void main(String[] args) {
		FunInterfaceExample i = () -> System.out.println("Function without any argument and return type!,Implemented using lambda");
		i.funMethod();
	}

}

interface FunInterfaceExample{
	public void funMethod();
}

