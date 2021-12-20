package boj2616;

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

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] psum = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i - 1 >= 0) {
                psum[i] = psum[i - 1] + arr[i];
            }
        }
        int m = Integer.parseInt(br.readLine());

        int[] leftMax = new int[n];
        for (int i = 0; i <= n - m; i++) {
            int j = i + m - 1;
            int sum = psum[j] - psum[i] + arr[i];
            leftMax[j] = Math.max(sum, leftMax[j - 1]);
        }

        int[] rightMax = new int[n];
        for (int i = n - m; i >= 0 ; i--) {
            int j = i + m - 1;
            int sum = psum[j] - psum[i] + arr[i];
            rightMax[i] = Math.max(sum, rightMax[i + 1]);
        }

        int ans = 0;
        for (int i = 1; i < n - m - 1; i++) {
            int j = i + m - 1;
            int mid = psum[j] - psum[i - 1];
            int left = leftMax[i - 1];
            int right = rightMax[j + 1];
            ans = Math.max(ans, left + mid + right);
        }
        bw.write(ans + "\n");

        br.close();
        bw.close();
    }
}
