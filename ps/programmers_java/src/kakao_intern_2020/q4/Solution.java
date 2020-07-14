package kakao_intern_2020.q4;


import java.util.LinkedList;
import java.util.Queue;

// bfs로 풀 수 있을 것 같다.
// 포인트는 좌표당 4방향 다 기록하는 것
// 1,1 은 0,0에서 우하로 가는것과 하우로 가는것이 있지만
public class Solution {
    class Pos{
        int y,x,d,cost; // d 동남서북 0123
        public Pos(int y, int x, int d, int cost) {
            this.y = y;
            this.x = x;
            this.d = d;
            this.cost = cost;
        }
    }
    final int[] dy = {0,1,0,-1};
    final int[] dx = {1,0,-1,0};
    int r,c;
    int [][][] dist;
    Queue<Pos> q;
    public void init(){
        for(int i=0; i<r; ++i){
            for(int j=0; j<c; ++j){
                for(int k=0; k<4; ++k){
                    dist[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
    }
    public boolean inRange(int y, int x){
        if(y<0 || y>=r || x<0 ||x>=c) return false;
        return true;
    }
    public void go(int y, int x, int d, int cost){
        for(int i=0; i<4; ++i){
            if(d==i){
                dist[y][x][i] = cost;
                q.add(new Pos(y,x,i,dist[y][x][i]));
            }
            else if(dist[y][x][i] > cost + 500){
                dist[y][x][i] = cost + 500;
                q.add(new Pos(y,x,i,dist[y][x][i]));
            }
        }
    }

    public int solution(int[][] board) {
        r = board.length;
        c = board[0].length;
        dist = new int[r][c][4];
        q = new LinkedList<>();
        init();
        go(0,0,0, 0);
        go(0,0,1, 0);
        while(!q.isEmpty()){
            Pos cur = q.poll();
            int cy = cur.y;
            int cx = cur.x;
            int d = cur.d;
            int cost = cur.cost;
            int ny = cy + dy[d];
            int nx = cx + dx[d];
            if(inRange(ny,nx) && board[ny][nx]==0 && dist[ny][nx][d] > cost+100){
                go(ny,nx,d,cost+100);
            }
        }
        int ret = dist[r-1][c-1][0];
        for(int i=1; i<4; ++i){
            ret = Math.min(ret, dist[r-1][c-1][i]);
        }
        return ret;
    }
    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        Solution sol = new Solution();
        sol.solution(arr);
    }
}
