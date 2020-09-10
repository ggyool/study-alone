package boj1922;



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] visitied = new boolean[n+1];
        List<List<Line>> adj = new ArrayList<>();
        for(int i=0; i<n+1; ++i){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<m; ++i){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            adj.get(s).add(new Line(e, d));
            adj.get(e).add(new Line(s, d));
        }

        PriorityQueue<Line> pq = new PriorityQueue<>();
        int start = 1;
        visitied[start] = true;
        for(int i=0; i<adj.get(start).size(); ++i){
            Line line = adj.get(start).get(i);
            pq.add(line);
        }
        int ans = 0;
        while(!pq.isEmpty()){
            Line line = pq.poll();
            int next = line.to;
            if(visitied[next]) continue;
            visitied[next] = true;
            ans += line.dist;
            int len = adj.get(next).size();
            for(int i=0; i<len; ++i){
                pq.add(adj.get(next).get(i));
            }
        }
        bw.write(ans + "\n");
        br.close();
        bw.close();
    }
}



class Line implements Comparable<Line>{
    int to, dist;
    public Line(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }

    @Override
    public int compareTo(Line o) {
        return dist-o.dist;
    }
}


