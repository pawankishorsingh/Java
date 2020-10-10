import java.util.Map;
import java.util.TreeMap;

class Node {
    private int data;
    private Node left;
    private Node right;
    public Node (int data){
        this.data = data;
    }
    public int getData(){
        return this.data;
    }
    public void setdata(int data){
        this.data = data;
    }
    public void setLeft(Node node){
        this.left = node;
    }
    public Node getLeft(){
        return this.left;
    }
    public void setRight(Node node){
        this.right = node;
    }
    public Node getRight() {
        return right;
    }
}
class BinaryTree {
    Node root;
    Map<Integer, Integer> map = new TreeMap<>();
    public void traverseInOrder(Node node){
        if (node ==null)
            return;
        traverseInOrder(node.getLeft());
        System.out.print(node.getData()+" ");
        traverseInOrder(node.getRight());
    }
    public void verticalSum(Node node, int verticalLevel){
        if (node ==null){
            return;
        }
        verticalSum(node.getLeft(), verticalLevel-1);
        map.put(verticalLevel, map.getOrDefault(verticalLevel,0)+node.getData());
        verticalSum(node.getRight(), verticalLevel+1);
    }
}
public class Demo{
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(13);
        binaryTree.root.setLeft(new Node(10));
        binaryTree.root.setRight(new Node(18));
        binaryTree.root.getLeft().setLeft(new Node(8));
        binaryTree.root.getLeft().setRight(new Node(12));
        binaryTree.root.getLeft().getRight().setLeft(new Node(11));
        binaryTree.root.getRight().setRight(new Node(22));
        binaryTree.root.getRight().getRight().setLeft(new Node(20));
        binaryTree.traverseInOrder(binaryTree.root);
        binaryTree.verticalSum(binaryTree.root, 0);
        System.out.println();
        System.out.println(binaryTree.map.toString());
    }
}
