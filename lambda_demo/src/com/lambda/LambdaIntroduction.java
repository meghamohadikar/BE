package com.lambda;

public class LambdaIntroduction {
	public static void main(String[] args) {
		//without lambda
		/*
		 * CallFunInterfaceClass funInter = new CallFunInterfaceClass();
		 * funInter.funMethod();
		 */
		
		//with lambda
		MyFunctionalInterface funInterLambda = () -> System.out.println("FunctionalMethod");
		funInterLambda.funMethod();
	}

}

@FunctionalInterface
interface MyFunctionalInterface{
	public void funMethod();
}

/*
 * class CallFunInterfaceClass implements MyFunctionalInterface{
 * 
 * @Override public void funMethod() { System.out.println("FunctionalMethod"); }
 * }
 */
