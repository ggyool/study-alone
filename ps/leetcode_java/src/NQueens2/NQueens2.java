package NQueens2;

public class NQueens2 {
    //  /대각선
    // \대각선 r-c  음수도 나온다.

    boolean[] col;
    boolean[] slash; // (/대각선 r+c)
    boolean[] backSlash; // (\대각선 r-c+N-1)

    private int setQueen(int y, int n){
        if(y==n) return 1;
        int ret = 0;
        for(int i=0; i<n; ++i){
            if(col[i] || slash[y+i] || backSlash[y-i+n-1]) continue;
            col[i] = true;
            slash[y+i] = true;
            backSlash[y-i+n-1] = true;
            ret += setQueen(y+1, n);
            col[i] = false;
            slash[y+i] = false;
            backSlash[y-i+n-1] = false;
        }
        return ret;
    }
    public int totalNQueens(int n) {
        col = new boolean[n];
        slash = new boolean[2*n-1];
        backSlash = new boolean[2*n-1];
        return setQueen(0, n);
    }
}


