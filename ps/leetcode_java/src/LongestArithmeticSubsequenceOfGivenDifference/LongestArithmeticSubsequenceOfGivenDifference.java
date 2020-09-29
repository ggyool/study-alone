package LongestArithmeticSubsequenceOfGivenDifference;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        int len = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int ret = 0;
        for(int i=0; i<len; ++i){
            int val = mp.getOrDefault(arr[i]-difference, 0);
            mp.put(arr[i], val+1);
            ret = Math.max(ret, val+1);
        }
        return ret;
    }
}

