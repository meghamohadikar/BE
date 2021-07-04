package com.generics;

//Calculator class is bounded to have only Operations and its implementation-class' parameter.
public class Calculator<T extends Operations> { //always go for extends not implements

	private T obj;
	
	Calculator(T obj){
		this.obj = obj;
	}

	public T getObj() {
		return obj; //return e
	}
}
