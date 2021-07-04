package com.generics;

//multiple type parameters
public class Boxes<T,E> {
	private T size;
	private E shape;
	

	Boxes(T t,E e){
		this.size = t;
		this.shape = e;
	}

	public T getSize() {
		return size;
	}

	public void setSize(T t) {
		this.size = t;
	}

	public E getShape() {
		return shape;
	}

	public void setShape(E shape) {
		this.shape = shape;
	}

}
