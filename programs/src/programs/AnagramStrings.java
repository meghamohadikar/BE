package programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AnagramStrings {
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter first string:");
	String s1=sc.next();
	System.out.println("Enter second string:");
	String s2=sc.next();
	if(checkAnagramWithoutJava8(s1, s2))
        System.out.println(s1+" and "+s2+" are Anagrams");
    else
        System.out.println(s1+" and "+s2+" are NOT Anagrams");
    
    sc.close();
	}
    

	private static boolean checkAnagramWithJava8(String s1, String s2) {
		s1.replaceAll("\\s", "");
		s2.replaceAll("\\s", "");
		char[] arr1=s1.toLowerCase().toCharArray();
		char[] arr2=s2.toLowerCase().toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		if(Arrays.equals(arr1, arr2))
			return true;
		else
			return false;
	}

	private static boolean checkAnagramWithoutJava8(String s1, String s2) {
		s1.replaceAll("\\s", "").toLowerCase();
		s2.replaceAll("\\s", "").toLowerCase();
		
		if(s1.length()!=s2.length())
			return false;
		else {
			for(int i=0;i<s1.length();i++) {
				for(int j=0;i<s1.length();j++) {
					if(s1.charAt(i)==s2.charAt(j))
						s2=s2.substring(0,j)+s2.substring(j+1);
					break;//out of inner for-loop
				}
			}
			if (s2.length() == 0)
			{
				return true;
			} else
			{
				return false;
			}
			
		}

	}
}
	
