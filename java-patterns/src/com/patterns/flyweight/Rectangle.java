package com.patterns.flyweight;

public class Rectangle extends Shape{ //implements Shape {
	private String label;
	//extrinsic fields(nothing to do with other classes i.e Circle):fillstyle,length,width
	/*
	 * private String fillstyle; 
	 * private int length; 
	 * private int width;
	 */
	
	public Rectangle() { 
		label="rectangle";
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	/*
	 * public String getFillstyle() { return fillstyle; }
	 * 
	 * public void setFillstyle(String fillstyle) { this.fillstyle = fillstyle; }
	 * 
	 * public int getLength() { return length; }
	 * 
	 * public void setLength(int length) { this.length = length; }
	 * 
	 * public int getWidth() { return width; }
	 * 
	 * public void setWidth(int width) { this.width = width; }
	 */
	
	@Override
	public void draw(int length,int width,String fillstyle) {
		System.out.println("Drawing a "+label +" with length= "+length+" width= "+width+" fillstyle= "+fillstyle);
	}

	/*
	 * @Override 
	 * public void draw() { 
	 * System.out.println("Drawing a "+label +" with length= "+length+" width= "+width+" fillstyle= "+fillstyle);
	 * 
	 * }
	 */

}
