package programs;

public class FindSubarrayOfSumZero {
	public static void main (String[] args)
	{
		/// index   0   1   2  3  4  5  6  7    8    9 
		int[] A = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };

		printallSubarrays(A);
	}

	private static void printallSubarrays(int[] A) {
		for (int i = 0; i < A.length; i++) //0 
		{
			int sum = 0;
			for (int j = i; j < A.length; j++) //0 1 2 3 4 5 6 7 8 9
			{
				sum += A[j]; //3+4-7=0,3+4-7+3+1+3+1-4-2=0
				if (sum == 0) {
					System.out.println("Subarray [" + A[i] + ".." +A[j] + "]");
				}
			}
		}
	}

}
