package heap;

/**
 * Created by Jakub on 2017-11-15.
 */
public class HeapRunner {
    public static void main(String[] args) {
        Heap heap = new Heap();

        heap.addNode(5);
        heap.addNode(8);
        heap.addNode(3);

        heap.addNode(15);
        heap.addNode(82);
        heap.addNode(34);

        heap.addNode(52);
        heap.addNode(-8);
        heap.addNode(34);

        System.out.println(heap);
    }
}
