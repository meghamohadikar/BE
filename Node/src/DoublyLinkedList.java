
public class DoublyLinkedList {
	 class Node{
	        int data;
	        Node previous;
	        Node next;

	        public Node(int data) {
	            this.data = data;
				this.previous=null;
				this.next=null;
	        }
	    }
	 
	Node head=null;
	Node tail=null;
    public int size = 0;  

    //this method also works for to-insert-a-new-node-at-the-end-of-the-doubly-linked-list
	public void addNode(int data) {
		Node newNode=new Node(data);
		if(head==null) {
			head=newNode;
			tail=newNode;
			head.previous=null;
			tail.next=null;
		}else {
			tail.next=newNode;
			newNode.previous=tail;
			tail=newNode;
			tail.next=null;
		}
		
		//to-insert-a-new-node-at-the-start-of-the-doubly-linked-list
		/*else {
			head.previous=newNode;
			newNode.next=head;
			head=newNode;
			newNode.previous=null;
		}*/
        size++;  
	}
	
    public void display() {
		Node current=head;
		if(head == null) {    
            System.out.println("List is empty");    
            return;    
        } 
        System.out.println("Nodes of doubly linked list: ");    
        while(current!=null) {
        	System.out.println(current.data);
        	current=current.next;
        }
    }
    
    public int countNodes() {  
        int counter = 0;  
        Node current = head;  
  
        while(current != null) {  
            counter++;  
            current = current.next;  
        }  
        return counter;  
    }  
    
    public void reverse() {  
        Node current = head;
        Node temp = null;  
        while(current!=null) {
        	temp=current.next;
        	current.next=current.previous;
        	current.previous=temp;
        	current=current.previous;
        }
        temp = head;  
        head = tail;  
        tail = temp; 
    }
    
    public void deleteFromStart() {  
        if(head == null) {  
            return;  
        }  
        else {  
            if(head != tail) {  
                head = head.next;  
                head.previous = null;  
            }  
            else {  
                head = tail = null;  
            }  
        }  
    }  
    
    public void deleteFromEnd() {  
        if(head == null) {  
            return;  
        }  
        else {  
            if(head != tail) {  
                tail = tail.previous;  
                tail.next = null;  
            }  
            else {  
                head = tail = null;  
            }  
        }  
    }  
    
    public void deleteFromMid() {  
        //Checks whether list is empty  
        if(head == null) {  
            return;  
        } else {  
        	
        	 Node current = head;  
             int mid = (size % 2 == 0) ? (size/2) : ((size+1)/2);  
   
             for(int i = 1; i < mid; i++){  
                 current = current.next;  
             }  
   
             //If middle node is head of the list  
             if(current == head) {  
                 head = current.next;  
             }  
             //If middle node is tail of the list  
             else if(current == tail) {  
                 tail = tail.previous;  
             }  
             else {  
                 current.previous.next = current.next;  
                 current.next.previous = current.previous;  
             }  
             //Delete the middle node  
             current = null;  
         }  
         size--;   
    }
    
    //MinimumNode() will find out minimum value node in the list  
    public int minimumNode() {  
        Node current = head;  
        int min;  
  
        if(head == null) {  
            System.out.println("List is empty");  
            return 0;  
        }  
        else {  
            min = head.data;  
            while(current != null) {    
                if(min > current.data)  
                    min = current.data;  
                current = current.next;  
            }  
        }  
        return min;  
    }  
  
    //MaximumNode() will find out maximum value node in the list  
    public int maximumNode() {  
        Node current = head;  
        int max;  
  
        if(head == null) {  
            System.out.println("List is empty");  
            return 0;  
        }  
        else {  
            //Initially, max will store the value of head's data  
            max = head.data;  
            while(current != null) {  
                if(current.data > max)  
                    max = current.data;  
                current = current.next;  
            }  
        }  
        return max;  
    }  
    
  //addInMid() will add a node to the middle of the list  
    public void addInMid(int data) {  
        Node newNode = new Node(data);  
         if(head == null) {  
            head = tail = newNode;  
            head.previous = null;  
            tail.next = null;  
        }  
        else {  
            Node current = head, temp = null;  
              int mid = (size % 2 == 0) ? (size/2) : ((size+1)/2);  
  
            for(int i = 1; i < mid; i++){  
                current = current.next;  
            }  
  
            //Node temp will point to node next to current  
            temp = current.next;  
            temp.previous = current;  
  
            //newNode will be added between current and temp  
            current.next = newNode;  
            newNode.previous = current;  
            newNode.next = temp;  
            temp.previous = newNode;  
        }  
        size++;  
    }  
  
    public static void main(String[] args) {

        DoublyLinkedList dList = new DoublyLinkedList();
        //Add nodes to the list
        dList.addNode(1);
        dList.addNode(2);
        dList.addNode(3);
        dList.addNode(4);
        dList.addNode(5);

        //Displays the nodes present in the list
        dList.display();
        dList.reverse();
        dList.display();
        System.out.println("\nCount of nodes present in the list: " + dList.countNodes());  
    }

}
