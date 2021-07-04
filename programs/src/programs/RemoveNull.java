package programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RemoveNull {
	public static void main(String[] args) {
		List a = new ArrayList();
		a.add("Megha");
		a.add(null);
		a.add(12);
		a.add(null);		 
		System.out.println(a);
		
		//method 1
		Iterator itr=a.iterator();
		while(itr.hasNext()) {
			Object obj=itr.next();
			if(obj==null) {
				itr.remove();
			}
			
		}
		System.out.println(a);
		
		//method 2
		a=Arrays.asList(a).stream().filter(x->x!=null).collect(Collectors.toList());
		System.out.println(a);
		
		//method 3(any one of below 3)
		//a.removeIf(Objects::isNull);
		a.removeIf(x-> !Objects.nonNull(x));
		//a.removeIf(x->x==null);
		System.out.println(a);
		
		//method 4
		a= (List) Optional.ofNullable(a)
		 .orElseGet(Collections::emptyList)
		 .stream()
		 .filter(x -> x != null)
		 .collect(Collectors.toList());
		System.out.println(a);
	}
}
