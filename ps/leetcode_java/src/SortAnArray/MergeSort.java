package SortAnArray;

public class MergeSort {
    private void merge(int left, int right, int[] nums){
        if(left>=right) return;
        int mid = left + (right-left)/2;
        merge(left, mid, nums);
        merge(mid+1, right, nums);

        int[] arr = new int[right-left+1];
        int idx = 0, i=left, j=mid+1;
        while(i<=mid && j<=right){
            if(nums[i]<=nums[j]){
                arr[idx++] = nums[i++];
            }
            else{
                arr[idx++] = nums[j++];
            }
        }
        while(i<=mid){
            arr[idx++] = nums[i++];
        }
        while(j<=right){
            arr[idx++] = nums[j++];
        }
        idx = 0;
        for(i=left; i<=right; ++i) {
            nums[i] = arr[idx++];
        }
    }
    public int[] sortArray(int[] nums) {
        merge(0, nums.length-1, nums);
        return nums;
    }
}
