package HouseRobber;

public class HouseRobber {
    public int rob(int[] nums) {
        int ret = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int val = 0;
            if (i-2 >= 0) {
                val = Math.max(val, dp[i-2]);
            }
            if (i-3 >= 0) {
                val = Math.max(val, dp[i-3]);
            }
            dp[i] = nums[i] + val;
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
