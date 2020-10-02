import java.util.ArrayList;
import java.util.List;

/*
                 2
              /    \
            7      9
         /    \       \
     10      6       3

 */

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

class BinaryTree{
    Node root = null;
    int deserializeIndex = 0;

    void preOrderTraversal(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.getData() + " ");
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }

    void serializePreOrder(Node root, List<Integer> serializedList){
        if (root == null){
            serializedList.add(-1);
            return;
        }
        serializedList.add(root.getData());
        serializePreOrder(root.getLeft(), serializedList);
        serializePreOrder(root.getRight(), serializedList);
    }

    Node deserializePreOrder(List<Integer> serializedList){
        if (serializedList.get(deserializeIndex) == -1){
            deserializeIndex++;
            return null;
        }
        Node newRoot = new Node(serializedList.get(deserializeIndex++));
        newRoot.setLeft(deserializePreOrder(serializedList));
        newRoot.setRight(deserializePreOrder(serializedList));
        return newRoot;
    }

}

public class Demo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        List<Integer> serializedList = new ArrayList<>();
        tree.root = new Node(2);
        tree.root.setLeft(new Node(7));
        tree.root.getLeft().setLeft(new Node(10));
        tree.root.getLeft().setRight(new Node(6));
        tree.root.setRight(new Node(9));
        tree.root.getRight().setRight(new Node(3));
        System.out.print("Before:");
        tree.preOrderTraversal(tree.root);
        System.out.println("");

        tree.serializePreOrder(tree.root, serializedList);
        System.out.println("Serialized: " + serializedList.toString());

        Node newRoot = tree.deserializePreOrder(serializedList);
        System.out.print("After:");
        tree.preOrderTraversal(newRoot);
    }
}
