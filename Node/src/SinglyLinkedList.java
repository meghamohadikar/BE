
public class SinglyLinkedList {
	
	class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
			this.next=null;
		}
		
	}
	
	Node head=null;
	Node tail=null;
	
	public void addNode(int data) {
		Node newNode=new Node(data);
		if(head==null) {
			head=newNode;
			tail=newNode;
			tail.next=null;
		}else {
			tail.next=newNode;
			tail=newNode;
		}
	}
	
	public void display() {
		Node current=head;
		 if(head == null) {    
	            System.out.println("List is empty");    
	            return;    
	        }    
		 
	        System.out.println("Nodes of singly linked list: ");    
	        while(current!=null) {
	        	System.out.println(current.data);
	        	current=current.next;
	        }
	}
	
	public static void main(String[] args) {    
        
        SinglyLinkedList sList = new SinglyLinkedList();    
            
        //Add nodes to the list    
        sList.addNode(1);    
        sList.addNode(2);    
        sList.addNode(3);    
        sList.addNode(4);    
            
        //Displays the nodes present in the list    
        sList.display();    
    }
}
