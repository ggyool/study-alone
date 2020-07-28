package EvaluateReversePolishNotation;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    boolean isDigit(String s){
        char c = s.charAt(0);
        if(Character.isDigit(c)) return true;
        else if(c=='-' && s.length()>1) return true;
        return false;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String token : tokens){
            if(isDigit(token)){
                stk.push(Integer.parseInt(token));
            }
            else{
                int n2 = stk.pop();
                int n1 = stk.pop();
                if(token.equals("*"))
                    stk.push(n1*n2);
                else if(token.equals("/"))
                    stk.push(n1/n2);
                else if(token.equals("-"))
                    stk.push(n1-n2);
                else if(token.equals("+"))
                    stk.push(n1+n2);
            }
        }
        return stk.pop();
    }
}
