package RemoveDuplicatesFromSortedArray2;

public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int j = 2;
        for (int i = 2; i < nums.length; i++) {
            int num = nums[i];
            if (nums[j-2] != num) {
                nums[j++] = num;
            }
        }
        return Math.min(j, nums.length);
    }
}
