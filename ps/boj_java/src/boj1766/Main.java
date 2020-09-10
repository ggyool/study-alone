package boj1766;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] ind = new int[n+1];
        List<Integer>[] adj = new ArrayList[n+1];
        for(int i=1; i<=n; ++i){
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<m; ++i){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            ++ind[e];
            adj[s].add(e);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1; i<=n; ++i){
            if(ind[i]==0) pq.add(i);
        }

        while(!pq.isEmpty()){
            int cur = pq.poll();
            bw.write(cur + " ");
            int len = adj[cur].size();
            for(int i=0; i<len; ++i){
                int next = adj[cur].get(i);
                --ind[next];
                if(ind[next]==0) pq.add(next);
            }
        }
        br.close();
        bw.close();
    }
}
