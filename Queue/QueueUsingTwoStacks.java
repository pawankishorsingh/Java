//Ref: https://www.youtube.com/watch?v=7ArHz8jPglw&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=2

import java.util.Stack;

class MyQueueUsingTwoStacks {
    Stack <Integer> newestOnTopStack = new Stack<>();
    Stack <Integer> oldestOnTopStack = new Stack<>();
    public void enqueue(int data){
        System.out.println("Enqueued: "+ data);
        newestOnTopStack.add(data);
    }
    public int dequeue(){
        if (oldestOnTopStack.isEmpty()) {
            while (!newestOnTopStack.isEmpty()) {
                oldestOnTopStack.add(newestOnTopStack.pop());
            }
        }
        return oldestOnTopStack.pop();
    }
}
public class Demo {
    public static void main(String[] args) {
        MyQueueUsingTwoStacks queue = new MyQueueUsingTwoStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Deque: " + queue.dequeue()); //Deque: 10
        System.out.println("Deque: " + queue.dequeue()); //Deque: 20
        System.out.println("Deque: " + queue.dequeue()); //Deque: 30
    }
}
