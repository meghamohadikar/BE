package com.generics;

//T bounded to Number
public class Boxs<T extends Number>{
	
	private T size;
	
	Boxs(T t){
		this.size = t;
	}

	public T getSize() {
		return size;
	}

	public void setSize(T t) {
		this.size = t;
	}

}
