class Node {
    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }
}
class LinkedList{
    Node head;

    public void prepend (int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public void deleteWithValue(int data){
        if (head ==null)
            return;
        if (head.data == data){
            head = head.next;
        }
        Node temp = head;
        while (temp.next != null){
            if (temp.next.data == data){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
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
        list.prepend(10);
        list.prepend(20);
        list.prepend(30);
        System.out.println(list); //{head -> 30 -> 20 -> 10 -> null}
        list.deleteWithValue(10);
        System.out.println(list); //{head -> 30 -> 20 -> null}
    }
}
