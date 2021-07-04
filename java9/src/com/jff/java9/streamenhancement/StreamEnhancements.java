package com.jff.java9.streamenhancement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEnhancements {
	static List<Integer> marksList = Arrays.asList(50, 60, 80, 90, 40);

	public static void main(String args[]) {
		takeWhile();
		dropWhile();
		ofNullable();

	}

	public static void takeWhile() {
		List<Integer> tempList = marksList.stream().takeWhile(i -> i <80).collect(Collectors.toList());//stOps when condn is false
		System.out.println("takeWhile: " + tempList);//50,60

	}
	public static void dropWhile() {
		 
		List<Integer> tempList = marksList.stream().dropWhile(i -> i <80).collect(Collectors.toList());//start when condn is false
		System.out.println("DropWhile: " + tempList);//80,90,40,30

	}
	public static void ofNullable() {
		List<Integer> nullList = null;
		List<Integer> marksList = Arrays.asList(50, 60, 80, 90, 40);
		List tempList = Stream.ofNullable(nullList).collect(Collectors.toList());
		List tempList2 = Stream.ofNullable(marksList).collect(Collectors.toList());
		System.out.println("ofNullable: " + tempList);
		System.out.println("ofNullable tempList2: " + tempList2);

	}

	

}
