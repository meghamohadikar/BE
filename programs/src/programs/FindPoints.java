package programs;

import java.util.ArrayList;
import java.util.List;

public class FindPoints {

	public static void main(String[] args) {
		List<Integer> a= new ArrayList();
		a.add(2);
		a.add(4);
		a.add(4);
		
		List<Integer> b= new ArrayList();
		b.add(1);
		b.add(10);
		b.add(5);
		
		 List<Integer> result=compareTriplets(a,b);
		 System.out.println("result=="+result);

	}

	private static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		List<Integer> points=new ArrayList<Integer>();
		int pta=0;
		int ptb=0;
		for(int i=0;i<a.size();i++) {
			if(a.get(i)>b.get(i)) 
				pta++;
			else if(a.get(i)<b.get(i)) 
				ptb++;
			
		}
		points.add(pta);
		points.add(ptb);
		return points;
	}

}
