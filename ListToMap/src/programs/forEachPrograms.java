package programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class forEachPrograms {
	public static void main(String[] args) {
		//1.forEach for map
		Map<String,Integer> items=new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);
		//without foreach loop
		for(Map.Entry<String,Integer> entry: items.entrySet()) {
			System.out.println("Item : " + entry.getKey() + ", Count : " + entry.getValue());
		}
		//with lambda expression using forEach loop
		items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));

		items.forEach((k,v)->{
			System.out.println("Item : " + k + " Count : " + v);
			if("E".equals(k)){
				System.out.println("Hello E");
			}
		});
		
		//2.forEach for list
		List<String> items1 = new ArrayList<>();
		items1.add("A");
		items1.add("B");
		items1.add("C");
		items1.add("D");
		items1.add("E");
		//without forEach loop
		for(String item : items1){
			System.out.println(item);
		}
		//with lambda expression using forEach loop
		items1.forEach(item->System.out.println(item));
		
		//Output : A,B,C,D,E
		items1.forEach(item->{
			if("C".equals(item))
				System.out.println(item);
		});

		//method reference
		//Output : A,B,C,D,E
		items1.forEach(System.out::println);

		//Stream and filter
		//Output : B
		items1.stream()
			.filter(s->s.contains("B"))
			.forEach(System.out::println);
	}

}
