import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class App1 {

	public static void main(String[] args) {
		 Map<String, String> yourMap = new HashMap<String, String>();
		    yourMap.put("1", "one");
		    yourMap.put("2", "two");
		    yourMap.put("3", "three");
		    
			System.out.println("map without sorting="+yourMap);
			
			Map m=new TreeMap(yourMap);
			System.out.println("map with sorting by keys="+m);

		    List<String> keyList = new ArrayList<String>(yourMap.keySet());// 1 2 3
		    List<String> valueList = new ArrayList<String>(yourMap.values());//one two three
		    Set<String> sortedSet = new TreeSet<String>(valueList);//one, three, two
			
		    Map<String, Object> map = new LinkedHashMap<String, Object>();
		    Object[] sortedArray = sortedSet.toArray();// [one, three, two]
		    for (int i = 0; i < sortedArray.length; i++) {
		    	System.out.println(valueList.indexOf(sortedArray[i]));
		        map.put(keyList.get(valueList.indexOf(sortedArray[i])), sortedArray[i]);
		     }
			System.out.println("map after sorting by values="+map);

	}

}
