package boj3020;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 첫 풀이 - 구현 문제처럼 접근
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] ups = new int[h];
        int[] downs = new int[h];
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());
            if (i % 2 == 1) {
                ups[height - 1]++;
            } else {
                downs[h - height]++;
            }
        }

        int ans = n;
        int count = 0;
        int[] res = new int[h];
        int cur = n / 2;
        for (int i = 0; i < h; i++) {
            cur += downs[i];
            res[i] += cur;
            cur -= ups[i];
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
