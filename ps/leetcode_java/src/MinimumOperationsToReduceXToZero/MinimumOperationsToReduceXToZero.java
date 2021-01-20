package MinimumOperationsToReduceXToZero;

public class MinimumOperationsToReduceXToZero {
    public int minOperations(int[] nums, int x) {
        int i = -1;
        int j = nums.length;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        while (i < nums.length - 1) {
            sum += nums[++i];
            if (sum == x) {
                ans = i + 1;
                break;
            }
            else if (sum > x) {
                break;
            }
        }
        while (i >= 0) {
            sum -= nums[i--];
            while (i + 1 < j && sum < x) {
                sum += nums[--j];
                if (sum == x) {
                    ans = Math.min(ans, (i + 1) + (nums.length - j));
                }
            }
            if (sum == x) {
                ans = Math.min(ans, (i + 1) + (nums.length - j));
            }
        }
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumOperationsToReduceXToZero sol = new MinimumOperationsToReduceXToZero();
        int[] arr = {3,2,20,1,1,3};
        System.out.println(sol.minOperations(arr, 10));
    }
}
