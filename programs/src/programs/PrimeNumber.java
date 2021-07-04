package programs;

import java.util.Scanner;

public class PrimeNumber {
	public static void main(String args[]) {
		boolean isPrime = true;

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter any number:");
		int num = scan.nextInt();
		scan.close();
		if (num == 0 || num == 1)
			isPrime = false;
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				isPrime = false;
				break;

			}
		}
		//If isPrime is true then the number is prime else not
		if (isPrime)
			System.out.println(num + " is a Prime Number");
		else
			System.out.println(num + " is not a Prime Number");
	}
}