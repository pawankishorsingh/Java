//Ref: https://www.youtube.com/watch?v=MFOAbpfrJ8g&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=4

import java.util.HashSet;
import java.util.Set;

class Node {
    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }
}

class LinkedList {
    Node head;
    public boolean hasCycleUsingHashSet(){
        Set<Node> set = new HashSet<>();
        Node temp = head;
        while (true){
            if (temp == null){
                return false;
            }
            if (set.contains(temp)){
                return true; // It's a cycle !!!
            } else {
                set.add(temp);
                temp = temp.next;
            }
        }
    }
    public boolean hasCycleUsingTwoPointers(){
        if (head ==null)
            return false;
        Node slow = head;
        Node fast = head.next;
        while (true) {
            if (fast == null)
                return false;
            if (slow == fast){
                return true;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
    }
}

public class Demo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);
        list.head.next.next.next.next.next.next.next = new Node(8);
        list.head.next.next.next.next.next.next.next.next = new Node(9);
        list.head.next.next.next.next.next.next.next.next.next = list.head.next;
        System.out.println(list.hasCycleUsingHashSet()); //true
        System.out.println(list.hasCycleUsingTwoPointers()); //true
    }
}
