//Ref: https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/

import java.util.Stack;
public class Demo {
    static class MyStack {
        Stack<Integer> stack = new Stack<>();
        int min;
        void push(int data){
            if (stack.isEmpty()){
                min = data;
                stack.push(data);
            } else {
                if (data < min){
                    stack.push(min-data);
                    min = data;
                } else {
                    stack.push(data);
                }
            }
        }
        int pop(){
            if (!stack.isEmpty()){
                int data = stack.pop();
                if (data <= min){
                    min = min + data;
                    data = min;
                }
                return data;
            }
            return Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(18);
        myStack.push(19);
        myStack.push(29);
        myStack.push(15);
        myStack.push(16);
        System.out.println("Min:" + myStack.min); //15
        myStack.pop();
        myStack.pop();
        System.out.println("Min:" + myStack.min); //18
    }
}
