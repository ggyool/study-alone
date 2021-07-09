package boj2583;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = {0, 1, 0, -1};
    private static final int[] dx = {1, 0, -1, 0};
    private int r, c;
    private boolean[][] isExistent, visited;

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
        int k = Integer.parseInt(st.nextToken());

        isExistent = new boolean[r][c];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int ldx = Integer.parseInt(st.nextToken());
            int ldy = Integer.parseInt(st.nextToken());
            int rux = Integer.parseInt(st.nextToken());
            int ruy = Integer.parseInt(st.nextToken());
            for (int j = ldy; j < ruy; j++) {
                for (int l = ldx; l < rux; l++) {
                    isExistent[j][l] = true;
                }
            }
        }

        List<Integer> areas = findEmptyAreas();
        Collections.sort(areas);
        bw.write(areas.size() + System.lineSeparator());
        for (Integer area : areas) {
            bw.write(area + " ");
        }
        br.close();
        bw.close();
    }

    private List<Integer> findEmptyAreas() {
        visited = new boolean[r][c];
        List<Integer> areas = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!isExistent[i][j] && !visited[i][j]) {
                    isExistent[i][j] = true;
                    visited[i][j] = true;
                    areas.add(dfs(i, j));
                }
            }
        }
        return areas;
    }

    private int dfs(int y, int x) {
        int ret = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (inRange(ny, nx) && !isExistent[ny][nx] && !visited[ny][nx]) {
                isExistent[ny][nx] = true;
                visited[ny][nx] = true;
                ret += dfs(ny, nx);
            }
        }
        return ret;
    }

    private boolean inRange(int y, int x) {
        if (y < 0 || y >= r || x < 0 || x >= c) {
            return false;
        }
        return true;
    }
}
