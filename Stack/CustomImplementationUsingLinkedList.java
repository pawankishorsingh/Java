/*
Output:
Is Empty?: true
30
20
10

Is Empty?: false
Peek: 30
Popped: 30
Peek: 20
 */

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }
}

class Stack{
    Node top;
    public void push(int data){
        if (top ==null){
            top = new Node(data);
            return;
        }
        Node temp = new Node(data);
        temp.next = top;
        top = temp;
    }

    public int pop(){
        if (top == null){
            return -1;
        }
        int result = top.data;
        top = top.next;
        return result;
    }

    public boolean isEmpty(){
        return top ==null;
    }

    public int peek(){
        int result = top==null? -1: top.data;
        return result;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node temp = top;
        while (temp !=null){
            sb.append(temp.data+"\n");
            temp=temp.next;
        }
        return sb.toString();
    }
}

public class Demo {
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("Is Empty?: "+stack.isEmpty());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        System.out.println("Is Empty?: "+stack.isEmpty());
        System.out.println("Peek: "+ stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Peek: "+ stack.peek());
    }
}
