package SearchForARange;

public class SearchForARange {
    public int lowerBound(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int mid;
        while(left<right){
            mid = left + (right-left)/2;
            if(nums[mid] >= target){
                right = mid;
            }
            else{
                left = mid +1;
            }
        }
        if(nums[right]!=target) return -1;
        return right;
    }

    public int upperBound(int[] nums, int target){
        int left = 0;
        int right = nums.length; // target이 nums의 마지막이면 length return
        int mid;
        while(left<right){
            mid = left + (right-left)/2;
            if(nums[mid] > target){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return right;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
        int left = lowerBound(nums, target);
        if(left==-1) return new int[]{-1,-1};
        return new int[]{left, upperBound(nums,target)-1};
    }
}
