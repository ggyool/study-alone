package DecodeString_3;

// 2번풀이의 numStk strStk 대신 재귀로
// Stack을 매개변수로 사용하여 깔끔한 전달

import java.util.Stack;

public class DecodeString_3 {
    private String makeString(Stack<Character> stk){
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while(!stk.isEmpty()){
            char c = stk.pop();
            if(Character.isDigit(c)){
                num = 10*num + c-'0';
            }
            else if(c=='['){
                String add = makeString(stk);
                for(int i=0; i<num; ++i){
                    sb.append(add);
                }
                // 3[xxx]2[xxx] 이런 경우 여러번 루프를 도므로 초기화 함
                num = 0;
            }
            else if(c==']'){
                break;
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String decodeString(String s) {
        Stack<Character> stk = new Stack<>();
        int len = s.length();
        for(int i=0; i<len; ++i){
            stk.push(s.charAt(len-1-i));
        }
        return makeString(stk);
    }
}
