package DecodeString_2;

import java.util.Stack;


// 재귀를 안쓰는 풀이 숙지

public class DecodeString_2 {
    public String decodeString(String s) {
        Stack<StringBuilder> strStk = new Stack<>();
        Stack<Integer> numStk = new Stack<>();
        StringBuilder res = new StringBuilder();
        int num = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = 10*num + c - '0';
            }
            else if(c=='['){
                strStk.add(res);
                numStk.add(num);
                num = 0;
                res = new StringBuilder();
            }
            else if(c==']'){
                StringBuilder tmp = res;
                res = strStk.pop();
                int cnt = numStk.pop();
                for(int i=0; i<cnt; ++i){
                    res.append(tmp);
                }
            }
            else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
