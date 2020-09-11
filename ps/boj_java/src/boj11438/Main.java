package boj11438;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private void dfs(int cur, int[] depth, int[][] p, List<List<Integer>> adj){
        int len = adj.get(cur).size();
        for(int i=0; i<len; ++i){
            int next = adj.get(cur).get(i);
            if(depth[next] == 0){
                depth[next] = depth[cur] + 1;
                p[next][0] = cur;
                dfs(next, depth, p, adj);
            }
        }
    }

    private int lca(int a, int b, int[] depth, int[][] p){
        // 항상 a가 크도록
        if(depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        // god
        for(int i=16; i>=0; --i){
            if(depth[a] - (1<<i) >= depth[b]) {
                a = p[a][i];
            }
        }

        if(a==b) return a;
        for(int i=16; i>=0; --i){
            if(p[a][i] != p[b][i]){
                a = p[a][i];
                b = p[b][i];
            }
        }
        return p[a][0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> adj = new ArrayList<>();
        int[] depth = new int[n+1];

        // 2**17 == 130000..
        int[][] p = new int[n+1][17];
        for(int i=0; i<=n; ++i){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n-1; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        Main sol = new Main();
        depth[1] = 1;
        sol.dfs(1, depth, p, adj);

        for(int j=1; j<=16; ++j){
            for(int i=1; i<=n; ++i){
                p[i][j] = p[p[i][j-1]][j-1];
            }
        }

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(sol.lca(a,b,depth,p) + "\n");
        }
        br.close();
        bw.close();
    }
}
