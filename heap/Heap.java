package heap;

import java.util.ArrayList;

/**
 * Created by Jakub on 2017-11-15.
 */
public class Heap {
    class Node {
        Node left;
        Node right;
        Integer key;

        public Node(int key) {
            this.key = key;
        }

        public String toString() {
            return Integer.toString(this.key);
        }
    }

    ArrayList<Node> vertices;

    public void addNode(int key) {
        if (vertices == null) {
            vertices = new ArrayList<Node>();
        }

        vertices.add(new Node(key));

        maxHeapify(vertices.size() - 1);
    }

    private void maxHeapify(int index) {
        if (index <= 0) {
            return;
        } else if (index > vertices.size() - 1) {
            throw new IllegalArgumentException("Index cannot be greater than number of vertices: " + index);
        }

        Node node = vertices.get(index);
        int parentIndex = (int)Math.floor(index/2);

        Node parentNode = vertices.get(parentIndex);

        if (parentNode.key < node.key) {
            vertices.set(parentIndex, node);
            vertices.set(index, parentNode);

            maxHeapify(parentIndex);
        }
    }

    public ArrayList<Node> heapSort() {
        ArrayList<Node> sortedArray = new ArrayList<>(vertices.size());

        while(vertices.size() > 0) {
            sortedArray.add(vertices.remove(0));

            if (vertices.size() > 0) {
                vertices.add(0, vertices.remove(vertices.size() - 1));

                heapify(0);
            }
        }


        return sortedArray;
    }

    private void heapify(int index) {
        int left = 2*index;
        int right = 2*index + 1;

        if (index >= 0 && index < vertices.size()) {
            Node parentNode = vertices.get(index);

            if (left < vertices.size()) {
                Node leftNode = vertices.get(left);

                if (leftNode.key > parentNode.key) {
                    swap(left, index);

                    heapify(left);
                }

                if (right < vertices.size()) {
                    Node rightNode = vertices.get(right);

                    if (rightNode.key > vertices.get(index).key) {
                        swap(right, index);

                        heapify(right);
                    }
                }
            }
        }
    }

    private void swap(int indexA, int indexB) {
        if (indexA >= 0 && indexA < vertices.size() && indexB >= 0 && indexB < vertices.size()){
            Node temp = vertices.get(indexA);

            vertices.set(indexA, vertices.get(indexB));
            vertices.set(indexB, temp);
        }
    }

    public String toString() {
        return vertices.toString();
    }
}
