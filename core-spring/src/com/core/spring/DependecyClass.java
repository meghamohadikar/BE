package com.core.spring;

public class DependecyClass implements MainInterface{
	
	public DependecyClass(){
	      System.out.println("Inside DependecyClass constructor." );
	   }
	
	@Override
	public void method(){
		System.out.println("Inside DependecyClass method");
	}
}
