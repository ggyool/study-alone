package KthSmallestElementInASortedMatrix;

import java.util.PriorityQueue;

// 정답은 2분 탐색 풀이
public class KthSmallestElementInASortedMatrix {
    private final int[] dy = {0, 1};
    private final int[] dx = {1, 0};
    private int r;
    private int c;

    public int kthSmallest(int[][] matrix, int k) {
        this.r = matrix.length;
        this.c = matrix[0].length;

        PriorityQueue<Pos> pq = new PriorityQueue<Pos>();
        boolean[][] visited = new boolean[r][c];
        Pos pos;

        visited[0][0] = true;
        pq.add(new Pos(0, 0, matrix[0][0]));

        while (true) {
            pos = pq.poll();
            k--;
            if (k==0) {
                break;
            }
            int cy = pos.y;
            int cx = pos.x;
            for (int i = 0; i < 2; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (inRange(ny, nx) && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    pq.add(new Pos(ny, nx, matrix[ny][nx]));
                }
            }
        }

        return matrix[pos.y][pos.x];
    }

    private boolean inRange(int y, int x) {
        if(y>=r || x>=c) {
            return false;
        }
        return true;
    }
}

class Pos implements Comparable<Pos>{
    int y,x, val;

    public Pos(int y, int x, int val) {
        this.y = y;
        this.x = x;
        this.val = val;
    }

    @Override
    public int compareTo(Pos o) {
        return val - o.val;
    }
}
