//Ref: https://www.youtube.com/watch?v=oSWTXtMglKE&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=7
/*
       10
     /   \
    5     15
     \
      8
 */


class Node {
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
    }
}
class BinarySearchTree {
    Node root;
    public void insert(Node node, int value){
        System.out.println("Called insert for " + value);
        if (node == null){
            root = new Node(value);
            return;
        }
        if (value < node.data){
            if (node.left == null) {
                node.left = new Node(value);
            } else {
                insert(node.left, value);
            }
        } else {
            if (node.right == null){
                node.right = new Node(value);
            } else {
                insert(node.right, value);
            }
        }
    }
    public void inOrderTraversalPrint(Node node){
        if (node ==null) return;
        inOrderTraversalPrint(node.left);
        System.out.print(node.data + " ");
        inOrderTraversalPrint(node.right);
    }
    public boolean contains(Node node, int value){
        if (node == null) return false;
        if (node.data == value){
            return true;
        }
        return contains(node.left, value) || contains(node.right, value);
    }
}
public class Demo {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(tree.root, 10);
        tree.insert(tree.root, 5);
        tree.insert(tree.root, 15);
        tree.insert(tree.root, 8);
        tree.inOrderTraversalPrint(tree.root); //5 8 10 15
        System.out.println("\nContains 8?: " + tree.contains(tree.root, 8)); //Contains 8?: true
        System.out.println("Contains 55?: " + tree.contains(tree.root, 55)); //Contains 55?: false
    }
}
