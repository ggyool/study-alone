package SearchInRotatedSortedArray_2;

import SearchInRotatedSortedArray.SearchInRotatedSortedArray;

public class SearchInRotatedSortedArray_2 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        // [4,5,6,7,0,1,2]
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // 오른쪽에 있는게 정상 이지만
                // 이런 경우는 왼쪽에 있다는 것
                if (nums[right] < target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            else {
                if (nums[left] > target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray_2 sol = new SearchInRotatedSortedArray_2();
        int[] arr = {4,5,6,7,8,1,2,3};
        System.out.println(sol.search(arr, 0));
    }
}
