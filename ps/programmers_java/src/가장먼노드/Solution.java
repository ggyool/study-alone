package 가장먼노드;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    ArrayList<Integer>[] adj;
    boolean[] visited;
    int[] dist;

    public int solution(int n, int[][] edge) {
        initGraph(n, edge);
        bfs(n);
        return solve(n);
    }

    private void initGraph(int n, int[][] edge) {
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge.length; i++) {
            int from = edge[i][0];
            int to = edge[i][1];
            adj[from].add(to);
            adj[to].add(from);
        }
    }

    private void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        this.visited = new boolean[n + 1];
        this.dist = new int[n + 1];
        visited[1] = true;
        q.add(1);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : adj[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
    }

    private int solve(int n) {
        int max = -1;
        for (int i = 1; i <= n; i++) {
            if (visited[i] && dist[i] > max) {
                max = dist[i];
            }
        }
        int ret = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == max) {
                ++ret;
            }
        }
        return ret;
    }
}
