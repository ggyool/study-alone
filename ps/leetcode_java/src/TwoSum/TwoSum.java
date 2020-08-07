package TwoSum;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = {0,0};
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; ++i){
            if(mp.containsKey(target-nums[i])){
                ret[0] = mp.get(target-nums[i]);
                ret[1] = i;
                break;
            }
            mp.putIfAbsent(nums[i], i);
        }
        return ret;
    }
}
