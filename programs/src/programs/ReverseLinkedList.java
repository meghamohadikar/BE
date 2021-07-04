package programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ReverseLinkedList {
	public static void main(String args[]) { // foods which helps in weight loss 
		//List<String> listOfWeightLossFood = new ArrayList<>( Arrays.asList( "oats","beans", "avocados", "broccoli")); 

		List<String> listOfWeightLossFood = new LinkedList<>( Arrays.asList( "oats","beans", "avocados", "broccoli")); 
		System.out.println("before sorting: " + listOfWeightLossFood);
		//Collections.sort(listOfWeightLossFood);
		listOfWeightLossFood.sort(Comparator.naturalOrder());
		System.out.println("before sorting in natural order: " + listOfWeightLossFood);
		//Collections.reverse(listOfWeightLossFood);
		listOfWeightLossFood.sort(Comparator.reverseOrder()); 
		System.out.println("after sorting in reverse order: " + listOfWeightLossFood); 
		}

}
