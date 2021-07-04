package com.patterns.singleton;

import java.io.Serializable;

public class Singleton implements Serializable,Cloneable {
	
	private static final long serialVersionUID = 1L;
	//Volatile means “keep on changing, it is not fixed”.
	private static volatile Singleton instance;//=new Singleton(); //eager initialization of instance
	
	/*
	 * static { //initialization of instance in static block 
	 * instance=new Singleton(); 
	 * }
	 */
	
	private Singleton() { //private constructor
		
	}
	
	public static Singleton getInstance() { //static method to get instance of the class
		
		//lazy initialization of instance is preferred
		//synchronized(instance) { //synchronized can have object name or class name
		if(instance==null) { //if not null, returns existing instance
		synchronized (Singleton.class) {
		System.out.println("instance is null"); 
		instance=new Singleton();
		}
		
		}
		System.out.println(instance); 

		return instance;
	}
	
	/* instead of synchronizing whole method we can make if method synchronized
	 * public static synchronized Singleton getInstance() { //static method to get instance of the class
	 * //lazy initialization of instance is preferred 
	 * if(instance==null) { //if not null, returns existing instance System.out.println("instance is null");
	 * instance=new Singleton(); 
	 * } 
	 * return instance;
	 * }
	 */
	
	protected Object readResolve() { //invoke internally after deserialization
		return instance; //return same instance as created in getInstance()
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException { //to restrict instance to get cloned
		return new CloneNotSupportedException();
	}
	
	
}
