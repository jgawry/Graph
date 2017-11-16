package LinkedList;

/**
 * Created by Jakub on 2017-11-13.
 */
public class LinkedList {
    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public int getValue() {
            return this.value;
        }
    }

    Node head;

    public LinkedList() {
    }

    public void insertInOrder(int newValue) {
        if (this.head == null) {
            this.head = new Node(newValue);
        } else if (head.getValue() >= newValue) {
            Node newNode = new Node(newValue);

            newNode.next = head;
            this.head = newNode;
        } else {
            Node current = head;

            while(current.next != null && current.next.getValue() < newValue) {
                current = current.next;
            }

            Node newNode = new Node(newValue);

            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void delete(int value) {
        if (head != null) {
            Node current = head;

            while (current.next != null) {
                if (current.next.getValue() == value) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }

            if (head.getValue() == value) {
                head = head.next;
            }
        }
    }

    public void print() {
        Node current = head;

        while(current != null) {
            System.out.println(current.getValue() + " ");
            current = current.next;
        }
    }
}
