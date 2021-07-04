package com.set;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSetDemo {

	public static void main(String[] args) {
		HashSet a=new HashSet(); //be default,size=16 with 0.75 load factor means when a gets filled 75%, it doubles the size
		HashSet b=new HashSet(30); //size=30 with 0.75 load factor

		//creating hashSet with specified size and load factor 
		HashSet hs3 = new HashSet(100,.80f); //size=100 with 80% load factor,new size will be 200
		
		ArrayList l = new ArrayList();
		//creating equivalent hashSet of arrayList
		HashSet hs4 = new HashSet(l);
		
	}

}
