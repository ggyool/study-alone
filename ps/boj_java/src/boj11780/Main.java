package boj11780;

import java.io.*;
import java.util.*;

public class Main {
    private List<Integer> tracking(int s, int e, int[][] via){
        List<Integer> ret = new ArrayList<>();
        int v = via[s][e];
        if(v==0) {
            ret.add(s);
            return ret;
        }
        ret.addAll(tracking(s,v,via));
        ret.addAll(tracking(v,e,via));
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][n+1];
        // i,j를 갈 때 k를 거쳐갔다는 뜻
        int[][] via = new int[n+1][n+1];
        final int INF = (int)1e8;
        for(int i=1; i<=n; ++i){
            for(int j=1; j<=n; ++j){
                if(i==j) dp[i][j] = 0;
                else dp[i][j] = INF;
            }
        }
        for(int i=0; i<m; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dp[a][b] = Math.min(dp[a][b], c);
        }
        for(int k=1; k<=n; ++k){
            for(int i=1; i<=n; ++i){
                for(int j=1; j<=n; ++j){
                    if(dp[i][j] > dp[i][k]+dp[k][j]){
                        dp[i][j] = dp[i][k]+dp[k][j];
                        via[i][j] = k;
                    }
                }
            }
        }

        for(int i=1; i<=n; ++i){
            for(int j=1; j<=n; ++j){
                bw.write(dp[i][j] + " ");
            }
            bw.write("\n");
        }

        Main sol = new Main();
        for(int i=1; i<=n; ++i){
            for(int j=1; j<=n; ++j){
                if(dp[i][j]==0) bw.write("0\n");
                else{
                    List<Integer> list = sol.tracking(i, j, via);
                    list.add(j);
                    bw.write(list.size() + " ");
                    for (Integer num : list) {
                        bw.write(num + " ");
                    }
                    bw.write("\n");
                }
            }
        }

        br.close();
        bw.close();
    }
}
