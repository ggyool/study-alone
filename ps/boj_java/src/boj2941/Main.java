package boj2941;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String[] pattern = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="};
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int slen = s.length();
        int plen = pattern.length;
        int i = 0;
        int ans = 0;
        // ddz=z=
        while(i<slen) {
            boolean isFind = false;
            String target = "";
            for(int j=0; j<plen; ++j){
                target = pattern[j];
                boolean isSame = true;
                for(int k=0; k<target.length(); ++k){
                    if(i+k>=slen || s.charAt(i+k)!=target.charAt(k)) {
                        isSame = false;
                        break;
                    }
                }
                if(isSame) {
                    isFind = true;
                    break;
                }
            }
            if(isFind) {
                i += target.length();
            }
            else {
                ++i;
            }
            ++ans;
        }
        System.out.println(ans);
    }
}
