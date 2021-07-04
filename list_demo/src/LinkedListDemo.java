import java.util.LinkedList;

public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList a=new LinkedList();  
		//LinkedList b=new LinkedList(Collection C); // create equivalent linkedlist for provided collection type(ex.set,list)

		a.add("John");
		a.add(10); //add() adds elements to next empty index
		a.add(null); //null insertion possible
		System.out.println(a);
		
		a.set(1, 20);  //set() replaces an existing elements at a given index 
		System.out.println(a);
		
		a.add(2, 30);   //add elemets to given index and shift old value by 1 index
		System.out.println(a);

		a.removeFirst();
		System.out.println(a);
		
		a.removeLast();
		System.out.println(a);

		a.addFirst("Megha");
		System.out.println(a);

		a.addLast(null);
		System.out.println(a);

		System.out.println(a.getFirst());
		System.out.println(a.getLast());	
	}

}
