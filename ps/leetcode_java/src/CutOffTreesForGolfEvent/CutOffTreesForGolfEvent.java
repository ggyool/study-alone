package CutOffTreesForGolfEvent;

import java.util.*;

public class CutOffTreesForGolfEvent {
    private final static int[] dy = {0, 1, 0, -1};
    private final static int[] dx = {1, 0, -1, 0};
    private int r;
    private int c;

    public int cutOffTree(List<List<Integer>> forest) {
        r = forest.size();
        c = forest.get(0).size();
        int ans = 0;
        List<Node> list = new ArrayList<Node>();

        list.add(new Node(0,0,0));
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int h = forest.get(i).get(j);
                if (h > 1) {
                    list.add(new Node(i, j, h));
                }
            }
        }
        Collections.sort(list);

        for (int i = 0; i < list.size() - 1; i++) {
            Node from = list.get(i);
            Node to = list.get(i+1);
            int dist = calcDistance(from, to, forest);
            if (dist == -1) {
                return -1;
            }
            ans += dist;
        }

        return ans;
    }

    private int calcDistance(Node from, Node to, List<List<Integer>> forest) {
        int[][] dist = new int[r][c];
        Queue<Pos> q = new LinkedList<Pos>();

        q.add(new Pos(from.y, from.x));
        dist[from.y][from.x] = 1;

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            int cy = cur.y;
            int cx = cur.x;
            if (cy == to.y && cx == to.x) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (!inRange(ny, nx) || dist[ny][nx] !=0) continue;

                int nh = forest.get(ny).get(nx);
                if (nh != 0) {
                    dist[ny][nx] = dist[cy][cx] + 1;
                    q.add(new Pos(ny, nx));
                }
            }
        }
        return dist[to.y][to.x] - 1;
    }

    private boolean inRange(int y, int x) {
        if (y<0 || x<0 || y>=r || x>=c) {
            return false;
        }
        return true;
    }

}

class Pos {
    int y, x;

    public Pos(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Node implements Comparable<Node>{
    int y, x, h;

    public Node(int y, int x, int h) {
        this.y = y;
        this.x = x;
        this.h = h;
    }

    @Override
    public int compareTo(Node o) {
        return h - o.h;
    }
}
