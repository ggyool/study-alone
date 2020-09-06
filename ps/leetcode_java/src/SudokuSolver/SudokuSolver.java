package SudokuSolver;

public class SudokuSolver {

    boolean[][] row;
    boolean[][] col;
    boolean[][] sqr;

    private boolean isAble(int y, int x, int num){
        int idx = 3*(y/3) + x/3;
        return !row[y][num] && !col[x][num] && !sqr[idx][num];
    }

    private boolean fill(int y, int x, char[][] board){
        if(y==9) return true;
        if(x==9) {
            return fill(y+1, 0, board);
        }
        // square index
        int idx = 3*(y/3) + x/3;
        if(board[y][x] != '.') {
            return fill(y,x+1, board);
        }
        for(int i=1; i<=9; ++i){
            if(isAble(y,x,i)){
                row[y][i] = true;
                col[x][i] = true;
                sqr[idx][i] = true;
                board[y][x] = (char)(i+'0');
                if(fill(y,x+1, board)){
                    return true;
                }
                row[y][i] = false;
                col[x][i] = false;
                sqr[idx][i] = false;
                board[y][x] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        row = new boolean[9][10];
        col = new boolean[9][10];
        sqr = new boolean[9][10];
        for(int i=0; i<9; ++i) {
            for(int j=0; j<9; ++j){
                if(board[i][j]=='.') continue;
                int num = board[i][j] - '0';
                int idx = 3*(i/3) + j/3;
                row[i][num] = true;
                col[j][num] = true;
                sqr[idx][num] = true;
            }
        }
        fill(0, 0, board);
    }
}
