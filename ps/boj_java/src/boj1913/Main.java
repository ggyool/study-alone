package boj1913;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Main sol = new Main();
        sol.solve();
    }

    int n;
    int findValue;
    int[][] arr;
    // 남동북서
    final int[] dy = {1,0,-1,0};
    final int[] dx = {0,1,0,-1};

    private boolean inRange(int y, int x){
        if(y<=0 || x<=0 || y>n || x>n) return false;
        return true;
    }

    private void solve() throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = scanner.nextInt();
        findValue = scanner.nextInt();
        arr = new int[n+1][n+1];
        int y = 1;
        int x = 1;
        int d = 0;
        int ay=0, ax=0;
        int num = n*n;
        while(num>0) {
            if(num==findValue) {
                ay = y;
                ax = x;
            }
            arr[y][x] = num;
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(!inRange(ny,nx) || arr[ny][nx]!=0){
                d = (d+1)%4;
                ny = y + dy[d];
                nx = x + dx[d];
            }
            y = ny;
            x = nx;
            --num;
        }
        for(int i=1; i<=n; ++i){
            for(int j=1; j<=n; ++j){
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.write(ay + " " + ax);
        bw.close();
    }
}
