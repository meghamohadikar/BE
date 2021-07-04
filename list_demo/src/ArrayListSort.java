

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayListSort {

	public static void main(String[] args) {
		
		ArrayList<Student> list= new ArrayList<Student>();
		Student s=new Student();
		s.setId(1);
		s.setName("bcde");
		
		Student f=new Student();
		f.setId(2);
		f.setName("abcd");
		
		Student g=new Student();
		g.setId(5);
		g.setName("xyz");
		
		Student k=new Student();
		k.setId(7);
		k.setName("uio");
		
		list.add(s);
		list.add(f);
		list.add(k);
		list.add(g);
		
		for(Student a: list) {
			System.out.println(a.getId() + a.getName());

		}
		
		Collections.sort(list);
		System.out.println("---------------");
		for(Student a: list) {
			System.out.println(a.getId() + a.getName());

		}
		System.out.println("---------------");
		Map map=new HashMap<Integer, String>();
		for(Student a: list) {
		 map.put(a.getId(), a.getName());
		 }
		
		System.out.println("map without sorting="+map);
		
		//Map<Integer, String> map1 = sortByValue(map); 
		  
		
		System.out.println("map with sorting="+map);
		
		
		
	}

}
