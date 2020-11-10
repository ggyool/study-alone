package boj2504_2;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Stack<Info> stk = new Stack<>();
        int sum = 0;
        int tmp = 1;
        for(int i=0; i<s.length(); ++i){
            char c = s.charAt(i);
            if(!stk.isEmpty()){
                Info info = stk.peek();
                if( (info.c=='(' && c==')') || (info.c=='[' && c==']') ){
                    if(info.idx+1==i) sum += tmp;
                    stk.pop();
                }else{
                    stk.push(new Info(c, i));
                }
            }
            else{
                stk.push(new Info(c, i));
            }
            if(c=='(') tmp *= 2;
            if(c=='[') tmp *= 3;
            if(c==')') tmp /= 2;
            if(c==']') tmp /= 3;
        }
        if(!stk.isEmpty()) System.out.println(0);
        else System.out.println(sum);
    }
}

class Info{
    char c;
    int idx;
    public Info(char c, int idx) {
        this.c = c;
        this.idx = idx;
    }
}
