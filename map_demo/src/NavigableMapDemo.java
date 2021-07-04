import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapDemo {
	public static void main(String[] args) {

		NavigableMap<String,Integer> t = new TreeMap<>();
		t.put("ABC", 123);
		t.put("DEF", 456);
		t.put("HIJ", 789);
		t.put("MNO", 546);
		t.put("PQR", 776);
		t.put("XYZ", 775);
		t.put("JKL", 987);
		t.put("STU", 544);
		t.put("LMN", 543);
		
		System.out.println(t);
		
		//various methods
		System.out.println(t.ceilingEntry("HIJ"));  //key-value entry having greater than or equal  to provided key
		System.out.println(t.floorKey("PQR"));    //key having lower than or equal  provided key
				System.out.println(t.higherKey("ABC"));  //key greater than provided key
				System.out.println(t.lowerKey("PQR"));   //key lower than provided key
				System.out.println(t.ceilingKey("XYZ"));  //key having greater than or equal  to provided key
				System.out.println(t.descendingKeySet());   // key set in desc order
				System.out.println(t.descendingMap());   //map in desc key order
				System.out.println(t.headMap("JKL"));   // map b4 provided key excluding provided key
				System.out.println(t.headMap("JKL",true));  //true to include provided key
				System.out.println(t.subMap("PQR", "XYZ"));   //submap  including starting key and excluding last key
				System.out.println(t.subMap("ABC", true, "PQR", false));  //submap  excluding starting key and excluding last key
				System.out.println(t.tailMap("JKL"));  //map after provided key including provided key
				System.out.println(t.tailMap("PQR", false));  //map after provided key excluding provided key
				System.out.println(t.higherEntry("STU")); //  key-value entry just higher than given key
				System.out.println(t.navigableKeySet());  //key set in default sorting order
				
	}

}
