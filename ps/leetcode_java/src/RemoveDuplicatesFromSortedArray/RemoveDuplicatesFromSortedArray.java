package RemoveDuplicatesFromSortedArray;

public class RemoveDuplicatesFromSortedArray {
//    public int removeDuplicates(int[] nums) {
//        int len = nums.length;
//        int i = 0;
//        int j = 0;
//        while(j<len){
//            if(nums[i] == nums[j]){
//                ++j;
//            }
//            else{
//                nums[++i] = nums[j];
//            }
//        }
//        return i+1;
//    }
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j=0; j<nums.length; ++j){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
}
