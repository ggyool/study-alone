package MinimumTimeToCollectAllApplesInATree_3;

import java.util.*;

// 처음 풀이 업그레이드
public class MinimumTimeToCollectAllApplesInATree_3 {

    int[] p;
    List<Integer> adj[];

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        p = new int[n];
        Arrays.fill(p, -1);
        adj = new List[n];
        for(int i=0; i<n; ++i){
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<edges.length; ++i){
            int from = edges[i][0];
            int to = edges[i][1];
            adj[from].add(to);
            adj[to].add(from);
        }
        p[0] = 0;
        dfs(0);
        boolean[] seen = new boolean[n];
        seen[0] = true;
        int cnt = 0;
        for (int i=0; i<n; i++) {
            if (hasApple.get(i)) {
                for (int j=i; !seen[j]; j=p[j]) {
                    seen[j] = true;
                    cnt++;
                }
            }
        }
        return cnt*2;
    }

    private void dfs(int cur){
        int len = adj[cur].size();
        for(int i=0; i<len; ++i){
            int next = adj[cur].get(i);
            if(p[next]==-1){
                p[next] = cur;
                dfs(next);
            }
        }
    }
}
