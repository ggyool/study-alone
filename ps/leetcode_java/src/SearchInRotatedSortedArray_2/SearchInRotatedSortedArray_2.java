package SearchInRotatedSortedArray_2;

public class SearchInRotatedSortedArray_2 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        int val = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            val = nums[mid];
            if (val == target) {
                return mid;
            }
            // left group or non pivot
            if (val >= nums[left]) {
                if (val < target) {
                    left = mid + 1;
                }
                if (target < val) {
                    if (target >= nums[left])
                        right = mid - 1;
                    else
                        left = mid + 1;
                }
            }
            // right group
            else {
                if (target < val) {
                    right = mid - 1;
                }
                if (val < target) {
                    if (target <= nums[right])
                        left = mid + 1;
                    else
                        right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray_2 sol = new SearchInRotatedSortedArray_2();
        int[] arr = {1};
        System.out.println(sol.search(arr, 0));
    }
}
