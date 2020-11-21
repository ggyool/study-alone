package boj1005;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] times;
        List<Integer>[] adj;

        int tc = Integer.parseInt(br.readLine());
        for(int t=0; t<tc; ++t){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            times = new int[n+1];
            adj = new ArrayList[n+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; ++i){
                times[i] = Integer.parseInt(st.nextToken());
                adj[i] = new ArrayList<>();
            }
            for(int i=0; i<k; ++i){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adj[to].add(from);
            }

        }
    }

}
