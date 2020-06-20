package RemoveElement;

public class RemoveElement {
//    public static int removeElement(int[] nums, int val) {
//        int ret = 0;
//        int len = nums.length;
//        int i =0, j =0;
//        while(i<len && j<len){
//            if(nums[i]!=val) {
//                ++ret;
//                ++i;
//                ++j;
//            }
//            else if(nums[j]==val){
//                ++j;
//            }
//            else{
//                ++ret;
//                nums[i] = nums[j];
//                nums[j] = val;
//                ++i;
//                ++j;
//            }
//        }
//        return ret;
//    }

    public int removeElement(int[] nums, int val) {
        int i=0;
        int len = nums.length;
        for(int j=0; j<len; ++j){
            if(nums[j] != val){
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        //System.out.println(removeElement(nums, 2));

    }
}
