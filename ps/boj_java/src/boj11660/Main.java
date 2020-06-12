package boj11660;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int[][] psum = new int[n+1][n+1];
        for(int i=1; i<=n; ++i){
            stz = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; ++j){
                int num = Integer.parseInt(stz.nextToken());
                psum[i][j] = psum[i-1][j] + psum[i][j-1] - psum[i-1][j-1] + num;
            }
        }
        for(int i=0; i<m; ++i){
            stz = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(stz.nextToken());
            int y1 = Integer.parseInt(stz.nextToken());
            int x2 = Integer.parseInt(stz.nextToken());
            int y2 = Integer.parseInt(stz.nextToken());
            bw.write(psum[x2][y2] - psum[x1-1][y2] - psum[x2][y1-1] + psum[x1-1][y1-1] + "\n");
        }
        bw.close();

    }
}
