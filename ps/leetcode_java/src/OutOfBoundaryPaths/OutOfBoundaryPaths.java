package OutOfBoundaryPaths;

import java.util.Arrays;

public class OutOfBoundaryPaths {

    final int MOD = (int)1e9 + 7;
    int[][][] dp;
    final int[] dy = {0,1,0,-1};
    final int[] dx = {1,0,-1,0};
    int r,c;

    boolean inRange(int y, int x){
        if(y<0 || x<0 || y>=r || x>=c) return false;
        return true;
    }

    private int solve(int y, int x, int cnt){
        if(!inRange(y,x)) return 1;
        if(cnt==0) return 0;
        if(dp[y][x][cnt]!=-1) return dp[y][x][cnt];
        dp[y][x][cnt] = 0;
        for(int i=0; i<4; ++i){
            int ny = y + dy[i];
            int nx = x + dx[i];
            dp[y][x][cnt] += solve(ny, nx, cnt-1);
            dp[y][x][cnt] %= MOD;
        }
        return dp[y][x][cnt];
    }

    public int findPaths(int m, int n, int N, int i, int j) {
        r = m;
        c = n;
        dp = new int[m][n][N+1];
        for(int o=0; o<m; ++o){
            for(int p=0; p<n; ++p){
                Arrays.fill(dp[o][p], -1);
            }
        }
        return solve(i,j,N);
    }

    public static void main(String[] args) {
        OutOfBoundaryPaths sol = new OutOfBoundaryPaths();
//        System.out.println(sol.findPaths(2,2,2,0,0));
        System.out.println(sol.findPaths(1,3,3,0,1));
    }
}
