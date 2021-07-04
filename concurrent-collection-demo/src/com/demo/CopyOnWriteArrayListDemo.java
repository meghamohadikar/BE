package com.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
	//static ArrayList<String> list = new ArrayList<String>();
		static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		
		public static void main(String[] args) {
			
			list.add("John");
			list.add("Rohn");
			list.add("Harry");
			list.add("Potter");
			
			System.out.println(list);

			Iterator<String> itr = list.iterator();
			while(itr.hasNext()) {
				String name = (String) itr.next();	
				if(name.equals("Harry")) {
					itr.remove();  //iterator of 
				}
				}
			System.out.println(list);
		}
}
