import java.util.TreeSet;

public class ComparableDemo {
	public static void main(String[] args) {
		TreeSet data = new TreeSet();
		
				data.add(152);   //becomes root node
				data.add(185);  //JVM calls 185.compareTo(152) returns +ve
				data.add(254);
				data.add(10);
				data.add(132);
				data.add(10);
				
				System.out.println(data);
	}
}
