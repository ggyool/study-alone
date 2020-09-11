package boj1916;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        List<List<Edge>> adj = new ArrayList<>();
        for(int i=0; i<=n; ++i){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<m; ++i){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.get(s).add(new Edge(e, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, dist[start]));
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.idx;
            int curDist = curNode.val;
            if(curDist>dist[cur]) continue;

            int len = adj.get(cur).size();
            for(int i=0; i<len; ++i){
                Edge edge = adj.get(cur).get(i);
                int cost = edge.cost;
                int next = edge.to;
                if(curDist+cost < dist[next]){
                    dist[next] = curDist+cost;
                    pq.add(new Node(next, dist[next]));
                }
            }
        }
        bw.write(dist[end] + "\n");
        br.close();
        bw.close();
    }
}

class Node implements Comparable<Node>{
    int idx, val;

    public Node(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }

    @Override
    public int compareTo(Node o) {
        return val-o.val;
    }
}

class Edge {
    int to, cost;
    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
