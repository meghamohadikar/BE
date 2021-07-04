package com.set;

import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetDemo {

	public static void main(String[] args) {

		//assigning treeSet object to navigableSet reference
				NavigableSet<Integer> data = new TreeSet<Integer>();
				
				//adding elements
				data.add(1000);
				data.add(13000);
				data.add(40000);
				data.add(54000);
				data.add(3000);
				System.out.println("---- Tree Set ----");
				System.out.println(data);
				System.out.println("-----------------------------------------");
				
				//Methods
				
				System.out.println(data.floor(13550));  //equals or nearest less than 13550 else null
				
				System.out.println(data.lower(13000)); //nearest lower to 14000
				
				System.out.println(data.ceiling(2500));  //nearest greater to 2500
				
				System.out.println(data.higher(3000));  //nearest greater
				
				System.out.println(data.pollFirst());  //retrieve and remove 1st element
				
				System.out.println(data.pollLast());  //retrieve and remove last element
				
				System.out.println(data.descendingSet()); // returns elements in descending order
				
	}

}
