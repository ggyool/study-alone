package boj10868_3;


import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

// segment tree - O(m*logn)
public class Main {
    static int[] tree;
    // makeTree
    public static int init(int idx, int start, int end, int[] arr) {
        if(start==end){
            return tree[idx] = arr[start];
        }
        int mid = start + (end-start)/2;
        tree[idx] = Math.min(init(2*idx, start, mid, arr), init(2*idx+1, mid+1, end, arr));
        return tree[idx];
    }

    // start~end 구간에서 l~r 을 찾는다.
    public static int findMinValue(int idx, int start, int end, int l, int r){
        if(start==l && end==r){
            return tree[idx];
        }
        int mid = start + (end-start)/2;
        // 왼쪽에 있는 경우
        if(r<=mid){
            return findMinValue(2*idx, start, mid, l, r);
        }
        // 오른쪽
        else if(l>mid){
            return findMinValue(2*idx+1, mid+1, end, l, r);
        }
        // 겹쳐 있는 경우
        else{
            return Math.min(findMinValue(2*idx, start, mid, l, mid),
                findMinValue(2*idx+1, mid+1, end, mid+1,r));
        }
    }


    // not mine
    public static int findMinValue2(int idx, int start, int end, int i, int j){
        if(i>end || j<start) return -1;
        if(i<=start && end<=j) return tree[idx];
        int m1 = findMinValue2(2*idx, start, (start+end)/2, i, j);
        int m2 = findMinValue2(2*idx+1, (start+end)/2+1, end, i, j);
        if(m1==-1) return m2;
        else if(m2==-1) return m1;
        else return Math.min(m1, m2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int s = 1;
        // 10이면 32개까지 만들어야 한다.
        while(s<n){
            s<<=1;
        }
        tree = new int[s<<1];
        for(int i=1; i<=n; ++i){
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(1, 1, n, arr);
        int a,b;
        while(--m>=0){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(findMinValue2(1,1,n,a,b) + "\n");
            //bw.write(findMinValue(1, 1, n, a, b) + "\n");
        }
        System.out.println(sb);
        br.close();
        bw.close();
    }
}
