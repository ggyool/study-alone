package boj1316;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ans = 0;
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; ++i){
            String s = br.readLine();
            if(checkValid(s)) ++ans;
        }
        bw.write(ans + "\n");
        bw.close();
    }

    private static boolean checkValid(String s){
        boolean[] visited = new boolean[26];
        int len = s.length();
        for(int i=0; i<len; ++i){
            char c = s.charAt(i);
            if(visited[c-'a']==false){
                visited[c-'a'] = true;
            }
            else if(c!=s.charAt(i-1)) {
                return false;
            }
        }
        return true;
    }
}
