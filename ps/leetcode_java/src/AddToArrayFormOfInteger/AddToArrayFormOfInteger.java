package AddToArrayFormOfInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        Stack<Integer> stk = new Stack<>();
        boolean plus = false;
        int i = A.length-1;
        while(i>=0 && K!=0){
            int num = A[i--] + K%10;
            if(plus) {
                num += 1;
                plus = false;
            }
            stk.add(num%10);
            if(num>=10) plus = true;
            K /= 10;
        }
        while (i>=0){
            int num = A[i--];
            if(plus) {
                num += 1;
                plus = false;
            }
            stk.add(num%10);
            if(num>=10) plus = true;
        }
        while(K!=0){
            int num = K%10;
            if(plus) {
                num += 1;
                plus = false;
            }
            stk.add(num%10);
            if(num>=10) plus = true;
            K /= 10;
        }
        if(plus) stk.add(1);

        List<Integer> ret = new ArrayList<>();
        while(!stk.isEmpty()){
            ret.add(stk.pop());
        }
        return ret;
    }
}
