package boj1011;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for(int t=0; t<tc; ++t) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            long dist = y-x;
            long i = 1;
            while(true){
                long val = i*(i+1)/2 + (i-1)*i/2;
                if(val>dist) break;
                ++i;
            }
            --i;
            long ans = i + i-1;
            long remian = dist - (i*(i+1)/2 + (i-1)*i/2);
            ans += remian/i;
            if(remian%i>0) ++ans;
            bw.write(ans + "\n");
        }
        bw.close();
    }
}
