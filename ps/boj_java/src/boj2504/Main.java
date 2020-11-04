package boj2504;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Stack<charInfo> stk = new Stack<>();
        Stack<numInfo> nstk = new Stack<>();
        for(int i=0; i<s.length(); ++i){
            char right = s.charAt(0);
            if(!stk.isEmpty()){
                char left = stk.peek().c;
                int lidx = stk.peek().idx;
                if(left=='(' && right==')'){
                    if(i-lidx==1) nstk.add(new numInfo(2, lidx, i));
                    else{
                        numInfo bef = nstk.pop();
                        if(lidx<bef.lidx && bef.ridx<i){
                            nstk.add(new numInfo(2*bef.val, lidx, i));
                        }
                        else{
                            nstk.add(new numInfo(2bef.val, lidx, i));
                        }
                    }
                }
                if(left=='[' && right==']'){
                    if(i-lidx==1) nstk.add(new numInfo(3, lidx, i));
                }
            }
        }
    }

    private

}

class charInfo {
    char c;
    int idx;
    public charInfo(char c, int idx) {
        this.c = c;
        this.idx = idx;
    }
}

class numInfo{
    int val, lidx, ridx;
    public numInfo(int val, int lidx, int ridx) {
        this.val = val;
        this.lidx = lidx;
        this.ridx = ridx;
    }
}
