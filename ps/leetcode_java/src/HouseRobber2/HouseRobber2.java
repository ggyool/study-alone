package HouseRobber2;

import java.util.Arrays;

public class HouseRobber2 {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int ret = nums[0];
        dp[0] = nums[0];
        // 처음 선택
        for (int i = 2; i <= len - 2; i++) {
            if (i == 2) dp[i] = nums[i] + dp[i-2];
            else dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
            ret = Math.max(ret, dp[i]);
        }

        // 두번째 선택
        Arrays.fill(dp, 0);
        if (len >= 2) {
            dp[1] = nums[1];
            ret = Math.max(ret, dp[1]);
        }
        for (int i = 3; i <= len - 1; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
            ret = Math.max(ret, dp[i]);
        }

        // 세번째 선택
        Arrays.fill(dp, 0);
        if (len >= 3) {
            dp[2] = nums[2];
            ret = Math.max(ret, dp[2]);
        }
        for (int i = 4; i <= len - 1; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
