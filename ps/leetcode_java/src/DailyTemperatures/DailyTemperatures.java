package DailyTemperatures;

import java.util.Stack;

public class DailyTemperatures {
    class Pair{
        int val, idx;
        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
    public int[] dailyTemperatures(int[] T) {
        int[] ret = new int[T.length];
        Stack<Pair> stk = new Stack<>();
        int len = T.length;
        for(int i=0; i<len; ++i){
            int n = T[i];
            while(!stk.isEmpty() && stk.peek().val < n){
                int idx = stk.pop().idx;
                ret[idx] = i - idx;
            }
            stk.push(new Pair(n, i));
        }
        return ret;
    }
}
