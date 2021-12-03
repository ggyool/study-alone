package boj3020;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// ups와 donws를 edges로 줄여 공간 복잡도 개선
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] edges = new int[h + 1];
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());
            if (i % 2 == 1) {
                edges[height]--;
            } else {
                edges[h - height]++;
            }
        }

        int ans = n;
        int count = 0;
        int[] res = new int[h];
        int cur = n / 2;
        for (int i = 0; i < h; i++) {
            cur += edges[i];
            res[i] += cur;
            if (res[i] < ans) {
                count = 1;
                ans = res[i];
            } else if (res[i] == ans) {
                count++;
            }
        }

        bw.write(ans + " " + count);

        br.close();
        bw.close();
    }
}
