package LuckyNumbersInAMatrix;

import java.util.ArrayList;
import java.util.List;

// distinct number
public class LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        List<Integer> ret = new ArrayList<>();
        for(int i=0; i<r; ++i){
            int minv = (int)1e5+1;
            int idx = 0;
            for(int j=0; j<c; ++j){
                if(matrix[i][j] < minv){
                    minv = matrix[i][j];
                    idx = j;
                }
            }
            int maxv = -1;
            for(int k=0; k<r; ++k){
                maxv = Math.max(maxv, matrix[k][idx]);
            }
            if(maxv == minv) ret.add(maxv);
        }
        return ret;
    }
}
