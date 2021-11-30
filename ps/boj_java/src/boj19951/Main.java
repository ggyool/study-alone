package boj19951;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] starts = new int[n + 1];
        int[] ends = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            starts[s] += p;
            ends[e] += p;
        }

        int cur = 0;
        for (int i = 1; i <= n; i++) {
            cur += starts[i];
            arr[i] += cur;
            cur -= ends[i];
        }

        for (int i = 1; i <= n; i++) {
            bw.write(arr[i] + " ");
        }

        br.close();
        bw.close();
    }
}
