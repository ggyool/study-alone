package boj2798;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; ++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = -1;
        for(int i=0; i<n-2; ++i){
            for(int j=i+1; j<n-1; ++j){
                for(int k=j+1; k<n; ++k){
                    int val = arr[i] + arr[j] + arr[k];
                    if(val>m) continue;
                    ans = Math.max(ans, val);
                }
            }
        }
        bw.write(ans + "\n");
        bw.close();
    }
}
