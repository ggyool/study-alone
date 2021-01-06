package BeautifulArrangement;

public class BeautifulArrangement {

    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        int[] cnt = {0};
        pick(1, n, visited, cnt);
        return cnt[0];
    }

    private void pick(int seq, int n, boolean[] visited, int[] cnt) {
        if (seq >= n + 1) {
            cnt[0]++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            if (i % seq == 0 || seq % i == 0) {
                visited[i] = true;
                pick(seq + 1, n, visited, cnt);
                visited[i] = false;
            }
        }
    }
}
