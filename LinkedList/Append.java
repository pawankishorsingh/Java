class Node {
    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }
}

class LinkedList {
    Node head;
    public void append (int data){
        if (this.head == null){
            head = new Node(data);
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp=temp.next;
        }
        temp.next = new Node(data);
    }
    @Override
    public String toString(){
        Node temp = head;
        String result = "{head";
        while (temp !=null){
            result += " -> " +temp.data;
            temp = temp.next;
        }
        return result+"-> null}";
    }
}

public class Demo{
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(10);
        list.append(20);
        System.out.println(list); //{head -> 10 -> 20-> null}
    }
}
