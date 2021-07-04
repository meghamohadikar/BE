package com.basics.arrays;

public class VariableAssignments {
	public static void main(String[] args) {
		int[] x = new int[2];
		int[] a = x;	//assigning x to a : 
		//No new array is created here,both pointing to the same array
		//i.e. we are referring single array with 2 different variable(a&x)
		x[0] = 1;
		System.out.println(x[0]);
		System.out.println(a[0]);
		a[1] = 2;
		System.out.println(x[1]);
		System.out.println(a[1]);
		
		
		//-----------------------------------
		
		int[] b = {1,2,3};
		int[] c = {11,22};
		b = c;	//b & c variables pointing to the {11,22} array and {1,2,3} becomes referenceless
		c = b;//both b and c will point same array {11,22}
		
		for(int e: b) {System.out.println(e);}
		System.out.println("_______________");
		for(int e: c) {System.out.println(e);}
		
		
		//-------------------
		
		String[] s = new String[3];
		Object[] objArr = s;   //parent class can hold child class
		
		short[] shorts = new short[2];  //[S
		//int[] ints = shorts;            //[I
		
		//short element can be promoted to int, but short array type object can not promoted to int array type.
	}

}
