// A Dynamic Programming based Java program to find minimum
// number operations to convert str1 to str2
class Node {
    private int data;
    private Node nextNode = null;
    public Node(int data){
        this.data = data;
    }
    public int getData(){
        return this.data;
    }
    public Node getNextNode(){
        return this.nextNode;
    }
    public void setData(int data){
        this.data= data;
    }
    public void setNextNode(Node node){
        this.nextNode = node;
    }
}

class Stack {
    int maxSize;
    int runningSize = 0;
    Node top;

    public Stack(int maxSize){
        this.maxSize = maxSize;
        this.top = null;
    }

    public void push(int data){
        if (runningSize == maxSize){
            System.out.println("Stack is full, can't add.");
            return;
        }
        this.runningSize++;
        if (top==null){
            top = new Node(data);
            return;
        }

        Node temp = new Node(data);
        temp.setNextNode(this.top);
        this.top = temp;
    }

    public int pop(){
        if (this.top == null){
            return -1;
        }
        int result = this.top.getData();
        this.top = top.getNextNode();
        this.runningSize--;
        return result;
    }

    public int peek(){
        return this.top == null? -1: this.top.getData();
    }

    public boolean isEmpty(){
        return this.top == null;
    }

    public boolean isFull(){
        return this.maxSize == this.runningSize;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node temp = this.top;
        while (temp != null){
            sb.append(temp.getData()+ " | ");
            temp = temp.getNextNode();
        }
        return sb + " (RunningSize = " + this.runningSize + ")";
    }

}

class Solution {
    public static void main(String args[]) {
        Stack stack = new Stack(3);
        System.out.println("Peeked: " + stack.peek());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Current Stack: " + stack);
        System.out.println("Popped: " + stack.pop());
        System.out.println("Current Stack: " + stack);
        stack.push(30000);
        stack.push(99999);
        System.out.println("Peeked: " + stack.peek());
        System.out.println("IsEmpty? " + stack.isEmpty());
        System.out.println("IsFull? " + stack.isFull());
    }
}
