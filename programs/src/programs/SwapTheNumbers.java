package programs;

import java.util.Scanner;

public class SwapTheNumbers {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first number: ");
		int x=sc.nextInt();
		System.out.println("Enter second number: ");
		int y=sc.nextInt();
		swapWithoutThirdVariable(x,y);
		swapWithThirdVariable(x,y);
	}

	private static void swapWithThirdVariable(int x, int y) {
		int temp=x;
		x=y;
		y=temp;
		System.out.println("x="+x+",y="+y);
	}

	private static void swapWithoutThirdVariable(int x, int y) {
		x=x+y;
		y=x-y;
		x=x-y;
		System.out.println("x="+x+",y="+y);
		
	}

}
