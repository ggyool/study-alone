package boj11659;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int[] arr = new int[n+1];
        int[] psum = new int[n+1];
        stz = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; ++i){
            arr[i] = Integer.parseInt(stz.nextToken());
            psum[i] = psum[i-1] + arr[i];
        }
        int a,b;
        for(int i=0; i<m; ++i){
            stz = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stz.nextToken());
            b = Integer.parseInt(stz.nextToken());
            bw.write(psum[b] - psum[a-1] + "\n");
        }
        bw.close();

    }
}
