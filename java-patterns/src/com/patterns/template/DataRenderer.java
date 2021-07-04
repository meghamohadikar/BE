package com.patterns.template;

public abstract class DataRenderer {
 public void render() { //template method
	 String data=readData();
	 String processedData=processData(data);
	 System.out.println("processedData="+processedData);
	 
 }
 public abstract String readData();
 
 public abstract String processData(String data);
 
 
}
