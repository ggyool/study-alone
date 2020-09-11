package temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private int init(int idx, int start, int end, int[] tree, int[] arr){
        if(start==end) return tree[idx] = arr[start];
        int mid = (start+end)/2;
        return tree[idx] = Math.min(init(2*idx, start, mid, tree, arr), init(2*idx+1, mid+1, end, tree, arr));
    }

    private int min(int idx, int start, int end, int left, int right, int[] tree, int[] arr){
        if(right<start || end<left) return Integer.MAX_VALUE;
        if(left<=start && end<=right) return tree[idx];
        int mid = (start+end)/2;
        return Math.min(min(2*idx, start, mid, left, right, tree, arr),
                min(2*idx+1, mid+1, end, left, right, tree, arr));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        for(int i=1; i<=n; ++i){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int size = 1;
        while(size<n){
            size <<= 1;
        }
        int[] tree = new int[size<<1];
        Main sol = new Main();
        sol.init(1, 1, n, tree, arr);
        for(int i=0; i<m; ++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(sol.min(1,1, n, a, b, tree, arr) + "\n");
        }

        br.close();
        bw.close();
    }
}
