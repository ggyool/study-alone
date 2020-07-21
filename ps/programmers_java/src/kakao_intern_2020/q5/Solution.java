package kakao_intern_2020.q5;

import java.util.*;

public class Solution {
    ArrayList<Integer>[] adj;
    boolean visited[];
    boolean rocks[];
    int keys[];
    Queue<Integer> q;
    HashSet<Integer> wait;

    public void visitAndOpen(int target){
        visited[target] = true;
        if(keys[target]!=-1){
            rocks[keys[target]] = false;
            if(wait.contains(keys[target])) {
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
        keys = new int[n];
        Arrays.fill(keys, -1);
        for (int[] o : order) {
            rocks[o[1]] = true;
            keys[o[0]] = o[1];
        }
        q = new LinkedList<>();
        wait = new HashSet<>();
        if(rocks[0]) return false;
        q.add(0);
        visitAndOpen(0);
        int cnt = 0;
        while (!q.isEmpty()){
            int cur = q.poll();
            ++cnt;
            int len = adj[cur].size();
            for(int i=0; i<len; ++i){
                int next = adj[cur].get(i);
                if(visited[next]) continue;
                if(rocks[next] && !wait.contains(next)) {
                    wait.add(next);
                    continue;
                }
                visitAndOpen(next);
                q.add(next);
            }
        }
        return cnt==n;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 9;
        int path[][] = {{8, 1}, {0, 1}, {1, 2}, {0, 7}, {4, 7}, {0, 3}, {7, 5},{3, 6}};
        int order[][] = {{4, 1}, {5, 2}};
        System.out.println(sol.solution(9,path, order));
    }
}
