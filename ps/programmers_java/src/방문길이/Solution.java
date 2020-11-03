package 방문길이;

public class Solution {

    private boolean inRange(int y, int x){
        if(y<0 || x<0 || y>10 || x>10) return false;
        return true;
    }

    private int charToDir(char c){
        if(c=='R') return 0;
        else if(c=='D') return 1;
        else if(c=='L') return 2;
        return 3;
    }

    public int solution(String dirs) {
        // y x dir
        boolean[][][] visited = new boolean[11][11][4];
        final int[] dy = {0,1,0,-1};
        final int[] dx = {1,0,-1,0};
        int answer = 0;
        int y = 5, x = 5;
        for(int i=0; i<dirs.length(); ++i){
            int dir = charToDir(dirs.charAt(i));
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(!inRange(ny, nx)) continue;
            if(!visited[y][x][dir]) {
                int oppositeDir = (dir+2)%4;
                visited[y][x][dir] = true;
                visited[ny][nx][oppositeDir] = true;
                ++answer;
            }
            y = ny;
            x = nx;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("ULURRDLLU"));
    }
}
