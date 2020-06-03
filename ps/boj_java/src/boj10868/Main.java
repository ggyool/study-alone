package boj10868;

import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

// 선처리 - n
// O(m*sqrt(n))
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i=0; i<n; ++i){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int r = (int)Math.sqrt(n);
        int gn = n/r;
        if(n%r>0) ++gn;
        int[] grr = new int[gn];

        for(int i=0; i<n; ++i){
            if(i%r==0){
                grr[i/r] = arr[i];
            }
            else{
                grr[i/r] = Math.min(grr[i/r], arr[i]);
            }
        }


        int a,b,ans;
        for(int tc=0; tc<m; ++tc){
            ans = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            --a;
            --b;
            // 같은 구간인 경우
            if(a/r == b/r){
                for(int i=a; i<=b; ++i){
                    ans = Math.min(ans, arr[i]);
                }
            }
            else{
                for(int i=a; i<=a/r*r+r-1; ++i){
                    ans = Math.min(ans, arr[i]);
                }
                // 사이 구간 grr[a/r+1] ~ grr[b/r-1]
                for(int i=a/r+1; i<b/r; ++i){
                    ans = Math.min(ans, grr[i]);
                }
                int end = Math.min(n-1, b/r*r+r-1);
                for(int i=b; i>=b/r*r; --i){
                    ans = Math.min(ans, arr[i]);
                }
            }
            bw.write(ans + "\n");
        }
        br.close();
        bw.close();
    }
}
