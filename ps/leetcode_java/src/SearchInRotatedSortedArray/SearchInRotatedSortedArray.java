package SearchInRotatedSortedArray;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int pidx = searchPivot(nums);

        int leftRes = binearySearch(nums, 0, pidx - 1, target);
        int rightRes = binearySearch(nums, pidx, nums.length - 1, target);

        if (leftRes != -1) return leftRes;
        if (rightRes != -1) return rightRes;
        return -1;
    }

    private int binearySearch(int[] nums, int left, int right, int target) {
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int searchPivot(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray sol = new SearchInRotatedSortedArray();
        int[] arr = {3,4,5,6,1,2};
        System.out.println(sol.search(arr, 2));
    }
}
