package programs;

import java.util.Scanner;

public class FibonacciSeries {
	 public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number upto which Fibonacci series to print: ");
		int number = sc.nextInt();
		System.out.println("Fibonacci series upto " + number +" numbers : "); 
		
		//printing Fibonacci series upto number
		for(int i=1; i<=number; i++){ 
			
			System.out.print(fibonacci(i) +" "); 
			}
		}


	private static int fibonacci2(int number) {
		if(number == 1 || number == 2){ 
			return 1;
			} 
		int fibo1=1, fibo2=1, fibonacci=0; 
		for(int i= 3; i<= number; i++){ 
			//Fibonacci number is sum of previous two Fibonacci number 
			fibonacci = fibo1 + fibo2; 
			fibo1 = fibo2; 
			fibo2 = fibonacci;
			} 
		return fibonacci; //Fibonacci number

	}
	
	public static int fibonacci(int number){ //3
		if(number == 1 || number == 2){ 
			return 1;
			} 
		return fibonacci(number-1) + fibonacci(number -2); //tail recursion 
		//fibonacci(2)+fibonacci(1)=1+1=2
	}

}
