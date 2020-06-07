package ContiguousArray;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int ret = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int sum = 0;
        int len = nums.length;
        for (int i=0; i< len; ++i) {
            int num = nums[i];
            if(num==0) --sum;
            else ++sum;
            if(mp.containsKey(sum)){
                ret = Math.max(ret, i-mp.get(sum));
            }
            else{
                mp.put(sum, i);
            }
        }
        return ret;
    }
}
