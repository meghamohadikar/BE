package programs;

import java.util.Scanner;

public class NumberPalindrome {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter integer to test: ");
		int num=sc.nextInt();
		System.out.println("Is number a palindrome? "+isNumberPalindrome(num));
	}

	private static boolean isNumberPalindrome(int num) {
		int original=num;
		int reverse = 0;
		while(num!=0) {
			reverse=(reverse*10)+(num%10);
			num=num/10;
		}
		if(original==reverse)
			return true;
		return false;
	}

}
