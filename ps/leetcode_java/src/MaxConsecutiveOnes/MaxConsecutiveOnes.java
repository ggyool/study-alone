package MaxConsecutiveOnes;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int ret = 0;
        int cnt = 0;
        for(int i=0; i<len; ++i){
            if(nums[i] == 0){
                cnt = 0;
            }
            else{
                ++cnt;
                ret = Math.max(ret , cnt);
            }
        }
        return ret;
    }
}
