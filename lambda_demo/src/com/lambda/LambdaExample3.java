package com.lambda;

public class LambdaExample3 {

	public static void main(String[] args) {
		MyFunInterface3 i = a -> {
			int x = a + 10;  //110
			x = x/2; //55
			return x;
		};
		int op= i.doSomeCalculation(100);
		System.out.println(op);
		
		
	}

}

interface MyFunInterface3{
	public int doSomeCalculation(int a);
}

