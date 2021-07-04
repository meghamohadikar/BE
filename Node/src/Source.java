import java.util.Scanner;

class Source {

    static Node headNode;

    static class Node {
        int data;
        Node next;
        Node(int value) {
            data = value;
            next = null;
        }
    }

    /* This method does the following:
    1. If there is a loop in the linked list, it should print 'Yes'
    and remove the loop in the linked list and return the head node.
    2. If there is no loop in the linked list, it should print 'No'
    and return the head node of the linked list. */
    Node removeLoop(Node head) {
        // Initialize ptr1 and ptr2 to head node.
        Node ptr1 = head;
        Node ptr2 = head;
        // boolean to check if there a loop exists in the given Linked List.
        boolean flag = false;
        // Traverse the list until ptr2 or ptr2.next becomes null.
        while (ptr2 != null && ptr2.next != null) {
            // Move forward ptr1 by one node.
            ptr1 = ptr1.next;
            // Move forward ptr2 by two nodes.
            ptr2 = ptr2.next.next;
            // Check if ptr1 and ptr2 meet at some node, then there is a loop in the Linked
            // List and So make flag true and break.
            if (ptr1 == ptr2) {
                flag = true;
                break;
            }
        }
        // When there is a loop in the Linked List.
        if (flag) {
            System.out.println("YES");
            // Assign head to ptr1.
            ptr1 = head;
            // Loop until next of ptr1 and ptr2 are not equal.
            while (ptr1.next != ptr2.next) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            // Make next of ptr2 that is last node of Linked List NULL.
            ptr2.next = null;
            return null;
        }else{
            System.out.println("NO");
            return head;


        }

}

    /* This method adds a new node with data 'newData' to
  the front of the linked list*/
    public void addAtHead(int newData) {

        /* Create a new Node of data newData */
        Node newNode = new Node(newData);

        /* Now, set the next of the newNode as headNode */
        newNode.next = headNode;

        /* Next, make this newNode as head*/
        headNode = newNode;
    }


    /* This method prints every node of the linked list from the head,
    separating by a space */
    void printLinkedList(Node head) {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
    }


    // Driver program to test above functions
    public static void main(String[] args) {
        Source list = new Source();

        Scanner in = new Scanner(System.in);

        /* Get the number of nodes of the linked list from input */

        int n = in.nextInt();

        /* Get all nodes of the linked list from input */
        for (int i = 0; i < n; i++) {
            list.addAtHead(in.nextInt());
        }

        /* Get the value of k from input */
        int k = in.nextInt();

       /* Creating a loop, by making the next node of the last node
        as the kth node from the head of the linked list */
        if (k != 0) {
            Node first = headNode, last;
            for (int i = 0; i < k; i++) {
                first = first.next;
            }
            last = first;
            while (last.next != null) {
                last = last.next;
            }
            last.next = first;
        }

        /* Print the linked list after removing the loop */
        list.printLinkedList(list.removeLoop(headNode));
    }
}
