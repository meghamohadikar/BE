package programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseASentence {
	public static void main(String args[]) {
		String sentence="My name is Anthony Gonsalves";
		System.out.println(reverseSentence(sentence));
		System.out.println(reverseString("Megha"));
		
		String str="megha";
		String reversed=Arrays.asList(str).stream().map(x->new StringBuilder(x).reverse().toString()).collect(Collectors.joining("."));
		System.out.println("reverse string using java 8="+reversed);
	  }

//using inbuilt function reverse()
	private static String reverseSentence(String sentence) {
		List<String> list=Arrays.asList(sentence.split("\\s"));
		Collections.reverse(list);
		StringBuilder sb = new StringBuilder(sentence.length()); 
		for (int i = 0; i <list.size(); i++) {
			sb.append(list.get(i)); 
			sb.append(' '); 
		}
		return sb.toString().trim();
	}
	private static String reverseString(String string) { 
		char[] strArray=string.toCharArray();
		String reverse="";
		for(int i=string.length()-1;i>=0;i--) {
			reverse=reverse+strArray[i];
		}
		return reverse;
		
	}
}
