class Node{
    private int data;
    private Node left;
    private Node right;

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

class BinaryTree {
    Node root;
    void traversePreOrderUsingRecursion(Node node){
        if (node ==null){ return; }
        System.out.print(node.getData()+" ");
        traversePreOrderUsingRecursion(node.getLeft());
        traversePreOrderUsingRecursion(node.getRight());
    }
    void traverseInOrderUsingRecursion(Node node){
        if (node ==null){ return; }
        traverseInOrderUsingRecursion(node.getLeft());
        System.out.print(node.getData()+" ");
        traverseInOrderUsingRecursion(node.getRight());
    }
    void traversePostOrderUsingRecursion(Node node){
        if (node ==null){ return; }
        traversePostOrderUsingRecursion(node.getLeft());
        traversePostOrderUsingRecursion(node.getRight());
        System.out.print(node.getData()+" ");
    }
}

public class Demo {
    public static void main(String[] args){
        /*
                    1
                  /  \
                 2    3
               /  \
              4   5
         */
        BinaryTree tree = new BinaryTree();
        tree.root=new Node(1);
        tree.root.setLeft(new Node(2));
        tree.root.setRight(new Node(3));
        tree.root.getLeft().setLeft(new Node(4));
        tree.root.getLeft().setRight(new Node(5));
        System.out.print("Pre-Order: ");
        tree.traversePreOrderUsingRecursion(tree.root); //1 2 4 5 3
        System.out.print("\nIn-Order: ");
        tree.traverseInOrderUsingRecursion(tree.root); //4 2 5 1 3
        System.out.print("\nPost-Order: ");
        tree.traversePostOrderUsingRecursion(tree.root); //4 5 2 3 1 
    }
}
