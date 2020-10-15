class Node {
    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }
}
class LinkedList {
    Node head;
    public void appendRecursively(Node root, int data){
        if (root.next==null) {
            root.next = new Node(data);
        } else {
            appendRecursively(root.next, data);
        }
    }
    public void printRecursively(Node root){
        if (root !=null){
        System.out.print(root.data + "->");
        printRecursively(root.next);
        } else {
            System.out.print("null");
        }
    }
}
public class Demo {
    public static void main(String[] args) {
        LinkedList linkedListRecursive = new LinkedList();
        linkedListRecursive.head = new Node(100);
        linkedListRecursive.appendRecursively(linkedListRecursive.head, 200);
        linkedListRecursive.appendRecursively(linkedListRecursive.head, 300);
        linkedListRecursive.printRecursively(linkedListRecursive.head); //100->200->300->null
    }
}
