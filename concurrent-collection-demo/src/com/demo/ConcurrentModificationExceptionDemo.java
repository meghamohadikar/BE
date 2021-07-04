package com.demo;

import java.util.ArrayList;
import java.util.Iterator;

public class ConcurrentModificationExceptionDemo extends Thread{
	private static ArrayList<String> list = new ArrayList<String>();  //collection object
	
	public static void main(String[] args) {  //main thread
		list.add("John");
		list.add("Rohn");
		list.add("Tom");
		list.add("Shiva");
		
		Iterator<String> itr = list.iterator();
		
		ConcurrentModificationExceptionDemo tchild = new ConcurrentModificationExceptionDemo();
		tchild.start();
		
		while(itr.hasNext()) {
			String name = (String) itr.next();
			System.out.println("Main thread iterating ->"+name);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void run() { //second thread trying to modify collection object
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.add("Ganesh");
	}
	
}
