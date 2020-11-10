package boj2504;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    boolean noAnswer = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Main sol = new Main();
        int res = sol.recur(0, s.length()-1, s);
        if(sol.noAnswer) System.out.println(0);
        else System.out.println(res);
    }

    private int recur(int l, int r, String s){
        // 기저는 곱하는 상황
        if(l>r) return 1;
        int idx = getRightIndex(l, r, s);
        if(idx==-1) {
            this.noAnswer = true;
            return -1;
        }
        if(idx==r) {
            if(s.charAt(r)==')') return 2*recur(l+1, r-1, s);
            else  return 3*recur(l+1, r-1, s);
        }
        else{
            return recur(l, idx, s) + recur(idx+1, r, s);
        }
    }


    private int getRightIndex(int l, int r, String s){
        Stack<Character> stk = new Stack<>();
        for(int i=l; i<=r; ++i){
            char c = s.charAt(i);
            if(!stk.isEmpty()){
                if(stk.peek()=='(' && c==')'){
                    stk.pop();
                    if(stk.isEmpty()) return i;
                }
                else if(stk.peek()=='[' && c==']'){
                    stk.pop();
                    if(stk.isEmpty()) return i;
                }
                else{
                    stk.push(c);
                }
            }
            else{
                stk.push(c);
            }
        }
        if(stk.isEmpty()) return r;
        return -1;
    }


}
