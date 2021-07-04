package com.patterns.prototype;

public class Test { 
	    public static void main (String[] args) 
	    { 
	        ColorStore.getColor("blue").addColor(); 
	        ColorStore.getColor("black").addColor(); 
	        ColorStore.getColor("black").addColor(); 
	        ColorStore.getColor("blue").addColor(); 
	    } 
}
