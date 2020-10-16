package MajorityElement2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 공간 O(1) 을 쓰는 Boyer-Moore 풀이가 있는데, 넘어갔다.
public class MajorityElement2 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        int len = nums.length;
        int criteria = len/3 + 1;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int num : nums) {
            int val = mp.getOrDefault(num, 0) + 1;
            mp.put(num, val);
            if(val==criteria) ret.add(num);
        }
        return ret;
    }

}
