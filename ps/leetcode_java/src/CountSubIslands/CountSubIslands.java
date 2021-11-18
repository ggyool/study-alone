package CountSubIslands;

public class CountSubIslands {

    private final int[] dy = {0, 1, 0, -1};
    private final int[] dx = {1, 0, -1, 0};

    private int[][] grid1, grid2;
    private int r, c;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.grid1 = grid1;
        this.grid2 = grid2;
        this.r = grid1.length;
        this.c = grid1[0].length;

        int ans = calcBoard2();
        return ans;
    }

    private int calcBoard2() {
        boolean[][] visited = new boolean[r][c];
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && grid2[i][j] == 1) {
                    visited[i][j] = true;
                    if (traverseBoard2(i, j, visited)) {
                        if (grid1[i][j] == 1)
                            count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean traverseBoard2(int y, int x, boolean[][] visited) {
        boolean res = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (!inRange(ny, nx) || grid2[ny][nx] == 0 || visited[ny][nx]) continue;
            if (grid1[ny][nx] == 0) {
                res = false;
            }
            visited[ny][nx] = true;
            res &= traverseBoard2(ny, nx, visited);
        }
        return res;
    }

    private boolean inRange(int y, int x) {
        if (y < 0 || y >= r || x < 0 || x >= c) return false;
        return true;
    }
}
