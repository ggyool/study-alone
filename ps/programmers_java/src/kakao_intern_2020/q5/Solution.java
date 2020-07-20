package kakao_intern_2020.q5;

import java.util.*;

public class Solution {
    ArrayList<Integer>[] adj;
    boolean visited[];
    boolean rocks[];
    boolean isExistWq[];
    int keys[];
    Queue<Integer> q, wq;

    // open 하면서 wq에 있으면 q에 넣는 코드를 넣으니 마지막 효율성 통과하였다.
    public void visitAndOpen(int target){
        visited[target] = true;
        if(keys[target]!=-1){
            rocks[keys[target]] = false;
            if(isExistWq[keys[target]]) {
                isExistWq[keys[target]] = false;
                visitAndOpen(keys[target]);
                q.add(keys[target]);
            }
        }
    }

    public boolean solution(int n, int[][] path, int[][] order) {
        adj = new ArrayList[n];
        for(int i=0; i<n; ++i){
            adj[i] = new ArrayList<>();
        }
        for (int[] load : path) {
            int from = load[0];
            int to = load[1];
            adj[from].add(to);
            adj[to].add(from);
        }
        visited = new boolean[n];
        rocks = new boolean[n];
        isExistWq = new boolean[n];
        keys = new int[n];
        Arrays.fill(keys, -1);
        for (int[] o : order) {
            rocks[o[1]] = true;
            keys[o[0]] = o[1];
        }
        q = new LinkedList<>();
        wq = new LinkedList<>();
        if(rocks[0]) return false;
        q.add(0);
        visitAndOpen(0);
        while(!q.isEmpty() || !wq.isEmpty()){
            while (!q.isEmpty()){
                int cur = q.poll();
                int len = adj[cur].size();
                for(int i=0; i<len; ++i){
                    int next = adj[cur].get(i);
                    if(visited[next]) continue;
                    if(rocks[next] && !isExistWq[next]) {
                        isExistWq[next] = true;
                        wq.add(next);
                        continue;
                    }
                    visitAndOpen(next);
                    q.add(next);
                }
            }
            int len = wq.size();
            for(int i=0; i<len; ++i){
                int cur = wq.poll();
                if(isExistWq[cur] == false) continue;
                if(rocks[cur]){
                    wq.add(cur);
                }
                else {
                    isExistWq[cur] = false;
                    visitAndOpen(cur);
                    q.add(cur);
                }
            }
            if(q.isEmpty() && !wq.isEmpty()) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 9;
        int path[][] = {{8, 1}, {0, 1}, {1, 2}, {0, 7}, {4, 7}, {0, 3}, {7, 5},{3, 6}};
        int order[][] = {{4, 1}, {5, 2}};
        System.out.println(sol.solution(9,path, order));
    }
}
