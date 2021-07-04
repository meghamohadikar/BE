package com.cursors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 
 * @author mmohadik
 * @apiNote FOR TEST
 */
public class ItrDemo {
	public static void main(String[] args) {
		
		ArrayList<Integer> a=new ArrayList<Integer>();
		System.out.println("Enter the elements :");
		for(int i=0;i<9;i++) {
			Scanner s=new Scanner(System.in);
			Integer data = s.nextInt();
			a.add(data);
		}
		System.out.println("ArrrayList : " + a);
		
		Iterator itr=a.iterator(); //create equivalent iterator object to a
		while(itr.hasNext()) {
			Integer element=(Integer) itr.next();
			if((element%3)==0)
				System.out.println(element);
			else
				//a.remove(element);
				itr.remove(); //removes last returned element from collection
		}
		System.out.println("ArrrayList after: " + a);
		
		
		
	}
}
