import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
	public static void main(String[] args) {
	
		ArrayList a=new ArrayList(); //default size 10
		ArrayList b=new ArrayList(30);//size 30
		ArrayList c=new ArrayList(0);
		//ArrayList d=new ArrayList(-1); //illegalArgumentException(runtime exception)
		//ArrayList e=new ArrayList(Collection a);// will make equivalent arraylist of provided collection

		a.add("john");
		a.add(false);
		a.add(10);
		a.add(10);
		a.add(null);
		System.out.println(a);
		
		Iterator itr=a.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			a.add("@");
			
		}
		
		a.remove(1);
		System.out.println(a);
		
		a.remove(new Integer(10));
		System.out.println(a);

		a.remove(new Integer(10));
		System.out.println(a);
		
		//To get value from ArrayList (we need to perform typecasting here)
		boolean z = (boolean) a.get(1);
		System.out.println(a.get(0));
		

		//creating ArrayList using generics, no need of type casting
		ArrayList<String> as=new ArrayList<String>(); 
	}

}

