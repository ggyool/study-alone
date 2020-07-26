package ValidParentheses;

import java.util.Stack;

public class ValidParentheses {
    final char[] open = {'(', '[', '{'};
    final char[] close = {')', ']', '}'};
    public int getOpenIndex(char ch){
        for(int i=0; i<3; ++i){
            if(ch == open[i])
                return i;
        }
        return -1;
    }
    public int getCloseIndex(char ch){
        for(int i=0; i<3; ++i){
            if(ch == close[i])
                return i;
        }
        return -1;
    }

    public boolean isValid(String s) {
        Stack<Integer> stk = new Stack<>();
        int len = s.length();
        for(int i=0; i<len; ++i){
            char ch = s.charAt(i);
            int oi = getOpenIndex(ch);
            if(oi!=-1) stk.push(oi);
            else{
                int ci = getCloseIndex(ch);
                if(stk.empty() || stk.peek() != ci) return false;
                stk.pop();
            }
        }
        return stk.empty();
    }
}
