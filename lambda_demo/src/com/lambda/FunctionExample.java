package com.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {
	public static void main(String[] args) {
		
		String s = "BasicsStrong";
		
		List<String> str= new ArrayList<String>();
		 str.add("abc");
		 str.add("qwe");
		 str.add("zxc");
		 
		Function<List<String>,Integer> fun = str1 -> str1.size();
		
		int len = fun.apply(str);
		System.out.println(len);
	}
}
