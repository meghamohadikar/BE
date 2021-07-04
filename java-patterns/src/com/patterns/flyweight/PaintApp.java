package com.patterns.flyweight;

public class PaintApp {
	
	public void render(int numberOfShapes) {
		Shape shape = null;

		for (int i = 1; i <= numberOfShapes; i++) {
			if (i % 2 == 0) {
				shape = ShapeFactory.getShape("circle");
				shape.draw(i, "red", "white");
			} else {
				shape = ShapeFactory.getShape("rectangle");
				shape.draw(i, i + i, "dotted");
			}
		}
		
		
		
		/*
		 * Shape[] shapes=new Shape[numberOfShapes]; 
		 * //for each circle and rectangle,new object is getting instantiated 
		 * for(int i=0;i<numberOfShapes;i++) {
		 * if(i%2==0) {// if index is even 
		 * shapes[i]=new Circle();
		 * ((Circle)shapes[i]).setRadius(i); 
		 * ((Circle)shapes[i]).setFillcolor("white");
		 * ((Circle)shapes[i]).setLinecolor("red"); 
		 * shapes[i].draw(); 
		 * }else {
		 * shapes[i]=new Rectangle(); 
		 * ((Rectangle)shapes[i]).setLength(i*2);
		 * ((Rectangle)shapes[i]).setWidth(i);
		 * ((Rectangle)shapes[i]).setFillstyle("dotted"); 
		 * shapes[i].draw();
		 *  }
		 * 
		 * }
		 */
		
		
	}

}
