package BST;

/**
 * Created by Jakub on 2017-11-12.
 */
public class BSTRunner {
    public static void main(String[] args) {
        BST bst = new BST(10);

        bst.insertKey(11);
        bst.insertKey(8);
        bst.insertKey(5);
        bst.insertKey(9);
        bst.insertKey(12);

        System.out.println("BST:");
        bst.print(BST.TraverseOrder.POSTORDER);
    }
}
