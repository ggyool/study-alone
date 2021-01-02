package CheckArrayFormationThroughConcatenation;

import java.util.HashMap;
import java.util.Map;

// piece의 항목의 수와 arr의 수는 같다는 가정이 있다.

public class CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        // start 로 시작하는 조각이 pieces 의 몇 번째 조각인지
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            int start = pieces[i][0];
            mp.put(start, i);
        }
        int i = 0;
        while (i < arr.length) {
            int start = arr[i];
            Integer idx = mp.get(start);
            if (idx == null) {
                return false;
            }
            for (int num : pieces[idx]) {
                if (arr[i++] != num) {
                    return false;
                }
            }
        }
        return true;
    }
}
