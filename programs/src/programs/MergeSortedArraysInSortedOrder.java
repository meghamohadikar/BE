package programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArraysInSortedOrder {
	public  static void main(String[] args) {
		int[] A = {2,1,4,3};
		int[] B = {2,3,7,5};
		 Object[] C=mergeInSortdOrder(A,B);
		 System.out.println("result="+Arrays.toString(C));
	}

	private static Object[] mergeInSortdOrder(int[] a, int[] b) {
		Arrays.sort(a);
		Arrays.sort(b);
		List<Integer> arrList = new ArrayList<Integer>(); 
		for(int i=0;i<a.length;i++)
			arrList.add(a[i]);
		for(int i=0;i<b.length;i++)
			arrList.add(b[i]);
		
		Object[] C = arrList.toArray();
		Arrays.sort(C);
		return C;
	}

}
