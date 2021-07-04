import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class App {
	public static void main(String[] args) {
		HashMap<Integer,Student> hm=new HashMap<Integer,Student>();
		hm.put(12, new Student(12, 101, "B"));
		hm.put(10, new Student(10, 102, "Z"));
		hm.put(15, new Student(15, 108, "x"));
		hm.put(21, new Student(21, 104, "M"));
		hm.put(52, new Student(52, 105, "b"));
		
		System.out.println("map without sorzting="+hm);
		
		//sorting by key
		Map m=new TreeMap(hm);
		System.out.println("map with sorting by keys="+m);
			
		//to convert all names to uppercase
		List<Student> stud = new ArrayList<Student>(hm.values());
		List<String> studs = new ArrayList<String>();
		for(Student s:stud) {
			studs.add(s.getName().toUpperCase());	
		}
		System.out.println("Names with uppercase="+studs);
		
		//Names with uppercase and sorted
		List l=hm.entrySet().stream().map(e->e.getValue().getName().toUpperCase()).sorted().collect(Collectors.toList());
		System.out.println("Names with uppercase and sorted="+l);
		
		//list of students having age>10
		List<Student> s=hm.values().stream().filter(e->e.getAge()>10).collect(Collectors.toList());
		System.out.println("list of students having age>10="+s);
		
		//student with max age
		Student f=hm.values().stream().max((m1,m2)->m1.getAge()>m2.getAge()?1:-1).get();
		System.out.println("student with max age="+f);
		
		/*
		 * Comparator<Entry<Integer, Student>> valueComparator = new
		 * Comparator<Entry<Integer,Student>>() {
		 * 
		 * @Override public int compare(Entry<Integer, Student> e1, Entry<Integer,
		 * Student> e2) { String v1 = e1.getValue().getName().toLowerCase(); String v2 =
		 * e2.getValue().getName().toLowerCase(); return v1.compareTo(v2); } };
		 */
		//sorting by values
		List<Entry<Integer,Student>> list=new ArrayList<Entry<Integer,Student>>(hm.entrySet());
            Collections.sort(list, new Student());
            LinkedHashMap<Integer, Student> sortedByValue = new LinkedHashMap<Integer, Student>();

            // copying entries from List to Map
               for(Entry<Integer, Student> entry : list){
               	sortedByValue.put(entry.getKey(), entry.getValue()); 
               }
			System.out.println("map with sorting by values="+sortedByValue);
	}

}
