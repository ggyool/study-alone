package boj1197_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int find(int[] p, int x){
        if(x==p[x]) return x;
        return p[x] = find(p, p[x]);
    }
    private static void union(int[] p, int x, int y){
        x = find(p, x);
        y = find(p, y);
        p[y] = x;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] p = new int[n+1];
        for(int i=1; i<=n; ++i) p[i] = i;
        List<Edge> edges = new ArrayList<>();
        for(int i=0; i<m; ++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a,b,c));
        }
        Collections.sort(edges);
        int ret = 0;
        for (Edge edge : edges) {
            int from = edge.from;
            int to = edge.to;
            int cost = edge.cost;
            if(find(p, from) != find(p, to)){
                ret += cost;
                union(p, from, to);
            }
        }
        bw.write(ret + "\n");
        br.close();
        bw.close();
    }
}

class Edge implements Comparable<Edge>{
    int from, to, cost;
    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return cost - o.cost;
    }
}

