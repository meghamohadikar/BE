package programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//not working
public class FindFirstAndLastOccurance {
	public static void main (String[] args)
	{
		int[] A = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
		int key = 5;

		findFirstAndLastOccurance(A, key);
	}

	private static void findFirstAndLastOccurance(int[] arr, int key) {
		int first=0;
		int last=0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) 
		{
			if (map.containsKey(key)) { 
				first=map.get(key);	
			}
			else {
				map.put(arr[i], i);
			}
		}
        
        last = Arrays.asList(arr).lastIndexOf(key);		
		System.out.println("first occurence="+first);
		System.out.println("last occurence="+last);
	}
	
}
