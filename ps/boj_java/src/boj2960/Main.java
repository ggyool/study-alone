package boj2960;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        boolean[] visited = new boolean[n+1];
        for(int i=2; i<=n; ++i){
            for(int j=i; j<=n; j+=i) {
                if(visited[j]==false) {
                    visited[j] = true;
                    --k;
                    if (k == 0) {
                        System.out.println(j);
                        i = n + 1;
                        break;
                    }
                }
            }
        }
    }
}
