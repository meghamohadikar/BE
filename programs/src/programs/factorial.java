package programs;

import java.util.Scanner;

public class factorial {
	public static void main(String args[]){
	      Scanner scanner = new Scanner(System.in);
	      System.out.println("Enter the number:");
	      int num = scanner.nextInt();
	      scanner.close();
	      int factorial = fact(num);
	      System.out.println("Factorial of entered number is: "+factorial);
	   }
	   static int fact(int n)
	   {
	       int output=0;
	       if(n==1 || n==0){
	         return 1;
	       }
	       //Recursion: Function calling itself!!
	       output = fact(n-1)* n;
	       return output;
	   }
	   
	   public static int fact1(int number){
	        int result = 1;
	        while(number != 0){
	            result = result*number;
	            number--;
	        }
	     
	        return result;
	    }
}