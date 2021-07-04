

import java.util.Vector;

public class VectorDemo {
	public static void  main(String[] args) {
		Vector a=new Vector();  //default size=10
		
		//creating vector with specified capacity
		Vector vec = new Vector(60);  //if the vector gets filled, new vector constructs with size120(60*2)
		
		//creating vector with specified capacity and incremental capacity
		Vector vec1 = new Vector(100,5); //new size will be 105
		
		//creating vector with specified collection
		//Vector vec2 = new Vector(Collection c);
		
		System.out.println(a);
		a.add(null);
		a.addElement("Megh");
		System.out.println(a);

		//to remove element from vector
		a.removeElementAt(0);
		System.out.println(a);
		System.out.println(a.elementAt(0));
		
		//to get elements
				System.out.println(a.firstElement());
				System.out.println(a.lastElement());
				System.out.println(a.get(0));
				System.out.println(a.elementAt(0));
				
				System.out.println(a.size()); //returns size=occupied indices
				System.out.println(a.capacity()); //total size including empty indices

				
	}

}
