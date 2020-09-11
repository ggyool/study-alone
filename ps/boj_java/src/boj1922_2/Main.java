package boj1922_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private int find(int x, int[] p){
        if(p[x] == x) return x;
        return p[x] = find(p[x], p);
    }
    private void union(int x, int y, int[] p){
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
        int[] p = new int[n+1];
        for(int i=1; i<=n; ++i) p[i] = i;
        List<Line> adj = new ArrayList<>();
        for(int i=0; i<m; ++i){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            adj.add(new Line(s,e,d));
        }
        Collections.sort(adj);
        Main sol = new Main();
        int ans = 0;
        int len = adj.size();
        for(int i=0; i<len; ++i){
            Line line = adj.get(i);
            int from = line.from;
            int to = line.to;
            int dist = line.dist;
            if(sol.find(from, p) != sol.find(to, p)){
                ans += dist;
                sol.union(from, to, p);
            }
        }
        bw.write(ans + "\n");
        br.close();
        bw.close();
    }
}

class Line implements Comparable<Line>{
    int from, to, dist;
    public Line(int from, int to, int dist) {
        this.from = from;
        this.to = to;
        this.dist = dist;
    }
    @Override
    public int compareTo(Line o) {
        return dist-o.dist;
    }
}
