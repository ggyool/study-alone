package boj1004;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int t=0; t<tc; ++t) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(br.readLine());
            Planet[] planets = new Planet[n];
            for (int i=0; i<n; ++i) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                planets[i] = new Planet(x, y, r);
            }
            int ans = 0;
            for (int i=0; i<n; ++i){
                double startDist = calcDistanceSquare(x1, y1, planets[i].x, planets[i].y);
                double finDist = calcDistanceSquare(x2, y2, planets[i].x, planets[i].y);
                int rSquare = planets[i].r * planets[i].r;
                // 다른 행성계에 있는 경우에만 더한다.
                if (startDist <= rSquare && finDist > rSquare) {
                    ++ans;
                }
                if (finDist <= rSquare && startDist > rSquare) {
                    ++ans;
                }
            }
            bw.write(ans + "\n");
        }
        bw.close();
     }

     private static double calcDistanceSquare(int x1, int y1, int x2, int y2) {
        double dx = Math.abs(x1-x2);
        double dy = Math.abs(y1-y2);
        return dx * dx + dy * dy;
     }

}

class Planet{
    int x,y,r;
    public Planet(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}
