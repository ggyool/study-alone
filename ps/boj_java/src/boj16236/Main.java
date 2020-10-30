package boj16236;

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

    final int[] dy = {0,1,0,-1};
    final int[] dx = {1,0,-1,0};
    int n;
    int[][] arr;
    int size = 2;
    int eatenAmount = 0;
    int y, x;

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i<n; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; ++j){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==9) {
                    y = i;
                    x = j;
                    arr[i][j] = 0;
                }
            }
        }
        int ans = 0;
        while (true) {
            int res = calcDistWithNearestFish();
            if(res==-1) break;
            ans += res;
        }
        System.out.println(ans);
    }

    private boolean inRange(int y, int x) {
        if(y<0 || x<0 || y>=n || x>=n) return false;
        return true;
    }

    // -1 이면 먹을 수 있는 물고기가 없다.
    private int calcDistWithNearestFish(){
        int minDist = Integer.MAX_VALUE;
        int fy = -1, fx = -1;
        Queue<Pos> q = new LinkedList<>();
        int[][] dist = new int[n][n];
        dist[y][x] = 1;
        q.add(new Pos(y, x));
        while (!q.isEmpty()) {
            Pos cp = q.poll();
            int cy = cp.y;
            int cx = cp.x;
            for(int i=0; i<4; ++i){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(!inRange(ny,nx) || dist[ny][nx]!=0) continue;
                if(arr[ny][nx]==size || arr[ny][nx]==0) {
                    dist[ny][nx] = dist[cy][cx] + 1;
                    q.add(new Pos(ny,nx));
                }
                else if(1<=arr[ny][nx] && arr[ny][nx]<size){
                    dist[ny][nx] = dist[cy][cx] + 1;
                    if(dist[ny][nx]<minDist){
                        minDist = dist[ny][nx];
                        fy = ny;
                        fx = nx;
                    }
                    else if(dist[ny][nx]==minDist){
                        if(ny<fy) {
                            fy = ny;
                            fx = nx;
                        }
                        else if(ny==fy && nx<fx) {
                            fy = ny;
                            fx = nx;
                        }
                    }
                }
            }
        }
        if(fy==-1) return -1;
        // yam yam
        y = fy;
        x = fx;
        arr[fy][fx] = 0;
        ++eatenAmount;
        if(size==eatenAmount) {
            ++size;
            eatenAmount = 0;
        }
        return dist[fy][fx] - 1;
    }

}

class Pos {
    int y, x;
    public Pos(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
