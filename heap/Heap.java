package heap;

import com.company.BST.BST;

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

    public String toString() {
        return vertices.toString();
    }
}
