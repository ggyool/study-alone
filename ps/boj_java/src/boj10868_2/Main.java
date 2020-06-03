package boj10868_2;

import java.io.*;
import java.util.StringTokenizer;

// 선처리 - nlogn
// O(m*log(n))
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        for(int i=1; i<=n; ++i){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // i부터 2**j개 구간의 최소값
        // 2**16 = 65536
        int[][] dp = new int[n+1][17];
        for(int i=1; i<=n; ++i){
            dp[i][0] = arr[i];
        }

        for(int j=1; j<17; ++j){
            for(int i=1; i<=n; ++i){
                if(i+(1<<j)-1<=n){
                    dp[i][j] = Math.min(dp[i][j-1], dp[i+(1<<(j-1))][j-1]);
                }
                else{
                    break;
                }
            }
        }

        int a,b,ans,c;
        for(int tc=0; tc<m; ++tc){
            ans = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            // log 구하기
            c = 0;
            for(int i=0; i<=17; ++i){
                if((1<<i) > b-a+1) {
                    c = i;
                    break;
                }
            }
            --c;
            ans = Math.min(dp[a][c], dp[b-(1<<c)+1][c]);
            bw.write(ans + "\n");
        }
        br.close();
        bw.close();
    }
}
