package com.basics.arrays;

public class TraversingArrays {
 public static void main(String[] args) {
		//Traversing 1-D array

	 int[] a= new int[5];
	
	 //using for-each loop
	 for(int e:a) {
		 System.out.println(e);
	 }
	 int len=a.length;
	 System.out.println(len);
	 
	//using for loop
	 for(int i=0;i<len;i++) {
		 a[i]=i;
		 System.out.println("element at index "+i+" is: "+a[i]);
		 
	 }
	 
	//Traversing 2-D array
		
			int[][] b = new int[2][3];
			//using for-each loop
			for(int[] arr: b) {
				for(int e : arr) {
					System.out.println(e);
				}
			
			}
			 int le=b[1].length;
			 System.out.println(le);
			 
			//using for loop
				for(int i = 0;i<b.length;i++) {
					for(int j=0;j<b[i].length;j++) {
						b[i][j]=i;
						System.out.println(b[i][j]);
					}
				}
 }
 
}
