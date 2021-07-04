package com.generics;

import java.util.ArrayList;

//generics provide type checking at compile time
public class TypeErasureDemo {
	public static void main(String[] args) {

		ArrayList l = new ArrayList<String>(); // JVM use type erasure feature to remove <String> generic syntax,so it becomes raw type at runtime
		l.add(10);
		l.add(true);
		System.out.println(l);
		
		ArrayList<String> al =new ArrayList<String>(); //only allowed to passs string values
		al.add("Basics");
		al.add("Strong");
		
		ArrayList<String> alNew =new ArrayList();//only allowed to passs string values
		alNew.add("Basics");
		alNew.add("Strong");
		alNew.add(10);
	}
	
	//both methods are same at compiletime when it gets compiled again
	public static void method1(ArrayList<String> l) {} //remove <String> generic syntax
	
	public static void method1(ArrayList<Integer> l) {}//remove <Integer> generic syntax

}
