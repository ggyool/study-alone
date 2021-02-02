package JumpGame4;

import java.util.Arrays;


// time exceed
public class JumpGame4 {
    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        int dp[] = new int[len];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                int idx = i + j;
                if (idx == len) break;
                dp[idx] = Math.max(dp[idx], dp[i] + nums[idx]);
            }
        }
        return dp[len - 1];
    }
}
