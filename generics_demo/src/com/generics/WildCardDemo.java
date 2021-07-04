package com.generics;

import java.util.ArrayList;
import java.util.List;

public class WildCardDemo {

	public static void main(String[] args) {
		
		List<Integer> ints = new ArrayList<>();
		ints.add(1);
		ints.add(2);
		method1(ints);
		
		List<String> str = new ArrayList<>();
		str.add("Hello");
		str.add("BasicsStrong");
		method1(str);
		
		method2(ints);
		
		Runnable r = new Thread();
		List<Runnable> lr = new ArrayList<>();
		lr.add(r);
		//method3(lr);
		
		List<Number> intss = new ArrayList<>();
		intss.add(1);
		intss.add(2);
		method3(intss);
		
		Runnable ra = new Thread();
		List<Runnable> lre = new ArrayList<>();
		lre.add(r);
		method4(lr);
		
		List<Object> lo = new ArrayList<>();
		method4(lo);
	}
	
	//unbounded wildcard:independent of parameter type
	public static void method1(List<?> l) {
		System.out.println(l);
	}
	
	//upper bounded wildcard:Number and it's all subclasses are allowed
	public static void method2(List<? extends Number> l) {
		System.out.println(l);
	}

	//lower bounded wildcard:
	//1.Integer and it's all superclasses are allowed
	public static void method3(List<? super Integer> l) {
		System.out.println(l);
		l.add(1);
	}
	
	//2.Runnable interface and all superclasses of it's implementation class are allowed
		public static void method4(List<? super Runnable> l) {
			System.out.println(l);
		}
}
