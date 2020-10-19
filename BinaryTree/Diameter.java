/*
             2
           /  \
          7   5
        /  \
      12    6
      /    / \
     1    5  11
      \       \
       0      13
 */

class Node {
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
    }
}
class BinaryTree {
    Node root;
    int diameter = 0;
    public int calculateDiameter(Node node){
        if (node == null){
            return 0;
        }
        if (node.left == null && node.right==null){
            return 1;
        }
        int dL = calculateDiameter(node.left);
        int dR = calculateDiameter(node.right);
        diameter = Math.max(diameter, (dL + dR +1 ));
        return Math.max(dL, dR)+1;
    }
}

public class Test {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(2);
        tree.root.left = new Node(7);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(12);
        tree.root.left.right = new Node(6);
        tree.root.left.right.left = new Node(5);
        tree.root.left.right.right = new Node(11);
        tree.root.left.right.right.right = new Node(13);
        tree.root.left.left.left = new Node(1);
        tree.root.left.left.left.right = new Node(10);
        tree.calculateDiameter(tree.root);
        System.out.println("Diameter = "+ tree.diameter); //Diameter = 7
    }
}
