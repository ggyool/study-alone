package FlipColumnsForMaximumNumberOfEqualRows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FlipColumnsForMaximumNumberOfEqualRows {



    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<List<Integer>, Integer> mp = new HashMap<>();
        for(int i=0; i<matrix.length; ++i){
            // 무조건 0으로 시작하게 넣기
            List<Integer> list = new ArrayList<>();
            if(matrix[i][0] == 0){
                for(int j=0; j<matrix[i].length; ++j){
                    list.add(matrix[i][j]);
                }
            }
            else{
                for(int j=0; j<matrix[i].length; ++j){
                    list.add(1-matrix[i][j]);
                }
            }
            mp.put(list, mp.getOrDefault(list, 0) + 1);
        }
        int ans = 0;
        for(List<Integer> key : mp.keySet()) {
            ans = Math.max(ans, mp.get(key));
        }
        return ans;
    }

    public static void main(String[] args) {
        FlipColumnsForMaximumNumberOfEqualRows sol = new FlipColumnsForMaximumNumberOfEqualRows();

        int[][] arr = {{0,0,0},{0,0,1}, {1,1,0}};

        System.out.println(sol.maxEqualRowsAfterFlips(arr));
    }

}
