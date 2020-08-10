package ValidSudoku;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; ++i){
            boolean[] chk = new boolean[10];
            for(int j=0; j<9; ++j){
                char c = board[i][j];
                if(c=='.') continue;
                int num = c - '0';
                if(chk[num]) return false;
                chk[num] = true;
            }
        }
        for(int j=0; j<9; ++j){
            boolean[] chk = new boolean[10];
            for(int i=0; i<9; ++i){
                char c = board[i][j];
                if(c=='.') continue;
                int num = c - '0';
                if(chk[num]) return false;
                chk[num] = true;
            }
        }
        for(int i=0; i<9; ++i) {
            int sty = (i / 3) * 3;
            int stx = (i % 3) * 3;
            boolean[] chk = new boolean[10];
            for (int j = 0; j < 3; ++j) {
                for (int k = 0; k < 3; ++k) {
                    char c = board[sty+j][stx+k];
                    if (c == '.') continue;
                    int num = c - '0';
                    if (chk[num]) return false;
                    chk[num] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
