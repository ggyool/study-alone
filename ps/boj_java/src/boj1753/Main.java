package boj1753;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int sta = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] adj = new ArrayList[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=1; i<=n; ++i){
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<m; ++i){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj[from].add(new Edge(to, cost));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[sta] = 0;
        pq.add(new Node(sta, 0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int cIdx = cur.idx;
            int cDist = cur.dist;
            if(dist[cIdx]<cDist) continue;
            int len = adj[cIdx].size();
            for(int i=0; i<len; ++i){
                Edge edge = adj[cIdx].get(i);
                int target = edge.to;
                int cost = edge.cost;
                if(dist[target] > cDist + cost){
                    dist[target] = cDist + cost;
                    pq.add(new Node(target, dist[target]));
                }
            }
        }
        for(int i=1; i<=n; ++i){
            if(dist[i] == Integer.MAX_VALUE){
                bw.write("INF\n");
            }
            else{
                bw.write(dist[i] + "\n");
            }
        }
        br.close();
        bw.close();
    }
}

class Edge{
    int to, cost;
    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

class Node implements Comparable<Node> {
    int idx, dist;
    public Node(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }
    @Override
    public int compareTo(Node o) {
        return dist - o.dist;
    }
}