package MinimumTimeToCollectAllApplesInATree_2;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeToCollectAllApplesInATree_2 {

    private int ans = 0;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] adj = new List[n];
        for(int i=0; i<n; ++i){
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<edges.length; ++i){
            int f = edges[i][0];
            int t = edges[i][1];
            adj[f].add(t);
            adj[t].add(f);
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(0, adj, hasApple, visited);
        return ans;
    }

    private boolean dfs(int cur, List<Integer>[] adj, List<Boolean> hasApple, boolean[] visited) {
        int len = adj[cur].size();
        boolean ret = false;
        for(int next : adj[cur]){
            if(visited[next]) continue;
            visited[next] = true;
            boolean res = dfs(next, adj, hasApple, visited);
            ret |= res;
            if(res) ans += 2;
        }
        return ret || hasApple.get(cur);
    }

}
