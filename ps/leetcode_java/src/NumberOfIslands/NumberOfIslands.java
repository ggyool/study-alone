package NumberOfIslands;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class NumberOfIslands {
    final int[] dy = {0,1,0,-1};
    final int[] dx = {1,0,-1,0};
    class Pos{
        int y, x;
        Pos(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public int numIslands(char[][] grid) {
        int r = grid.length;
        if(r==0) return 0;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int cnt = 0;
        for(int i=0; i<r; ++i){
            for(int j=0; j<c; ++j){
                if(visited[i][j]==false && grid[i][j]=='1'){
                    ++cnt;
                    Stack<Pos> stk = new Stack<>();
                    stk.push(new Pos(i, j));
                    while(!stk.isEmpty()){
                        Pos cur = stk.pop();
                        for(int k=0; k<4; ++k){
                            int ny = cur.y + dy[k];
                            int nx = cur.x + dx[k];
                            if(ny>=0 && nx>=0 && ny<r && nx<c && visited[ny][nx]==false && grid[ny][nx]=='1'){
                                visited[ny][nx] = true;
                                stk.add(new Pos(ny, nx));
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
