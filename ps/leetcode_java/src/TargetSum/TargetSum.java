package TargetSum;

// 배열에는 양수가 있고 모든 원소의 합이 1000을 초과하지 않는다
// dp배열에 -1000~1000까지 들어 갈 수 있으므로 배열 2000칸
// S의 값은 매우 작은 값이나 큰 값이 될 수 있다.
public class TargetSum {
    int[][] dp;
    public int dfs(int idx, int sum, int[] nums, int S){
        if(idx==nums.length){
            if(sum == S) return 1;
            return 0;
        }
        if(dp[idx][sum+1000]!=-1) return dp[idx][sum+1000];
        dp[idx][sum+1000] = 0;
        dp[idx][sum+1000] += dfs(idx+1, sum+nums[idx], nums, S);
        dp[idx][sum+1000] += dfs(idx+1, sum-nums[idx], nums, S);
        return dp[idx][sum+1000];
    }

    public int findTargetSumWays(int[] nums, int S) {
        dp = new int[nums.length][2001];
        for(int i=0; i< nums.length; ++i){
            for(int j=0; j<2001; ++j){
                dp[i][j] = -1;
            }
        }
        return dfs(0, 0, nums, S);
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        TargetSum sol = new TargetSum();
        System.out.println(sol.findTargetSumWays(arr, 3));
    }
}

