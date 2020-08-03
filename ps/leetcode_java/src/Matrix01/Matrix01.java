package Matrix01;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    public int[][] updateMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dist = new int[r][c];
        Queue<Pos> q = new LinkedList<>();
        for(int i=0; i<r; ++i){
            for(int j=0; j<c ;++j){
                dist[i][j] = -1;
                if(matrix[i][j]==0){
                    q.add(new Pos(i, j));
                    dist[i][j] = 0;
                }
            }
        }
        final int[] dy = {0,1,0,-1};
        final int[] dx = {1,0,-1,0};
        while(!q.isEmpty()){
            Pos cur = q.poll();
            for(int i=0; i<4; ++i){
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if(ny<0 || nx<0 || ny>=r || nx>=c) continue;
                if(dist[ny][nx] == -1){
                    dist[ny][nx] = dist[cur.y][cur.x] + 1;
                    q.add(new Pos(ny, nx));
                }
            }
        }
        return dist;
    }
}

class Pos{
    int y,x;
    public Pos(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

