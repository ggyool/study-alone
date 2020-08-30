package SearchA2DMatrix2_2;

public class SearchA2DMatrix2_2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        if(r==0) return false;
        int c = matrix[0].length;
        if(c==0) return false;
        int y = r -1;
        int x = 0;
        while(x<c && y>=0){
            int val = matrix[y][x];
            if(val==target) return true;
            else if(val>target) --y;
            else ++x;
        }
        return false;
    }
}

