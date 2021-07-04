package com.generics;

//Parameterized class/generic class/template class
//type-safe
//T stands for parameter type
public class Box<T> implements GenericInterfaceDemo<T>{
	
	private T t;
	
	Box(T t){
		this.t = t;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	public void showType() {
		System.out.println("Type: "+t.getClass().getName());
	}

	@Override
	public void boxShape(T t) {
		System.out.println("Shape is "+t);		
	}

	/*
	 * //if we don't specify<T> in implements GenericInterfaceDemo<T>
	 * 
	 * @Override public void boxShape(Object t) { // TODO Auto-generated method stub
	 * 
	 * }
	 */

}
