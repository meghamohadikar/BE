package com.generics;

public class Boxess {
	private int size;
	
	Boxess(int t){
		this.size = t;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int t) {
		this.size = t;
	}
	
	//generic method
	public <T extends Number> void showType(T obj) {
		System.out.println("Type: "+obj.getClass().getName());
	}	
	

}
