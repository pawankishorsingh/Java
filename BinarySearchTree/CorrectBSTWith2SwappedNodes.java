/* Ref: https://www.youtube.com/watch?v=O4zB91sMKhM 
       7
      / \
     5   4
    / \
   8   6
 */

import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
    }
}
class BST {
    Node root;
    void inOrderTraversal(Node head, List<Integer> arr){
        Node temp = head;
        if (temp == null)
            return;
        inOrderTraversal(temp.left, arr);
        arr.add(temp.data);
        inOrderTraversal(temp.right, arr);
    }
    void fixBST(Node head, int culprit1, int culprit2){
        Node temp = head;
        if (temp == null)
            return;
        fixBST(temp.left, culprit1, culprit2);
        if (temp.data == culprit1){
            temp.data = culprit2;
        } else if (temp.data == culprit2){
            temp.data = culprit1;
        }
        fixBST(temp.right, culprit1, culprit2);
    }
}

public class Demo {
    static int culpritIndex1 =Integer.MIN_VALUE;
    static int culpritIndex2 =Integer.MIN_VALUE;
    static void findCulprits(List<Integer> arr){
        for (int i=0; i<arr.size()-1; i++){
            if (culpritIndex1 == Integer.MIN_VALUE && arr.get(i+1)<arr.get(i)){
                culpritIndex1 = i;
            }
            if (culpritIndex1 != Integer.MIN_VALUE && arr.get(i+1)<arr.get(i)){
                culpritIndex2 = i+1;
            }
        }
        System.out.println("Culprit Indexes are: "+ culpritIndex1 + " & " + culpritIndex2); //Culprit Indexes are: 0 & 4
    }
    public static void main(String[] args) {
        BST bst = new BST();
        List<Integer> arr = new ArrayList<>();
        bst.root = new Node(7);
        bst.root.left = new Node(5);
        bst.root.right = new Node(4);
        bst.root.left.left = new Node(8);
        bst.root.left.right = new Node(6);
        bst.inOrderTraversal(bst.root, arr);
        System.out.println("Given BST: " + arr.toString());//Given BST: [8, 5, 6, 7, 4]
        findCulprits(arr);
        bst.fixBST(bst.root, arr.get(culpritIndex1), arr.get(culpritIndex2));
        arr.clear();
        bst.inOrderTraversal(bst.root, arr);
        System.out.println("BST after fix: "+ arr.toString()); //BST after fix: [4, 5, 6, 7, 8]
    }
}
