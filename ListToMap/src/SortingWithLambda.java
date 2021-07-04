import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingWithLambda {
	public static void main(String[] args) {
		List<Hosting> list = new ArrayList<Hosting>();
    	list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(5, "mkyong.com", 1));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "linode1.com", 100000)); 
        
        System.out.println("Before Sort");
        list.forEach(item->System.out.println(item.getId()+","+item.getName()+","+item.getWebsites()));
		
		//sort by id
		Collections.sort(list, new Comparator<Hosting>() {
					@Override
					public int compare(Hosting o1, Hosting o2) {
						return (o1.getId()- o2.getId());
					}
				});
		
		//lambda expression
		list.sort((Hosting o1, Hosting o2)->o1.getId()-o2.getId());
		list.sort(( o1,  o2)->o1.getId()-o2.getId());

		Comparator<Hosting> comparator = (o1, o2)->o1.getName().compareTo(o2.getName());
		list.sort(comparator.reversed());

		System.out.println("After Sort");
        list.forEach(item->System.out.println(item.getId()+","+item.getName()+","+item.getWebsites()));


	}
}
