package boj1395;

import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    static boolean[] arr, lazy;
    static int[] tree;
    static int n,m;

    static void chkLazy(int idx, int left, int right){
        if(lazy[idx] == true){
            tree[idx] = (right-left+1) - tree[idx];
            if(left!=right){
                lazy[2*idx] = !lazy[2*idx];
                lazy[2*idx+1] = !lazy[2*idx+1];
            }
            lazy[idx] = false;
        }
    }

    static void toggle(int idx, int left, int right, int l, int r){
        chkLazy(idx, left, right);
        if(right<l || r<left) return;
        if(l<=left && right<=r){
            tree[idx] = (right-left+1) - tree[idx];
            if(left!=right){
                lazy[2*idx] = !lazy[2*idx];
                lazy[2*idx+1] = !lazy[2*idx+1];
            }
            return;
        }
        int mid = left + (right-left)/2;
        toggle(2*idx, left, mid, l, r);
        toggle(2*idx+1, mid+1, right, l, r);
        // 잊기 쉽다 꼭 바꿔줘야 한다.
        tree[idx] = tree[2*idx] + tree[2*idx+1];
    }

    static int count(int idx, int left, int right, int l, int r){
        chkLazy(idx, left, right);
        if(right<l || r<left) return 0;
        if(l<=left && right<=r){
            return tree[idx];
        }
        int mid = left + (right-left)/2;
        return count(2*idx, left, mid, l, r) + count(2*idx+1, mid+1, right, l, r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        arr = new boolean[n+1];
        int ts = 1;
        while(ts<n){
            ts <<= 1;
        }
        ts <<= 1;
        tree = new int[ts];
        lazy = new boolean[ts];

        for(int i=0; i<m; ++i){
            stz = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(stz.nextToken());
            int s = Integer.parseInt(stz.nextToken());
            int t = Integer.parseInt(stz.nextToken());
            if(o==0){
                toggle(1,1,n,s,t);
            }
            else{
                bw.write(count(1,1,n,s,t) + "\n");
            }
        }
        bw.close();
    }
}
