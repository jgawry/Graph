package BST;

/**
 * Created by Jakub on 2017-11-12.
 */
public class BST {

    enum TraverseOrder {
        INORDER,
        PREORDER,
        POSTORDER
    }

    class Node {
        Node left;
        Node right;
        Integer key;

        public Node(int key) {
            this.key = key;
        }
    }

    public Node root;

    public BST() {}

    public BST(int rootKey) {
        this.root = new Node(rootKey);
    }

    public Node findKey(int key) {
        return findKeyRec(root, key);
    }

    private Node findKeyRec(Node node, int key) {
        if (node == null) {
            return null;
        }

        int nodeValue = node.key.intValue();

        if (nodeValue == key) {
            return node;
        }

        if (key < nodeValue) {
            return findKeyRec(node.left, key);
        } else {
            return findKeyRec(node.right, key);
        }
    }

    public void insertKey(int key) {
        root = insertKeyRec(root, key);
    }

    private Node insertKeyRec(Node node, int key) {
        if (node == null) {
            node = new Node(key);
            return node;
        }

        int nodeValue = node.key.intValue();

        if (key < nodeValue) {
            node.left = insertKeyRec(node.left, key);
        } else {
            node.right = insertKeyRec(node.right, key);
        }

        return node;
    }

    public void print(TraverseOrder order) {
        printRec(root, order);
    }

    private void printRec(Node node, TraverseOrder order) {
        if (node == null) {
            System.out.println("NULL");
        } else {
            switch (order) {
                case PREORDER:
                    System.out.println("Value: " + node.key);
                    printRec(node.left, order);
                    printRec(node.right, order);
                    break;
                case POSTORDER:
                    printRec(node.left, order);
                    printRec(node.right, order);
                    System.out.println("Value: " + node.key);
                    break;
                case INORDER:
                     default:
                    printRec(node.left, order);
                    System.out.println("Value: " + node.key);
                    printRec(node.right, order);
                    break;
            }
        }
    }
}
