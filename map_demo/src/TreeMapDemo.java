import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapDemo {
	public static void main(String[] args) {
	//creating treeMap
	TreeMap m = new TreeMap();  //asc order of keys
	//putting key-value
	m.put(23, "");
	m.put(10, "");
	m.put(10, "Basics");   //duplicate key gets replaced
	m.put(11, "Basics");
	System.out.println(m);

	
	SortedMap s = new TreeMap();
	//creating equivalent treeMap for SortedMap
	TreeMap m2 = new TreeMap(s);
	
	//creating treeMap with comparator object
	TreeMap m1 = new TreeMap(new MySorting());
	
			
			m1.put("John", 10);
			m1.put("Shiva", 10);
			m1.put("Rohn", 10);
			
			System.out.println(m1);
	}
}
