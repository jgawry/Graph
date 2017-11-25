package heap;

/**
 * Created by Jakub on 2017-11-15.
 */
public class HeapRunner {
    public static void main(String[] args) {
        Heap heap = new Heap();

        heap.addNode(15);
        heap.addNode(8);
        heap.addNode(14);

        System.out.println(heap);

        heap.addNode(7);

        System.out.println(heap);

        heap.addNode(6);

        System.out.println(heap);

        heap.addNode(12);

        System.out.println(heap);

        heap.addNode(11);

        System.out.println(heap);

        System.out.println(heap.heapSort());
    }
}
