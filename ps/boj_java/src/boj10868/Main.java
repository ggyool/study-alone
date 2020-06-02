package boj10868;

import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    // O(sqrt(n))
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i=0; i<n; ++i){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int r = (int)Math.sqrt(n);
        int gn = n/r;
        if(n%r>0) ++gn;
        int[] grr = new int[gn];

        for(int i=0; i<n; ++i){
            if(i%r==0){
                grr[i/r] = arr[i];
            }
            else{
                grr[i/r] = Math.min(grr[i/r], arr[i]);
            }
        }


//        int a,b;
//        for(int i=0; i<m; ++i){
//            st = new StringTokenizer(br.readLine());
//            a = Integer.parseInt(st.nextToken());
//            b = Integer.parseInt(st.nextToken());
//        }


        br.close();
        bw.close();
    }
}
