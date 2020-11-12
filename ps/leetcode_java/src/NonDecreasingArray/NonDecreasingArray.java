package NonDecreasingArray;

public class NonDecreasingArray {
    // 영어 해석이 잘 안되서 좀 헤맴
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for(int i=0; i<nums.length-1; ++i){
            if(nums[i] > nums[i+1]) {
                if(cnt==1) return false;
                if(i==0 || nums[i-1]<=nums[i+1]) {
                    nums[i] = nums[i+1];
                }
                else{
                    nums[i+1] = nums[i];
                }
                ++cnt;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NonDecreasingArray sol = new NonDecreasingArray();
        int[] arr = {1,1,1};
        System.out.println(sol.checkPossibility(arr));
    }
}
