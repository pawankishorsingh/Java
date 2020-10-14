//Ref: https://www.youtube.com/watch?v=SsmNI3Mlp0I&t=173s
import java.util.LinkedList;
import java.util.Queue;

/*
        1
      /  \
     2    3
    / \  / \
   4  5 6  7
  /
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
class BinaryTree {
    Node root;
    public void connectNodesAtSameLevel(Node root){
        Node temp = root;
        if (temp ==null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);
        queue.add(null);
        while(!queue.isEmpty()){
            Node element = queue.poll();
            if (element != null){
                System.out.print(element.data+"->");
            } else {
                if (queue.peek() !=null){
                    queue.add(null);
                }
                System.out.print("null" + "\n");
                continue;
            }
            if (element.left != null){
                queue.add(element.left);
            }
            if (element.right !=null){
                queue.add(element.right);
            }
        }
    }
}
public class Demo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left =new Node(2);
        tree.root.right =new Node(3);
        tree.root.left.left =new Node(4);
        tree.root.left.right =new Node(5);
        tree.root.right.left =new Node(6);
        tree.root.right.right =new Node(7);
        tree.root.left.left.left =new Node(8);
        tree.connectNodesAtSameLevel(tree.root);
        /*
        1->null
        2->3->null
        4->5->6->7->null
        8->null
         */
    }
}
