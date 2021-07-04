package programs;

import java.util.Scanner;

public class Armstrong {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter integer to test: ");
		int num=sc.nextInt();
		System.out.println("Is number a Armstrong? "+isNumberArmstrong(num));
	}

	private static boolean isNumberArmstrong(int num) {
		int original=num;
		int result = 0;
		while(num!=0) {
			int a=num%10;
			num=num/10;
			result=result+(a*a*a);
		}
		if(original==result)
			return true;
		return false;
	}

}