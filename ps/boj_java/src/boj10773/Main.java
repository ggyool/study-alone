package boj10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 조금 빠른 답들은 큰 배열 하나 만들어 놓고 인덱스 옮겨가며 덮어씀
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<n; ++i){
            int num = Integer.parseInt(br.readLine());
            if(num==0)
                stk.pop();
            else
                stk.push(num);
        }
        int ans = 0;
        while (!stk.isEmpty()) {
            ans += stk.pop();
        }
        System.out.println(ans);
    }
}
