package AvailableCapturesForRook;

public class AvailableCapturesForRook {
    public int numRookCaptures(char[][] board) {
        int ry=0 ,rx=0;
        for(int i=0; i<8; ++i){
            for(int j=0; j<8; ++j){
                char c = board[i][j];
                if(c=='R'){
                    ry = i;
                    rx = j;
                }
            }
        }
        int ans = 0;
        for(int i=ry+1; i<8; ++i){
            if(board[i][rx]=='B') break;
            if(board[i][rx]=='p') {
                ++ans;
                break;
            }
        }
        for(int i=ry-1; i>0; --i){
            if(board[i][rx]=='B') break;
            if(board[i][rx]=='p') {
                ++ans;
                break;
            }
        }
        for(int j=rx+1; j<8; ++j){
            if(board[ry][j]=='B') break;
            if(board[ry][j]=='p') {
                ++ans;
                break;
            }
        }
        for(int j=rx-1; j>0; --j){
            if(board[ry][j]=='B') break;
            if(board[ry][j]=='p') {
                ++ans;
                break;
            }
        }
        return ans;
    }

}
