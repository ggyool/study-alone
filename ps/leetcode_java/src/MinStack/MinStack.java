package MinStack;

import java.util.Stack;

public class MinStack {
    class Pair{
        int val, min;
        Pair(){}
        Pair(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    Stack<Pair> stk;
    public MinStack() {
        stk = new Stack<>();
    }

    public void push(int x) {
        int min;
        if(stk.empty()) min = x;
        else{
            min = Math.min(x, stk.peek().min);
        }
        stk.push(new Pair(x, min));
    }

    public void pop() {
        stk.pop();
    }

    public int top() {
        return stk.peek().val;
    }

    public int getMin() {
        return stk.peek().min;
    }
}
