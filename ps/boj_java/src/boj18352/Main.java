package boj18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj.get(from).add(to);
        }
        int[] dist = new int[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(x);
        while (!q.isEmpty()) {
            int cur = q.poll();
            List<Integer> neighbors = adj.get(cur);
            for (Integer neighbor : neighbors) {
                if (neighbor == x || dist[neighbor] > 0) continue;
                dist[neighbor] = dist[cur] + 1;
                if (dist[neighbor] < k) {
                    q.add(neighbor);
                }
            }
        }

        boolean isExistent = false;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == k) {
                System.out.println(i);
                isExistent = true;
            }
        }
        if (!isExistent) {
            System.out.println(-1);
        }
        br.close();
    }
}
