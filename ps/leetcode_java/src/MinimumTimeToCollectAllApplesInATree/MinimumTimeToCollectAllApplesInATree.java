package MinimumTimeToCollectAllApplesInATree;

import com.sun.javafx.geom.Edge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 처음 풀이, 사과에서 출발한다. 왜 어렵게 생각했을까.
// 가장 빠른 사람을 보니 이런식으로 풀었다. 부모를 한명이니 기억해서 풀면 쉽겠다.
public class MinimumTimeToCollectAllApplesInATree {

    int[] height;
    boolean[] visitied;
    List<Integer> adj[];

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        height = new int[n];
        visitied = new boolean[n];
        adj = new List[n];
        for(int i=0; i<n; ++i){
            adj[i] = new ArrayList<>();
        }
        // 부모 자식 순으로 나오지 않는다.
        for(int i=0; i<edges.length; ++i){
            int from = edges[i][0];
            int to = edges[i][1];
            adj[from].add(to);
            adj[to].add(from);
        }
        height[0] = 1;
        hdfs(0);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; ++i){
            if(hasApple.get(i)){
                visitied[i] = true;
                q.add(i);
            }
        }
        int ret = 0;
        while (!q.isEmpty()){
            int cur = q.poll();
            int len = adj[cur].size();
            for(int i=0; i<len; ++i){
                int next = adj[cur].get(i);
                System.out.println(next);
                if(height[next]>height[cur]) continue;
                ++ret;
                if(!visitied[next]){
                    visitied[next] = true;
                    q.add(next);
                }
            }
        }
        return ret*2;
    }

    private void hdfs(int cur){
        int len = adj[cur].size();
        for(int i=0; i<len; ++i){
            int next = adj[cur].get(i);
            if(height[next] == 0){
                height[next] = height[cur] + 1;
                hdfs(next);
            }
        }
    }

}
