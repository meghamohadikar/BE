package com.basics.arrays;

public class ArrayDemo {
	public static void main(String[] args) {
		
		int[] x; //declaration
		//x= {2,3}; //can't initialize already declare array
		int[] y= {1,2,3,4,5}; //declaration and initialization
		int[] z=new int[3]; //initialize {0,0,0} by default
		System.out.println(z[0]);
		z[0]=1;
		
		for(int e:z) {
			System.out.println(e);

		}
		System.out.println(z); //reference to the array

		//declaring 2-D array
				int[][] a;
				
				//declaring and creating 2-D array with base size 2
				int[][] b = new int[2][];
				//there is nothing at the 0th position of b.
				System.out.println(b[0]); //null
				//System.out.println(b[0][0]);	//null pointer exception
				b[0] = new int[2];
				b[1] = new int[3];
				System.out.println(b[0][0]);
				
				b[0][0] = 55;
				System.out.println(b[0][0]);
				
				
				int[][] c = {{1,2,3},{6,7}};
				
				//printing 2-D array
				for(int[] array: c) {
					for(int ele : array) {
						System.out.println(ele);
					}
				}
	}

}
