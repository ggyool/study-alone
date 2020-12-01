package ShortestPathWithAlternatingColors;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathWithAlternatingColors {
    boolean[][] redEdges;
    boolean[][] blueEdges;
    int[][] dist;            // i번 노드에 0(빨강)으로 방문, 1(파랑) 으로 방문한 거리
    int n;

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        this.n = n;
        redEdges = new boolean[n][n];
        blueEdges = new boolean[n][n];
        dist = new int[n][2];
        for (int i = 0; i < n; i++) {
            dist[i][0] = -1;
            dist[i][1] = -1;
        }

        // from == to 일 수 있음
        for (int i = 0; i < red_edges.length; i++) {
            int from = red_edges[i][0];
            int to = red_edges[i][1];
            redEdges[from][to] = true;
        }
        for (int i = 0; i < blue_edges.length; i++) {
            int from = blue_edges[i][0];
            int to = blue_edges[i][1];
            blueEdges[from][to] = true;
        }

        bfs();

        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            if (dist[i][0] == -1 && dist[i][1] == -1) {
                ret[i] = -1;
            }
            else if (dist[i][0] == -1) {
                ret[i] = dist[i][1];
            }
            else if (dist[i][1] == -1) {
                ret[i] = dist[i][0];
            }
            else {
                ret[i] = Math.min(dist[i][0], dist[i][1]);
            }
        }
        return ret;
    }

    private void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, true));
        q.add(new Node(0, false));
        dist[0][0] = 0;
        dist[0][1] = 0;

        while (!q.isEmpty()) {
            Node curNode = q.poll();
            int cur = curNode.idx;
            boolean befRed = curNode.isBeforeRed;
            System.out.println(cur + " " + befRed);
            for (int next = 0; next < n; next++) {
                if (befRed) {                           // 파랑색으로 방문해야 함
                    if (!blueEdges[cur][next]) continue;
                    if (dist[next][1] != -1) continue;
                    dist[next][1] = dist[cur][0] + 1;
                    q.add(new Node(next, false));
                }
                else {
                    if (!redEdges[cur][next]) continue;
                    if (dist[next][0] != -1) continue;
                    dist[next][0] = dist[cur][1] + 1;
                    q.add(new Node(next, true));
                }
            }
        }
    }


    public static void main(String[] args) {
        ShortestPathWithAlternatingColors sol = new ShortestPathWithAlternatingColors();
        int n = 3;
        int[][] arr1 = {{0,1},{1,2}};
        int[][] arr2 = {};
        sol.shortestAlternatingPaths(n, arr1, arr2);
    }
}

class Node {
    int idx;
    boolean isBeforeRed;

    public Node(int idx, boolean isBeforeRed) {
        this.idx = idx;
        this.isBeforeRed = isBeforeRed;
    }
}

