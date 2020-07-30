package boj1197;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n+1];
        ArrayList<Edge>[] adj = new ArrayList[n+1];
        for(int i=1; i<=n; ++i){
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<m; ++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Edge(b,c));
            adj[b].add(new Edge(a,c));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int start = 1;
        visited[start] = true;
        for(int i=0; i<adj[start].size(); ++i){
            pq.add(adj[start].get(i));
        }
        int ret = 0;
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int next = cur.to;
            if(visited[next]) continue;
            ret += cur.cost;
            visited[next] = true;
            for(int i=0; i<adj[next].size(); ++i){
                Edge target = adj[next].get(i);
                if(visited[target.to] == false){
                    pq.add(target);
                }
            }
        }
        bw.write(ret + "\n");
        br.close();
        bw.close();
    }
}

class Edge implements Comparable<Edge>{
    int to, cost;
    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return cost - o.cost;
    }
}

