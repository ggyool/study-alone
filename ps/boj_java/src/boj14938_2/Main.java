package boj14938_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int INF = (int) 1e8;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] items = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    dp[i][j] = INF;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dp[a][b] = Math.min(dp[a][b], w);
            dp[b][a] = Math.min(dp[b][a], w);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // 더하는 과정에서 오버플로우 조심 (Integer.MAX_VALUE로 초기화 x)
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        int ans = 0;
        for (int start = 1; start <= n; start++) {
            int sum = 0;
            for (int end = 1; end <= n; end++) {
                if (dp[start][end] <= m) {
                    sum += items[end];
                }
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
        br.close();
    }
}
