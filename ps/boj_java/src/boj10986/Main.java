package boj10986;

import java.io.*;
import java.util.StringTokenizer;

// (psum[j]-psum[i-1])%m == 0
// psum[j]%m==0 && psum[i-1]%m==0
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int[] arr = new int[n+1];
        int[] psum = new int[n+1];
        long[] cnt = new long[1001];
        cnt[0] = 1;
        stz = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; ++i){
            arr[i] = Integer.parseInt(stz.nextToken());
            psum[i] = psum[i-1] + arr[i];
            psum[i] %= m;
            ++cnt[psum[i]];
        }
        long ans = 0;
        for(int i=0; i<m; ++i){
            if(cnt[i]>=2){
                ans += cnt[i]*(cnt[i]-1)/2;
            }
        }
        bw.write(Long.toString(ans));
        bw.close();
    }
}
