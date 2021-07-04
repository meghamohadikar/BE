package com.basics.arrays;

public class TypesOfArrays {


	public static void main(String[] args) {

		//Primitive array: holding boolean, byte, char, short, long, int, float, double
		boolean[] z=new boolean[1];
		int[] x = new int[3];
		//adding char in int array, it can be promoted to int(ASCII value)
		x[0] = 'a';
		System.out.println(x[0]);
		byte b = 2;
		x[1] = b;
		
		System.out.println(x[1]);

		
		
		//Object array: can contain declared type object itself and its subclasses
		
		Object[] objArray = new Object[5];
		objArray[0] = new Object();
		objArray[1] = new String();		//String is sub-class of Object
		
		
		//Abstract class type arrays
		//Number is an abstract class and we can't create object of abstract class,soit can't contain declared type object
		Number[] numArray = new Number[3];		//can not hold the number class object, because Number is an abstract class
		numArray[0] = new Integer(1);			//can store sub-class objects like Integer,Byte
		numArray[1] = new Byte("2");
		
		
		//Interface type arrays
		
		Runnable[] r = new Runnable[5];			//can hold only those class objects which are implementing this interface
		r[0] = new Thread();
		System.out.println(r[1]);
		
		}
}
