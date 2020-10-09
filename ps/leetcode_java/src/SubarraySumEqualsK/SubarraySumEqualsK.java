package SubarraySumEqualsK;

import java.util.HashMap;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        int sum = 0;
        // 0~i까지 선택한 경우 세기 위해 넣어야함
        mp.put(0, 1);
        for(int i=0; i<n; ++i){
            sum += nums[i];
            ans += mp.getOrDefault(sum-k, 0);
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}

