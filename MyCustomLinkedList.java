import java.util.Scanner;
public class MyCustomLinkedList{

     public static void main(String []args){
        SinglyLinkedList myLinkedlist = new SinglyLinkedList();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter length of LinkedList:");
        int a = in.nextInt();

        for (int i = 1; i <= a; i++) {
            System.out.println("Enter LinkList's Element number " + i + ": ");
            myLinkedlist.insertFirst(in.nextInt());
        }
        System.out.println("Your LInkedList :");
        myLinkedlist.printLinkedList();

     }
}


class Node {
    public int data;
    public Node next;

    public void displayNodeData() {
        System.out.println("{ " + data + " } ");
    }
}

class SinglyLinkedList {
    private Node head;
    private Node tail;

    public boolean isEmpty() {
        return (head == null);
    }

    // used to insert a node at the start of linked list
    public void insertFirst(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;
    }
	// used to delete a last node from linkedlist
    public void deleteLastElement() {
        Node current = head;
        Node pervious = head;
        Node temp = head;
        while (current.next != null) {
            pervious = current;
        }

        while (temp.next != null && temp.data != pervious.data) {
            temp = temp.next;
        }
        if (temp.next != null)
            temp.next = temp.next.next;
    }

	// used to delete element which value is smaller than value
    public void delLesserNodes(int value) {
        Node current = head;
 
        /* Initialise max */
        Node maxnode = head;
        Node temp;

        while (current != null && current.next != null) {
            /* If current is smaller than max, then delete
               current */
            if (current.next.data < value) {
                temp = current.next;
                current.next = temp.next;
                temp = null;
            }
 
            /* If current is greater than max, then update
               max and move current */
            else {
                current = current.next;
                maxnode = current;
            }
        }
    }

// used to delete element which value is greater than value
    public void deleteGreaterNode(int value) {
        Node current = head;
 
        /* Initialise max */
        Node maxnode = head;
        Node temp;
        while (current != null && current.next != null) {
            if (current.next.data > value) {
                temp = current.next;
                current.next = temp.next;
                temp = null;
            } else {
                current = current.next;
                maxnode = current;
            }
        }

    }


    // used to delete node from start of linked list
    public Node deleteFirst() {
        Node temp = head;
        head = head.next;
        return temp;
    }


    // used to insert a node at the start of linked list
    public void insertLast(int data) {
        Node current = head;
        while (current.next != null) {
            current = current.next; // we'll loop until current.next is null
        }
        Node newNode = new Node();
        newNode.data = data;
        current.next = newNode;
    }

    // For printing Linked List
    public void printLinkedList() {
        System.out.println("Printing LinkedList (head --> last) ");
        Node current = head;
        while (current != null) {
            current.displayNodeData();
            current = current.next;
        }
        System.out.println();
    }
}