package com.cursors;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.TreeSet;

public class ListItrDemo {

	public static void main(String[] args) {
		ArrayList<String> data = new ArrayList<>();
		
		data.add("Raj");
		data.add("Ramesh");
		data.add("Amrish");
		data.add("jai");
		data.add("Khushal");
		//data.add(null);
		
		System.out.println(data);
		
		//TreeSet s=new TreeSet(data);
		//System.out.println(s);

		//creating listIterator object for arrayList data
		ListIterator listItr=data.listIterator();  //bidirectional cursor
		while(listItr.hasNext()) {
			String item = (String)listItr.next();
			/*
			 * if(item.equals(null)) { listItr.remove();//add value }
			 */
			if(item.equals("jai"))
			{
				listItr.add("veeru"); //add value
			}
			if(item.equals("Raj"))
			{
				listItr.remove();   //remove value
			}
			if(item.equals("Amrish"))
			{
				listItr.set("Amresh"); //replace value
			}
			
		}
		System.out.println(data);

	}

}
