class Node {
    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }
}
class LinkedList{
    Node head;
    public void append (int data){
        if (head == null){
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
        StringBuilder result = new StringBuilder();
        result.append("{head");
        Node temp = head;
        while (temp != null){
            result.append(" -> " + temp.data);
            temp = temp.next;
        }
        return result.append(" -> null}").toString();
    }
}
public class Demo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(10);
        list.append(20);
        list.append(30);
        System.out.println(list);
    }
}
