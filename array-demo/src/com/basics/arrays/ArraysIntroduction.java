package com.basics.arrays;

public class ArraysIntroduction {
	public static void main(String[] args) {
		int a = 12;
		int b = 13;
		int c = 14;
		
		int[] x = new int[1000];
		System.out.println(x.getClass().getName()); //"[" for 1D array and "I" for int

		//Zero as size
		int[] y = new int[0];
		
		//character as size
		int[] z = new int['a'];
		//allowed data types for an int array: byte,short,char and int
		
		//negative array size
		//int[] p = new int[-1]; //NegativeArraySizeException
		
		//size of an int array cannot be more than this:214748364
		int[] q = new int[2147483641];//OutOfMemoryError
		//2147483647*4 memory required to create this array.
		System.out.println(x.getClass());
		
		

	}
	
	
	

}
