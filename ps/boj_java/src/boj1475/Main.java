package boj1475;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int[] cnt = new int[10];
        int len = s.length();
        for(int i=0; i<len; ++i){
            char c = s.charAt(i);
            ++cnt[c-'0'];
        }
        int ans = 0;
        for(int i=0; i<=8; ++i){
            if(i==6) continue;
            ans = Math.max(ans, cnt[i]);
        }
        int sixNine = cnt[6]+cnt[9];
        int tmp = sixNine/2 + ((sixNine%2==1)?1:0);
        ans = Math.max(ans, tmp);
        System.out.println(ans);
    }
}
