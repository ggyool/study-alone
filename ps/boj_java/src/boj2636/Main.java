package boj2636;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static final int EDGE = -1;
    private static final int AIR = 0;
    private static final int CHEESE = 1;
    private static final int[] dy = {0, 1, 0, -1};
    private static final int[] dx = {1, 0, -1, 0};

    private int r, c;
    private int[][] board;
    private Set<Pos> edges = new HashSet<>();


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    private void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (isEdge(i, j)) {
                    edges.add(new Pos(i, j));
                    board[i][j] = EDGE;
                } else {
                    board[i][j] = n;
                }
            }
        }
        int time = 0;
        int count = 0;
        while (true) {
            Set<Pos> cheeses = findMeltingCheeses();
            if (cheeses.isEmpty()) {
                break;
            }
            time++;
            count = cheeses.size();
            melt(cheeses);
        }
        bw.write(time + System.lineSeparator());
        bw.write(count + System.lineSeparator());
        br.close();
        bw.close();
    }

    private boolean isEdge(int y, int x) {
        return y == 0 || y == r - 1 || x == 0 || x == c - 1;
    }

    private Set<Pos> findMeltingCheeses() {
        Set<Pos> cheeses = new HashSet<>();
        List<Pos> airs = findAirs();

        for (Pos air : airs) {
            int cy = air.y;
            int cx = air.x;
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (inRange(ny, nx) && isCheese(ny, nx)) {
                    cheeses.add(new Pos(ny, nx));
                }
            }
        }
        return cheeses;
    }

    private List<Pos> findAirs() {
        Queue<Pos> q = makeEdgeQueue();
        List<Pos> airs = new ArrayList<>(q);
        boolean[][] visited = new boolean[r][c];
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            int cy = cur.y;
            int cx = cur.x;
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (inRange(ny, nx) && !visited[ny][nx] && isAir(ny, nx)) {
                    Pos air = new Pos(ny, nx);
                    visited[ny][nx] = true;
                    q.add(air);
                    airs.add(air);
                }
            }
        }
        return airs;
    }

    private Queue<Pos> makeEdgeQueue() {
        Queue<Pos> q = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            q.add(new Pos(i, 0));
            q.add(new Pos(i, c - 1));
        }
        for (int j = 1; j < c - 1; j++) {
            q.add(new Pos(0, j));
            q.add(new Pos(r - 1, j));
        }
        return q;
    }

    private boolean inRange(int y, int x) {
        return 0 <= y && y <= r - 1 && 0 <= x && x <= c - 1;
    }

    private boolean isAir(int y, int x) {
        return board[y][x] == AIR;
    }

    private boolean isCheese(int y, int x) {
        return board[y][x] == CHEESE;
    }

    private void melt(Set<Pos> cheeses) {
        for (Pos cheese : cheeses) {
            board[cheese.y][cheese.x] = AIR;
        }
    }
}

class Pos {

    int y, x;

    public Pos(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pos pos = (Pos) o;
        return y == pos.y && x == pos.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}