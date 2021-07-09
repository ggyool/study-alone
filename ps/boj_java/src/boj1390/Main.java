package boj1390;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        final int MOD = 9901;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        // j : 왼쪽에 놓고, 오른쪽에 놓고, 둘 다 안놓고
        int[][] arr = new int[n + 1][3];
        arr[1][0] = 1;
        arr[1][1] = 1;
        arr[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i][0] = (arr[i-1][1] + arr[i-1][2]) % MOD;
            arr[i][1] = (arr[i-1][0] + arr[i-1][2]) % MOD;
            arr[i][2] = (arr[i-1][0] + arr[i-1][1] + arr[i-1][2]) % MOD;
        }

        int ans = (arr[n][0] + arr[n][1] + arr[n][2]) % MOD;
        bw.write(ans + System.lineSeparator());

        br.close();
        bw.close();
    }
}
