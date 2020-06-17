package boj10999;

import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {

    static long[] arr, tree;
    static long init(int idx, int left, int right){
        if(left==right){
            return tree[idx] = arr[left];
        }
        int mid = left + (right-left)/2;
        return tree[idx] = init(2*idx, left, mid) + init(2*idx+1, mid+1, right);
    }

    static long sum(int idx, int left, int right, int l, int r){
        if(right<l || r<left) return 0L;
        if(l<=left && right<=r) {
            return tree[idx];
        }
        int mid = left + (right-left)/2;
        return sum(2*idx, left, mid, l, r) + sum(2*idx+1, mid+1, right, l, r);
    }

    // time exceed
    // l~r 구간에 val 만큼 더한다.
    static long update(int idx, int left, int right, int l, int r, long val){
        // update 하지 않는 구간도 return 해야 같이 누적된다.
        if(right<l || r<left) return tree[idx];
        if(left==right){
            return tree[idx] = tree[idx] + val;
        }
        int mid = left + (right-left)/2;
        return tree[idx] = update(2*idx, left, mid, l, r, val) + update(2*idx+1, mid+1, right, l, r, val);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());
        int s = 1;
        while(s<n){
            s <<= 1;
        }
        s <<= 1;
        tree = new long[s];
        arr = new long[n+1];
        for(int i=1; i<=n; ++i){
            arr[i] = Integer.parseInt(br.readLine());
        }


        init(1, 1, n);

        for(int i=0; i<m+k; ++i){
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            if(a==1){
                // b~c에 d를 더한다.
                int b = Integer.parseInt(stz.nextToken());
                int c = Integer.parseInt(stz.nextToken());
                long d = Long.parseLong(stz.nextToken());
                update(1,1,n,b,c,d);
            }
            else{
                int b = Integer.parseInt(stz.nextToken());
                int c = Integer.parseInt(stz.nextToken());
                bw.write(sum(1,1,n,b,c) + "\n");
            }
        }
        bw.close();

    }
}
