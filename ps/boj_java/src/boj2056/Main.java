package boj2056;

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
        int[] ind = new int[n+1];
        int[] time = new int[n+1];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n+1; ++i){
            adj.add(new ArrayList<>());
        }
        // graph init
        for(int i=1; i<=n; ++i){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            ind[i] = m;
            for(int j=0; j<m; ++j){
                int s = Integer.parseInt(st.nextToken());
                adj.get(s).add(i);
            }
        }

        // 끝나는 시간을 담는 pq
        PriorityQueue<Task> pq = new PriorityQueue<>();
        for(int i=1; i<=n; ++i){
            if(ind[i]==0){
                pq.add(new Task(i, time[i]));
            }
        }
        int ans = 0;
        while (!pq.isEmpty()){
            Task task = pq.poll();
            int cur = task.idx;
            int curTime = task.finishTime;
            ans = Math.max(ans, curTime);
            int len = adj.get(cur).size();
            for(int i=0; i<len; ++i){
                int next = adj.get(cur).get(i);
                --ind[next];
                if(ind[next]==0)
                    pq.add(new Task(next, curTime+time[next]));
            }
        }
        bw.write(ans + "\n");
        br.close();
        bw.close();
    }
}

class Task implements Comparable<Task>{
    int idx;
    int finishTime;
    public Task(int idx, int finishTime) {
        this.idx = idx;
        this.finishTime = finishTime;
    }
    @Override
    public int compareTo(Task o) {
        return finishTime - o.finishTime;
    }
}
