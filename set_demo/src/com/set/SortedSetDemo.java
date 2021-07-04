package com.set;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {

	public static void main(String[] args) {
		SortedSet s = new TreeSet();
		s.add(5);
		s.add(10);
		//s.add("abcd");  //gives ClassCastException
		s.add(2);
		s.add(1);
		s.add(3);
		s.add(7);
		System.out.println(s);
		
		//Methods in SortedSet Interface TreeSet Collection Integer
		
				//Object first()
				System.out.println(s.first());
				
				//Object last()
				System.out.println(s.last());
				
				//SortedSet headSet(Object o)
				System.out.println(s.headSet(5)); //elements before element 5
				
				//SortedSet tailSet(Object 0)
				System.out.println(s.tailSet(5)); //elements after 5 including 5
				
				//SortedSet subSet(Object o,Object p)
				System.out.println(s.subSet(3,7));  //subset including 3 
				
				//Comaparator comparator()
				System.out.println(s.comparator()); //returns sorting order.For default sorting order, it returns null
				
	}

}
