package programs;

import java.util.Scanner;

public class StringsInAlphabeticalOrder {
	public static void main(String[] args) 
    {
        String temp;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of strings you would like to enter:");
        int count = scan.nextInt();
        
        String str[] = new String[count];
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Enter the Strings one by one:");
        for(int i = 0; i < count; i++)
        {
            str[i] = scan2.nextLine();
        }
        scan.close();
        scan2.close();

        //Sorting the strings
        for (int i = 0; i < count; i++) 
        {
            for (int j = i + 1; j < count; j++) { 
                if ((str[i].compareTo(str[j]))>0) 
                {
                    temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
        
        //Displaying the strings after sorting them based on alphabetical order
        System.out.print("Strings in Sorted Order:");
        for (int i = 0; i <= count - 1; i++) 
        {
            System.out.print(str[i] + ", ");
        }
    }
}