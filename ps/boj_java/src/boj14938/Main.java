package boj14938;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] items = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(a).add(new Edge(b, w));
            adj.get(b).add(new Edge(a, w));
        }
        int ans = 0;
        for (int start = 1; start <= n; start++) {
            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            PriorityQueue<Node> nodes = new PriorityQueue<>();
            nodes.add(new Node(start, 0));
            dist[start] = 0;

            while (!nodes.isEmpty()) {
                Node curNode = nodes.poll();
                int cur = curNode.index;
                int curDist = curNode.dist;
                if (curDist > dist[cur]) continue;
                List<Edge> edges = adj.get(cur);
                for (Edge edge : edges) {
                    int next = edge.to;
                    int weight = edge.weight;
                    if (dist[next] > dist[cur] + weight) {
                        dist[next] = dist[cur] + weight;
                        nodes.add(new Node(next, dist[next]));
                    }
                }
            }

            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] <= m) {
                    sum += items[i];
                }
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
        br.close();
        bw.close();
    }


    private static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private static class Node implements Comparable<Node> {
        int index;
        int dist;

        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            // 양수이면 자리를 바꾼다.
            return dist - o.dist;
        }
    }
}
