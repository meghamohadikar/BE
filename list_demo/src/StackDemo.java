

import java.util.Stack;

public class StackDemo {
public static void main(String[] args) {
		
		//Creating stack
		Stack s = new Stack();
		
		//to add element in stack
		s.push(10);
		s.push(30);
		s.push(true);
		
		//to REMOVE element from stack
		Object o = s.pop();  //true
		System.out.println(o);
		System.out.println(s);
		
		//to GET last element from stack without replacing it
		Object obj=s.peek();  //30
		System.out.println(obj);
		System.out.println(s);
		
		//to check whether stack is empty or not
		System.out.println(s.empty());
		
		//to search an element in stack, it returns offset of element if available.
		System.out.println(s.search(10));  //position of 10 is 2, serching starts from last inserted element
	}

}
