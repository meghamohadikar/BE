package com.patterns.prototype; 
  
abstract class Color implements Cloneable { 
      
    protected String colorName; 
       
    abstract void addColor(); 
       
    public Object clone() 
    { 
        Object clone = null; 
        try 
        { 
        	System.out.println("clonning");
            clone = super.clone(); 
        }  
        catch (CloneNotSupportedException e)  
        { 
            e.printStackTrace(); 
        } 
        return clone; 
    } 
}