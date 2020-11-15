package boj1002;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main sol = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            bw.write(sol.solve(x1,y1,r1,x2,y2,r2) + "\n");
        }
        bw.close();
    }

    // sqrt 하지 않고 제곱하여 생각
    private int solve(int x1, int y1, int r1, int x2, int y2, int r2){
        int dx = x1-x2;
        int dy = y1-y2;
        int dist = dx*dx + dy*dy;
        int rplus = (r1+r2)*(r1+r2);
        int rminus = (r1-r2)*(r1-r2);
        if(dist==0){
            if(r1==r2) return -1;
            else return 0;
        }
        if(dist>rplus) return 0; // 멀리 떨어져 있는 경우
        else if(dist==rplus) return 1; // 밖으로 접하는 경우
        else if(dist==rminus) return 1; // 안으로 접하는 경우
        else if(dist<rminus) return 0; // 쏙 들어오는 경우
        else return 2;
    }
}
