package boj1005;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] times; // i 건물을 지을 때 걸리는 시간
        int[] stored; // 선행 건물들을 지을 때 가장 오래 걸리는 시간을 기억하기 위한 배열
        int[] ind; // indgree
        List<Integer>[] adj;

        int tc = Integer.parseInt(br.readLine());
        for(int t=0; t<tc; ++t){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            times = new int[n+1];
            stored = new int[n+1];
            ind = new int[n+1];
            adj = new ArrayList[n+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; ++i){
                times[i] = Integer.parseInt(st.nextToken());
                // 정답으로 stored[fin] 을 출력한는데, ind 없는 fin도 있기 때문에 초기회
                stored[i] = times[i];
                adj[i] = new ArrayList<>();
            }
            for(int i=0; i<k; ++i){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adj[from].add(to);
                ++ind[to];
            }
            int fin = Integer.parseInt(br.readLine());
//          ---------- 여기까지 입력 --------


            Queue<Info> q = new LinkedList<>();
            for(int i=1; i<=n; ++i){
                if(ind[i]==0)
                    q.add(new Info(i, times[i]));
            }
            while (!q.isEmpty()){
                Info info = q.poll();
                // from 건물을 지을때 마치는 시간 finTime
                int from = info.idx;
                int finTime = info.t;
                for(int i=0; i<adj[from].size(); ++i){
                    int to = adj[from].get(i);
                    // 선행 건물이 여러 개일 수도 있으므로 기억
                    stored[to] = Math.max(stored[to], finTime + times[to]);
                    --ind[to];
                    if(ind[to] == 0){
                        // 처음에는 안 넣었으나 1500->900 정도로 시간이 줄어든다.
                        if(to==fin){
                            q.clear();
                            break;
                        }
                        q.add(new Info(to, stored[to]));
                    }
                }
            }
            bw.write(stored[fin] + "\n");
        }
        bw.close();
    }

    static class Info{
        int idx, t;
        public Info(int idx, int t) {
            this.idx = idx;
            this.t = t;
        }
    }

}
