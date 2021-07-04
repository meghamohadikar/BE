package com.generics;

public class UseBoxes {
	public static void main(String[] args) {

		Boxes<Integer,String> b = new Boxes<Integer,String>(12,"Square");
		int x = b.getSize();
		String y = b.getShape();
		System.out.println("Size: "+x+ ",Shape: "+y);
		
		//HashMap is example of such class..
		//HashMap<String,Integer> map = new HashMap<String,Integer>();
		
				
	}

}
