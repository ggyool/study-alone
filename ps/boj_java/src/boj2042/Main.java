package boj2042;

import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

// segment tree recursive
public class Main {
    static int n,m,k;
    static long[] arr;
    static long[] tree;

    public static long init(int idx, int left, int right){
        if(left==right) {
            return tree[idx] = arr[left];
        }
        int mid = left + (right-left)/2;
        return tree[idx] = init(2*idx, left, mid) + init(2*idx+1, mid+1, right);
    }
    public static long findSum(int idx, int left, int right, int l, int r){
        if(r<left || right<l) return 0L;
        if(l<=left && right<=r) return tree[idx];
        int mid = left + (right-left)/2;
        return findSum(2*idx, left, mid, l, r) + findSum(2*idx+1, mid+1, right, l, r);
    }

    // target 찾고 돌아오면서 누적
    public static long modify(int idx, int left, int right, int target, long val){
        if(target<left || target>right) return tree[idx];
        if(left==right){
            return tree[idx] = val;
        }
        int mid = left + (right-left)/2;
        return tree[idx] = modify(2*idx, left, mid, target, val) + modify(2*idx+1, mid+1, right, target, val);
    }

    // 찾으러 가면서 누적
    public static void update(int idx, int left, int right, int target, long diff){
        if(target<left || target>right) return;
        if(left==right) {
            arr[left] += diff;
            tree[idx] += diff;
            return;
        }
        tree[idx] += diff;
        int mid = left + (right-left)/2;
        update(2*idx, left, mid, target, diff);
        update(2*idx+1, mid+1, right, target, diff);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        arr = new long[n+1];
        for(int i=1; i<=n; ++i){
            arr[i] = Long.parseLong(br.readLine());
        }
        int s = 1;
        while(s<n){
            s <<= 1;
        }
        s <<= 1;
        tree = new long[s];
        init(1, 1, n);
        long a,b,c;
        for(int i=0; i<k+m; ++i){
            stz = new StringTokenizer(br.readLine());
            a = Long.parseLong(stz.nextToken());
            b = Long.parseLong(stz.nextToken());
            c = Long.parseLong(stz.nextToken());
            if(a==1){
                // modify(1,1,n, (int)b, c);
                update(1,1, n, (int)b, c-arr[(int)b]);
            }
            else {
                bw.write(findSum(1,1,n,(int)b,(int)c) + "\n");
            }
        }
        bw.close();
    }
}
