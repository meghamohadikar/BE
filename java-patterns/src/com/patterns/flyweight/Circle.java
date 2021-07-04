package com.patterns.flyweight;

public class Circle extends Shape{//implements Shape {
	//extrinsic fields: fillcolor,radius,linecolor
		private String label;
		/*
		 * private String fillcolor;
		 *  private int radius;
		 *   private String linecolor;
		 */
	
	public Circle() { 
		label="circle";
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	/*
	 * public String getFillcolor() { return fillcolor; }
	 * 
	 * public void setFillcolor(String fillcolor) { this.fillcolor = fillcolor; }
	 * 
	 * public int getRadius() { return radius; }
	 * 
	 * public void setRadius(int radius) { this.radius = radius; }
	 * 
	 * public String getLinecolor() { return linecolor; }
	 * 
	 * public void setLinecolor(String linecolor) { this.linecolor = linecolor; }
	 */

	/*
	 * @Override public void draw() { System.out.println("Drawing a "+label
	 * +" with radius= "+radius+" fillcolor= "+fillcolor+" linecolor= "+linecolor);
	 * 
	 * }
	 */

	@Override
	public void draw(int radius, String fillcolor, String linecolor) {
		System.out.println("Drawing a "+label +" with radius= "+radius+" fillcolor= "+fillcolor+" linecolor= "+linecolor);		
	}
}
