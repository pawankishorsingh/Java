class Node {
    private int data;
    private Node previous;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class DoublyLinkedList {
    private Node head;
    public void insertAtHead(int num){
        Node node = new Node(num);
        if (head==null){
            head = node;
            return;
        }
        node.setNext(head);
        head.setPrevious(node);
        head = node;
    }

    public void insertAtEnd(int num){
        Node node = new Node(num);
        if (head ==null){
            head = node;
            return;
        }
        Node temp = head;
        while (temp.getNext() !=null){
            temp = temp.getNext();
        }
        node.setPrevious(temp);
        temp.setNext(node);
    }

    @Override
    public String toString() {
        String result="";
        Node temp = head;
        while(temp!= null){
            result+=" "+temp.getData();
            temp=temp.getNext();
        }
        return result;
    }
}

public class Demo {
    public static void main(String[] args){
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtHead(10);
        list.insertAtHead(5);
        System.out.println(list); // 5 10
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        System.out.println(list); // 5 10 20 30
    }
}
