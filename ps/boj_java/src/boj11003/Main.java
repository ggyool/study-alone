package boj11003;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Pair{
    int idx, val;
    public Pair(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}

// time exceed
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Pair> dq = new ArrayDeque<>();
        int n = Integer.parseInt(stz.nextToken());
        int l = Integer.parseInt(stz.nextToken());
        int[] arr = new int[n+1];
        stz = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; ++i){
            arr[i] = Integer.parseInt(stz.nextToken());
            while(!dq.isEmpty() && dq.getFirst().idx <= i-l){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && dq.getLast().val >= arr[i]){
                dq.pollLast();
            }
            // dq.add(new Pair(i, arr[i]));
            dq.offer(new Pair(i, arr[i]));
            //sb.append(dq.getFirst().val + " ");
            bw.write(dq.getFirst().val + " ");
        }
        bw.close();
    }
}
