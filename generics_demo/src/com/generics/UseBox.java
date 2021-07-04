package com.generics;

public class UseBox {
	public static void main(String[] args) {

		Box<String> b = new Box<String>("BasicsStrong");
		//Box<String> b1 = new Box<String>(10);
		Box<Integer> b2 = new Box<Integer>(10);
		b.showType();
		String str = b.getT();
		System.out.println(str);
		
		b.boxShape("Square");
		
		//Callable is an example of generic interface
		
		Boxes<Integer,String> box=new Boxes<Integer,String>(1,"strong");
		int x=box.getSize();
		String y=box.getShape();
		System.out.println(x);
		System.out.println(y);
		
		Boxs<Number> a=new Boxs<Number>(10);
		Boxs<Integer> a1=new Boxs<Integer>(10);
	}

}
