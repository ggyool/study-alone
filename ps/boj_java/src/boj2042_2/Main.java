package boj2042_2;

import java.io.*;
import java.util.StringTokenizer;

// no recursive
public class Main {

    // s: 마지막 층 시작 idx
    static int n,m,k,s=1;
    static long[] tree;

    public static void update(int idx, long diff){
        idx += s;
        while(idx>0){
            tree[idx] += diff;
            idx /= 2;
        }
    }

    public static long sum(int l, int r){
        long ret = 0L;
        l += s;
        r += s;
        // 1층씩 올라가는게 구현이 편해지는 포인트 인듯
        while(l<r){
            if(l%2==0){
                l /= 2;
            }
            else{
                ret += tree[l];
                l += 1;
                l /= 2;
            }
            if(r%2==0){
                ret += tree[r];
                r -= 1;
                r /= 2;
            }
            else{
                r /= 2;
            }
        }
        if(l==r) ret += tree[l];
        return ret;
    }

    public static void printTree(){
        int j = 1;
        for(int i=1; i<(s<<1); ++i){
            if(i==(1<<j)){
                System.out.println();
                j++;
            }
            System.out.print(tree[i] + " ");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        // n = 5, s=8

        while(s<n){
            s*=2;
        }
        tree = new long[s<<1];
        for(int i=0; i<n; ++i){
            update(i, Integer.parseInt(br.readLine()));
        }
        int a,b;
        long c;
        for(int i=0; i<m+k; ++i){
            stz = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stz.nextToken());
            b = Integer.parseInt(stz.nextToken());
            c = Long.parseLong(stz.nextToken());
            b--;
            if(a==1){
                update(b, c-tree[s+b]);
            }
            else{
                c--;
                bw.write(sum(b,(int)c) + "\n");
            }
        }
        bw.close();
    }
}

