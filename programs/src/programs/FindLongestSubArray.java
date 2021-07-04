package programs;

import java.util.Arrays;

public class FindLongestSubArray {
	public static void main (String[] args)
	{
		int[] arr = { 1, -2, 6, 4, -3, 2, -4, -3 };
	
		findLongestSubArray(arr);
	}
	
	// Function to find length of longest subarray with alternating positive and negative elements
	private static void findLongestSubArray(int[] arr) {
				// stores length of longest alternating subarray found so far
				int maxLen = 1; //3
			
				// stores ending index of longest alternating subarray found so far
				int endIndex = 0; //2
			
				// stores length of longest alternating subarray ending at current position
				int currLen = 1; //3
			
				// traverse the given array starting from the second index
				for (int i = 1; i < arr.length; i++) //1,2,3,4,5,6,7
				{
					// if current element has opposite sign than the previous element
					if (arr[i] * arr[i - 1] < 0) //-2*1, 6*-2,4*6,
					{
						// include current element in longest alternating subarray ending at
						// previous index
						currLen++; //2,3,2,3,4
			
						// update result if current sub-array length is found to be greater
						if (currLen > maxLen)
						{
							maxLen = currLen;//2,3,4
							endIndex = i; //1,2,6
						}
					}
					// reset length if current element has same sign as previous element
					else {
						currLen = 1;//1
					}
				}
				
				//Arrays.copyOfRange(arr,6-4+1=3(inclusive) , 6 + 1=7(exclusive));
				int[] subarray = Arrays.copyOfRange(arr, (endIndex - maxLen + 1), endIndex + 1);
				System.out.println("The longest alternating subarray is "
									+ Arrays.toString(subarray));
			}
		
		
		
	}

