package com.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GenericCollectionObjects {
	public static void main(String[] args) {
		List<?> l = new ArrayList<?>();
		
		List<?> li = new ArrayList<Integer>();
		
		List<?> ls = new ArrayList<String>();
		
		List<? extends Number> l = new ArrayList<Integer>();
		
		//List<? extends Number> l = new ArrayList<String>();
		
		List<? super String> lo = new ArrayList<Object>();
		
		List<?> list = new ArrayList<? extends Number>();
		
		List<Integer> lst = new ArrayList<? extends Number>();
		
		HashMap<?,?> map = new HashMap<Integer,String>();
	}
}
