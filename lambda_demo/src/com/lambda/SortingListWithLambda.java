package com.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingListWithLambda {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(5);
		list.add(0);
		list.add(3);
		list.add(11);
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list); //for natural sorting
		
		Collections.sort(list,new MyComparator());
		System.out.println(list); //for desc order  without lambda
		
		Collections.sort(list,(o1,o2) -> {if(o1 > o2) {
			return -1;
		}else if(o1 < o2) {
			return 1;
		}else {
			return 0;
		}});
		System.out.println(list);

	}
}


class MyComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1 > o2) {
			return -1;
		}else if(o1 < o2) {
			return 1;
		}else 
			return 0;
	}

	
}