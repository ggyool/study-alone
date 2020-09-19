package FlipColumnsForMaximumNumberOfEqualRows;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlipColumnsForMaximumNumberOfEqualRows {



    List<Integer> toggle(List<Integer> list){
        int len = list.size();
        List<Integer> ret = new ArrayList<>();
        for(int i=0; i<len; ++i){
            ret.add(1-list.get(i));
        }
        return ret;
    }

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<List<Integer>, Integer> mp = new HashMap<>();
        for(int i=0; i<matrix.length; ++i){
            List<Integer> list = Arrays.stream(matrix[i]).boxed().collect(Collectors.toList());
            List<Integer> tlist = toggle(list);
            mp.put(list, mp.getOrDefault(list, 0) + 1);
            mp.put(tlist, mp.getOrDefault(tlist, 0) + 1);
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
