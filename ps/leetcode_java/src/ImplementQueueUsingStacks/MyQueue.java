package ImplementQueueUsingStacks;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stk;
    public MyQueue() {
        stk = new Stack<>();
    }
    public void push(int x) {
        Stack<Integer> tmp = new Stack<>();
        while(!stk.isEmpty()){
            tmp.push(stk.pop());
        }
        stk.push(x);
        while(!tmp.isEmpty()){
            stk.push(tmp.pop());
        }
    }

    public int pop() {
        return stk.pop();
    }
    public int peek() {
        return stk.peek();
    }
    public boolean empty() {
        return stk.isEmpty();
    }
}
