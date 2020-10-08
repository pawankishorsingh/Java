//Ref: https://www.youtube.com/watch?v=i_Q0v_Ct5lY&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=6

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
    public boolean checkBST(Node node, int min, int max){
        if (node == null) return true;
        System.out.println("checkBST called for data=" + node.data + " in range (" + min + ", " +max + ")");
        if (node.data < min || node.data > max){
            System.out.println("Oops !!!");
            return false;
        }
        return checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max);
    }
}

public class Demo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(50);
        tree.root.left = new Node(10);
        tree.root.right = new Node(80);
        System.out.println("Is Balanced?: " + tree.checkBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
