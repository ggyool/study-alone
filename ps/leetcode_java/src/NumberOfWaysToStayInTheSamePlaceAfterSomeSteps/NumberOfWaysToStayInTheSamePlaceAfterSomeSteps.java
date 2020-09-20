package NumberOfWaysToStayInTheSamePlaceAfterSomeSteps;

import java.util.Arrays;

public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {

    final int MOD = (int)1e9 + 7;
    // 길이, 위치
    int[][] dp;
    int maxArr;

    private int dfs(int i, int j){
        if(i==0) {
            if(j==0) return 1;
            return 0;
        }

        if(dp[i][j]!=-1) return dp[i][j];

        dp[i][j] = 0;
        // stay를 추가하는 경우
        dp[i][j] += dfs(i-1, j);
        dp[i][j] %= MOD;

        // left
        if(j+1<=maxArr-1){
            dp[i][j] += dfs(i-1, j+1);
            dp[i][j] %= MOD;
        }

        // right
        if(j-1>=0){
            dp[i][j] += dfs(i-1, j-1);
            dp[i][j] %= MOD;
        }
        return dp[i][j];
    }

    public int numWays(int steps, int arrLen) {
        // steps가 500까지라 arrLen 이 클 필요가 없는데 문제에서는 1e6까지이다.
        // 그냥 돌리면 메모리 초과나서 넣음
        if(arrLen>=500) arrLen = 500;
        maxArr = arrLen;
        dp = new int[steps+1][arrLen+1];
        for(int i=0; i<steps+1; ++i){
            Arrays.fill(dp[i], -1);
        }
        return dfs(steps, 0);
    }

    public static void main(String[] args) {
        NumberOfWaysToStayInTheSamePlaceAfterSomeSteps sol = new NumberOfWaysToStayInTheSamePlaceAfterSomeSteps();
        System.out.println(sol.numWays(430,148488));
    }

}
