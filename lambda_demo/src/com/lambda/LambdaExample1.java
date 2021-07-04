package com.lambda;


public class LambdaExample1 {

	public static void main(String[] args) {
		MyFunInterface funInter = (a,b) -> System.out.println("The sum of a and b is: "+(a+b));
		funInter.funMethodAdd(10,20);
	}

}

interface MyFunInterface{
	public void funMethodAdd(int a, int b);
}