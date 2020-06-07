package PossibleBipartition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 문제  잘 못 읽어서 고생 이분 그래프 문제
public class PossibleBipartition {
    public ArrayList<ArrayList<Integer>> adj;
    public static int[] group;
    public static int n;
    public boolean dfs(int cur){
        int len = adj.get(cur).size();
        for(int i=0; i<len; ++i){
            int next = adj.get(cur).get(i);
            if(group[next] == 0){
                group[next] = 3 - group[cur];
                if(dfs(next) == false)
                    return false;
            }
            else if(group[cur] == group[next]){
                return false;
            }
        }
        return true;
    }

    public boolean dfsAll(){
        group = new int[n+1];
        for(int i=1; i<=n; ++i){
            if(group[i] == 0){
                // 떨어진 컴포넌트라 상관 없는듯 1or2
                group[i] = 1;
                boolean res = dfs(i);
                if(res==false) return false;
            }
        }
        return true;
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        n = N;
        adj = new ArrayList<ArrayList<Integer>>();
        for(int i=1; i<=n+1; ++i){
            adj.add(new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            int from = dislike[0];
            int to = dislike[1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        return dfsAll();
    }

    public static void main(String[] args) {
        PossibleBipartition sol = new PossibleBipartition();
        int[][] arr = {{1,2}, {1,3}, {1,4}, {1,5}};
        System.out.println(sol.possibleBipartition(5, arr));
    }
}

