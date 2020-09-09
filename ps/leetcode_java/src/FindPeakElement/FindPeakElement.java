package FindPeakElement;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while(left<=right){
            mid = left + (right-left)/2;
            int midLeft = (mid==left) ? Integer.MIN_VALUE : nums[mid-1];
            int midRight = (mid==right) ? Integer.MIN_VALUE : nums[mid+1];
            int val = nums[mid];
            if(midLeft<val && val>midRight) break;
            if(midLeft>val){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return mid;
    }
}


/*
public class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
 */