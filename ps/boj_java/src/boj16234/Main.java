package boj16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main sol = new Main();
        sol.solve();
    }

    int n, l, r;
    int[][] arr;
    final int[] dy = {0,1,0,-1};
    final int[] dx = {1,0,-1,0};

    private void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for(int i=0; i<n; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; ++j){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        while (bfsAll()){
            ++ans;
        }
        System.out.println(ans);
    }


    boolean inRange(int y, int x) {
        if(y<0 || x<0 || y>=n || x>=n) return false;
        return true;
    }

    private boolean bfsAll() {
        boolean ret = false;
        boolean[][] visited = new boolean[n][n];
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                if(!visited[i][j]){
                    ret |= bfs(visited, i, j);
                }
            }
        }
        return ret;
    }

    private boolean bfs(boolean[][] visited, int y, int x) {
        int cnt = 1;
        int sum = arr[y][x];
        Queue<Pos> q = new LinkedList<>();
        Queue<Pos> sq = new LinkedList<>(); // store
        visited[y][x] = true;
        q.add(new Pos(y, x));
        sq.add(new Pos(y, x));
        while(!q.isEmpty()) {
            Pos cp = q.poll();
            int cy = cp.y;
            int cx = cp.x;
            for(int i=0; i<4; ++i){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(!inRange(ny, nx) || visited[ny][nx]) continue;
                int diff = Math.abs(arr[cy][cx] - arr[ny][nx]);
                if(l<=diff && diff<=r){
                    visited[ny][nx] = true;
                    ++cnt;
                    sum += arr[ny][nx];
                    q.add(new Pos(ny,nx));
                    sq.add(new Pos(ny,nx));
                }
            }
        }
        if(cnt==1){
            return false;
        }
        int val = sum / cnt;
        while(!sq.isEmpty()) {
            Pos pos = sq.poll();
            arr[pos.y][pos.x] = val;
        }
        return true;
    }

}

class Pos{
    int y, x;
    public Pos(int y, int x) {
        this.y = y;
        this.x = x;
    }
}