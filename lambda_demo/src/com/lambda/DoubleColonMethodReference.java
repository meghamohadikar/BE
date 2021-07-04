package com.lambda;

public class DoubleColonMethodReference {
	public static void main(String[] args) {
		MyFunInterfaceNew funInter = () -> System.out.println("I am Lambda");
		funInter.method1(); //o/p: I am Lambda
	}
	//static
		public static void method2() {
			System.out.println("I am not a Lambda");
		}
		//instance
		public void method3() {
			System.out.println("i am here, refer to me");
		}

}

interface MyFunInterfaceNew{
	public void method1();
}


class NewCallerClass{
	public static void main(String[] args) {
		MyFunInterfaceNew i = DoubleColonMethodReference :: method2; //for static method reference
		i.method1();  //o/p:I am not a Lambda

		
		DoubleColonMethodReference obj = new DoubleColonMethodReference(); //for instance method reference
		MyFunInterfaceNew i1 = obj :: method3;
		i1.method1();//o/p:i am here, refer to me 
	}
}
