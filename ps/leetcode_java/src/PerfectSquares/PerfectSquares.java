package PerfectSquares;

import java.util.*;

public class PerfectSquares {

    // 배열쓰면 50ms Map쓰면 350ms
    int[] dp;
    public int numSquares(int n) {
        dp = new int[n+1];
        for(int i=1; i<=n; ++i){
            dp[i] = i;
            for(int j=1; j*j<=i; ++j){
                dp[i] = Math.min(dp[i], 1 + dp[i-j*j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares sol = new PerfectSquares();
        System.out.println(sol.numSquares(21000000));
    }
}
