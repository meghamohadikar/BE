package com.cursors;

import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;

public class EnumDemo {
	public static void main(String[] args) {
		Vector v=new Vector();
		System.out.println("Enter the elements :");
		for(int i=0;i<9;i++) {
			Scanner s=new Scanner(System.in);
			Integer data = s.nextInt();
			v.addElement(data);
		}
		System.out.println("Vector : " + v);
		
		Enumeration e=v.elements(); // create equivalent enum object to v
		while(e.hasMoreElements()) {
			Integer element=(Integer) e.nextElement();
			if((element%3)==0)
				System.out.println(element);
		}
	}
	

}
