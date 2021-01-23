package MaxNumberOfKSumPairs;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            int other = k - num;
            int otherCount = count.getOrDefault(other, 0);
            if (otherCount > 0) {
                count.put(other, otherCount - 1);
                ans++;
            } else {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }
        }
        return ans;
    }
}
