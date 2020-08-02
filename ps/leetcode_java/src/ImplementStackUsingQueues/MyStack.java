package ImplementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }
    public void push(int x) {
        Queue<Integer> tmp = new LinkedList<>();
        while(!q.isEmpty()){
            tmp.add(q.poll());
        }
        q.add(x);
        while(!tmp.isEmpty()){
            q.add(tmp.poll());
        }
    }
    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }
    public boolean empty() {
        return q.isEmpty();
    }

}
