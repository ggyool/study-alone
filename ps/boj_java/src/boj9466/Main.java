package boj9466;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    int[] arr;
    int[] root;
    int[] dist;

    private int solve(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        root = new int[n+1];
        dist = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; ++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return dfsAll(n);
    }

    private int dfsAll(int n){
        int ret = 0;
        for(int i=1; i<=n; ++i){
            if(root[i] == 0){
                root[i] = i;
                dist[i] = 1;
                ret += dfs(i);
            }
        }
        return ret;
    }

    private int dfs(int cur){
        int next = arr[cur];
        if(root[next]!=0){
            if(root[next]==root[cur])
                return dist[next] - 1;
            else
                return dist[cur];
        }
        root[next] = root[cur];
        dist[next] = dist[cur] + 1;
        return dfs(next);
    }

    public static void main(String[] args) throws IOException {
        Main sol = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for(int t=0; t<tc; ++t){
            bw.write(sol.solve(br) + "\n");
        }
        br.close();
        bw.close();
    }
}
