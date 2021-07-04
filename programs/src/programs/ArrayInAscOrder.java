package programs;

import java.util.Arrays;

public class ArrayInAscOrder {
	public static void main(String args[]){  
		int a[]={1,2,5,6,3,2};    
		//Arrays.sort(a);
		//System.out.println(Arrays.toString(a));		
		a=getSmallest(a);
		System.out.println("Array In sorting order: "+Arrays.toString(a));  
		// the line below this gives an output 
        // \u000d System.out.println("comment executed"); 
	}

	private static int[] getSmallest(int[] a) {
		int temp;  
		for (int i = 0; i < a.length; i++)   
        {  
            for (int j = i + 1; j < a.length; j++)   
            {  
                if (a[i] > a[j])   
                {  
                    temp = a[i];  
                    a[i] = a[j];  
                    a[j] = temp;  
                }  
            }  
        }  
	
		return a;
	}
}
