package kakao_intern_2020.q2;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Solution {
    long calc(char c, long n1, long n2){
        long res = 0;
        if(c=='*') res = n1*n2;
        if(c=='-') res = n1-n2;
        if(c=='+') res = n1+n2;
        return res;
    }
    public long solution(String expression) {
        long answer = 0;
        String[] res = expression.split("[-|+|*]");
        List<Long> originNumbers = new LinkedList<>();
        for(String s : res) {
            originNumbers.add(Long.parseLong(s));
        }
        List<Character> originOps = new LinkedList<>();
        int len = expression.length();
        for(int i=0; i<len; ++i){
            char c = expression.charAt(i);
            if(c == '*' || c == '+' || c == '-')
                originOps.add(c);
        }
        char[][] seqs = {
                {'*','+','-'},
                {'*','-','+'},
                {'-','+','*'},
                {'-','*','+'},
                {'+','-','*'},
                {'+','*','-'}
        };
        // slow fast iterator 2개 만드려 했는데 linkedlist 문제가 있다.
        for (char[] seq : seqs) {
            List<Long> numbers = new LinkedList<>(originNumbers);
            List<Character> ops = new LinkedList<>(originOps);
            for(int i=0; i<seq.length; ++i){
                char c = seq[i];
                ListIterator<Long> numIt = numbers.listIterator();
                ListIterator<Character> opIt = ops.listIterator();
                // 100-200*300*500+20
                while(opIt.hasNext()){
                    char op = opIt.next();
                    if(op==c){
                        opIt.remove();
                        // 지우고 간다. 반대로는 못할 듯
                        long first = numIt.next();
                        numIt.remove();
                        long second = numIt.next();
                        numIt.set(calc(op, first, second));
                        numIt.previous(); // 로직상 뒤로 한칸 가야한다.
                    }
                    else{
                        numIt.next();
                    }
                }
            }
            long num = numbers.get(0);
            answer = Math.max(answer, Math.abs(num));
        }
        return answer;
    }
}
