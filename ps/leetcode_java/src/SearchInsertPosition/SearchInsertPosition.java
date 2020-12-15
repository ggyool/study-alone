package SearchInsertPosition;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        return solve(nums, target);
    }

    public int solve(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid = 0;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
