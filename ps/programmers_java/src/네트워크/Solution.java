package 네트워크;

public class Solution {
    boolean[] visited;
    int n;
    int[][] computers;
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        visited = new boolean[n];
        return dfsAll();
    }

    private int dfsAll(){
        int ret = 0;
        for(int i=0; i<n; ++i){
            if(visited[i]==false){
                visited[i] = true;
                ++ret;
                dfs(i);
            }
        }
        return ret;
    }

    private void dfs(int cur) {
        for(int i=0; i<n; ++i){
            if(i==cur || visited[i] || computers[cur][i]==0) continue;
            visited[i] = true;
            dfs(i);
        }
    }
}
