package com.patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
	//if desired shape object is already existing,reuse it otherwise create new
	//only creates 2 object(1 for rectangle,1 for circle)
	private static Map<String, Shape> shapes = new HashMap<>(); //act as a cache
	
	public static Shape getShape(String type) {
		Shape shape = null;
		if (shapes.get(type) != null) {
			shape = shapes.get(type);
		} else {
			if (type.equals("circle")) {
				shape = new Circle();
			} else if (type.equals("rectangle")) {
				shape = new Rectangle();
			}
			shapes.put(type, shape);
		}
		return shape;
		
	}

}
