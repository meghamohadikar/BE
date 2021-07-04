package com.generics;

import java.util.ArrayList;
import java.util.List;

public class DataStructureDemo {
	public static void main(String[] args) {
		//type safety
		String[] strArray=new String[20];
		Employee[] empArray=new Employee[30];
		strArray[0]="Megha";
		strArray[1]=new Employee(); //string array can hold only string type elements
		
		//type casting
		ArrayList l=new ArrayList(); //accepts string and object
		l.add("Megha");  //string as object
		l.add(new Employee());
		String name=(String) l.get(0); //cast to string
		Employee nam=(Employee) l.get(0); //gives TypeCastException(runtime exception)
		
		//raw-type(<> without arguments)
		//sub-typing(ArrayList is sub-type(child) of List,sub-type is not applicable to arguments
		List<Object> ll = new ArrayList<String>();
		List ll = new ArrayList();
		 ll.add("John");
		 ll.add(10);
		 for(Object o: ll) {
			 String str = (String) o;
		 }
		 
		 ArrayList<String> ls = new ArrayList<String>(); //generics
		 ls.add("John");
		 //l.add(10)
		 for(String o: ls) {
			 String str = o;
		 }
	}

}
