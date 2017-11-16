package LinkedList;

/**
 * Created by Jakub on 2017-11-13.
 */
public class LinkedListRunner {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.insertInOrder(-5);

        ll.insertInOrder(6);

        ll.insertInOrder(-5);

        ll.insertInOrder(-3);

        ll.insertInOrder(-5);
        ll.insertInOrder(-5);

        ll.delete(-5);

        ll.print();
    }
}
