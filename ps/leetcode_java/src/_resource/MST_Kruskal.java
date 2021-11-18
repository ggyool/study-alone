package _resource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


/*
정리
프림
Edge 구조체 - to, cost 필요, 양방향으로 구성
2차원 vector
min heap

크루스칼
Edge 구조체 - from, to cost, 단방향으로 구성
1차원 vector 정렬
union-find
 */
public class MST_Kruskal {
    // 1922
    private int find(int x, int[] p) {
        if (p[x] == x) return x;
        return p[x] = find(p[x], p);
    }

    private void union(int x, int y, int[] p) {
        x = find(x, p);
        y = find(y, p);
        p[y] = x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; ++i) p[i] = i;
        List<Line> adj = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            adj.add(new Line(s, e, d));
        }
        Collections.sort(adj);
        MST_Kruskal sol = new MST_Kruskal();
        int ans = 0;
        int len = adj.size();
        for (int i = 0; i < len; ++i) {
            Line line = adj.get(i);
            int from = line.from;
            int to = line.to;
            int dist = line.dist;
            if (sol.find(from, p) != sol.find(to, p)) {
                ans += dist;
                sol.union(from, to, p);
            }
        }
        bw.write(ans + "\n");
        br.close();
        bw.close();
    }

    private static class Line implements Comparable<Line> {
        int from, to, dist;

        public Line(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Line o) {
            return dist - o.dist;
        }
    }
}



