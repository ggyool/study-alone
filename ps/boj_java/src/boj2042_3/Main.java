package boj2042_3;

import sun.text.SupplementaryCharacterData;

import java.io.*;
import java.util.StringTokenizer;

// binary index tree
public class Main {
    static int n,m,k;
    static long[] arr, tree;

    public static void update(int idx, long diff){
        while(idx<=n){
            tree[idx] += diff;
            idx += (idx & -idx);
        }
    }

    public static long sum(int idx){
        long ret = 0L;
        while(idx>0){
            ret += tree[idx];
            idx -= (idx & -idx);
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        arr = new long[n+1];
        tree = new long[n+1];
        for(int i=1; i<=n; ++i){
            arr[i] = Long.parseLong(br.readLine());
            update(i, arr[i]);
        }
        for(int i=0; i<m+k; ++i){
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            if(a==1){
                long c = Long.parseLong(stz.nextToken());
                update(b, c-arr[b]);
                arr[b] = c;
            }
            else{
                int c = Integer.parseInt(stz.nextToken());
                bw.write(sum(c)-sum(b-1) + "\n");
            }
        }
        bw.close();
    }
}
