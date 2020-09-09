package FindMinimumInRotatedSortedArray;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        return solve(0, nums.length-1, nums);
    }

    private int solve(int left, int right, int[] nums) {
        if(right-left<=1){
            return Math.min(nums[left], nums[right]);
        }
        int mid = left + (right-left)/2;
        int a = nums[left];
        int b = nums[mid];
        int c = nums[right];
        // 1 2 3
        if(a<c) return a;
        // 3 0 0 0 1 0 0 0 2
        if(a>b) {
            return solve(left+1, mid, nums);
        }
        // 2 3 1
        return solve(mid+1, right, nums);
    }
}
