package boj2357;

import java.io.*;
import java.util.StringTokenizer;

class Answer{
    int minAns=Integer.MAX_VALUE, maxAns=0;
}

public class Main {
    public static int n, m;
    public static int[] arr;
    public static int[] maxTree;
    public static int[] minTree;

    // makeTree
    public static void init(int idx, int left, int right){
        if(left==right){
            maxTree[idx] = arr[left];
            minTree[idx] = arr[left];
            return;
        }
        int mid = left + (right-left)/2;

        init(2*idx, left, mid);
        init(2*idx+1, mid+1, right);

        maxTree[idx] = Math.max(maxTree[2*idx], maxTree[2*idx+1]);
        minTree[idx] = Math.min(minTree[2*idx], minTree[2*idx+1]);
    }

    public static void findValue(int idx, int left, int right, int l, int r, Answer answer){
        if(r<left || right<l) return;
        if(l<=left && right<=r) {
            answer.maxAns = Math.max(answer.maxAns, maxTree[idx]);
            answer.minAns = Math.min(answer.minAns, minTree[idx]);
            return;
        }
        int mid = left + (right-left)/2;
        findValue(2*idx, left, mid, l, r, answer);
        findValue(2*idx+1, mid+1, right, l, r, answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n  = Integer.parseInt(st.nextToken());
        m  = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        for(int i=1; i<=n; ++i){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int s = 1;
        while((1<<s) < n){
            ++s;
        }
        ++s;

        maxTree = new int[1<<s];
        minTree = new int[1<<s];

        init(1, 1, n);

        for(int i=0; i<m; ++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Answer answer = new Answer();
            findValue(1,1,n,a,b,answer);
            sb.append(answer.minAns + " " + answer.maxAns + "\n");
        }
        System.out.println(sb);
        bw.close();
    }
}
