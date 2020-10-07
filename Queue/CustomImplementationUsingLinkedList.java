/*
Output:
Is Empty?: true
Peek: -1
Creating first head 10
Appended 20
Appended 30
Removed: 10
Current Queue: 20 30 
Peek: 20
Is Empty?: false
 */
 
class Node {
    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }
}
class Queue {
    Node head;
    Node tail;
    public void add (int data){
        if (head == null){
            System.out.println("Creating first head " + data);
            head = new Node(data);
            tail = head;
            return;
        }
        System.out.println("Appended " + data);
        Node temp = new Node(data);
        tail.next = temp;
        tail= temp;
    }

    public int remove(){
        if (head == null){
            return -1;
        }
        int result = head.data;
        head = head.next;
        return result;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public int peek(){
        if (head != null)
            return head.data;
        return -1;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        while (temp != null){
            sb.append(temp.data + " ");
            temp = temp.next;
        }
        return sb.toString();
    }
}

public class Demo{
    public static void main(String[] args) {
        Queue queue = new Queue();
        System.out.println("Is Empty?: " + queue.isEmpty());
        System.out.println("Peek: "+ queue.peek());
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("Removed: "+ queue.remove());
        System.out.println("Current Queue: "+ queue);
        System.out.println("Peek: "+queue.peek());
        System.out.println("Is Empty?: " + queue.isEmpty());
    }
}
